package com.application.service;

import com.application.model.Reservation;
import com.application.model.Room;
import com.application.repositories.ReservationRepository;
import com.application.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Optional;


@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoomRepository roomRepository;


    @Override
    public Iterable<Reservation> findAll() {
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
    public Iterable<Reservation> filterReservationForVegan(Reservation reservation) {
        return null;
    }

    @Override
    public Iterable<Reservation> findAllFiltered(Reservation reservation) {
        return null;
    }

    @Override
    public Iterable<Reservation> findReservationByEndDateBeforeAndStartDateAfter(Date startDate, Date endDate) {
        return reservationRepository.findReservationByEndDateAfterAndStartDateBefore(startDate, endDate);
    }



    public  double counter (LocalDate startDate, LocalDate endDate , Room  room){

     double discount = 20;

            long noOfDays = ChronoUnit.DAYS.between( startDate,  endDate);


        double result = noOfDays * room.getPrice();

        double result1 = result-((result * discount) / 100);



return result1;
    }
        }





   /* public static Room roomCheck(long id){
        List<Room> rooms = new ArrayList<>();
        for (Room room : rooms);
        if()



    }
*/

