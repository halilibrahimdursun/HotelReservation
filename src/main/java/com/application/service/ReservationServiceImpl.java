package com.application.service;

import com.application.model.Reservation;
import com.application.model.Room;
import com.application.repositories.ReservationRepository;
import com.application.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;


@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoomRepository roomRepository;


    @Override
    public Iterable<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findById(long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation save(Reservation reservation) {

        return reservationRepository.save(reservation);
    }

    @Override
    public void remove(long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Iterable<Reservation> findAllFiltered(Reservation reservation) {
        return null;
    }

    @Override
    public Iterable<Reservation> findReservationByCheckOutDateBeforeAndCheckInDateAfter(Date checkInDate, Date checkOutDate) {
        return reservationRepository.findReservationByCheckOutDateAfterAndCheckInDateBefore(checkInDate, checkOutDate);
    }
    @Override
    public ResponseEntity<Reservation> calculateCancellationPolicy(Optional<Reservation> reservation) {
        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = reservation.get().getCheckInDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
        long daysBeforeCheckIn = ChronoUnit.DAYS.between(currentDate, startDate);

        if (daysBeforeCheckIn >= 15) {
            // Two weeks before check-in: charge 50% of the total amount
            applyCancellationPolicy(reservation, 0.5);
        } else if (daysBeforeCheckIn >= 7 && daysBeforeCheckIn < 14) {
            // One week before check-in: charge 75% of the total amount
            applyCancellationPolicy(reservation, 0.75);
        } else {
            // Less than one week: charge 100% of the total amount
            applyCancellationPolicy(reservation, 1.0);
        }
        return null;
    }

    private void applyCancellationPolicy(Optional<Reservation> reservation, double cancellationRate) {
        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = reservation.get().getCheckInDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
        long daysBeforeCheckIn = ChronoUnit.DAYS.between(currentDate, startDate);
        Room room = reservation.get().getRoom();
        double totalAmount = counter(reservation.get().getCheckInDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                reservation.get().getCheckOutDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), room);
        double cancellationAmount = totalAmount * cancellationRate;
        reservation.get().setCancellationPolicy("Cancellations made within [" +daysBeforeCheckIn+ "] days will receive a "+ (100 -(int)(cancellationRate * 100)) + "% refund.\n" +
                "Total Amount: $" + totalAmount + "\n" +
                "Refund: $" + (totalAmount - cancellationAmount));
    }
    /* ================Discount=============*/
    public  double counter (LocalDate checkInDate, LocalDate checkOutDate , Room  room){
        long noOfDays = ChronoUnit.DAYS.between( checkInDate,  checkOutDate);
        double result = noOfDays * room.getPrice();
        return result;
    }
}





   /* public static Room roomCheck(long id){
        List<Room> rooms = new ArrayList<>();
        for (Room room : rooms);
        if()



    }
*/
