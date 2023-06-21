package com.application.service;

import com.application.model.Reservation;
import com.application.model.Room;
import com.application.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ReservationService reservationService;
    @Override
    public Iterable<Room> findAll() {
        return roomRepository.findAll();
    }
    @Override
    public Optional<Room> findById(long id){
        return roomRepository.findById(id);
    }
    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }
    @Override
    public void remove(long id) {
        roomRepository.deleteById(id);
    }

    @Override

    public List<Room> findAllFiltered(Room criteria, Date checkInDate, Date checkOutDate) {

        Iterable<Reservation> reservations = reservationService.findReservationByCheckOutDateBeforeAndCheckInDateAfter(checkInDate, checkOutDate);


        List<Long> roomIds = new ArrayList<>();

        for(Reservation reservation: reservations){
            roomIds.add(reservation.getRoom().getId());
        }

        Iterable<Room> allRooms = roomRepository.findAll();

        List<Room> availableRooms = new ArrayList<>();

        for( Room room: allRooms){

            if(roomIds.contains(room.getId() )){
                continue;
            }
            if( criteria.isDisabled() != room.isDisabled()){
                continue;
            }
            if( criteria.isSmoking() != room.isSmoking()){
                continue;
            }
            if( criteria.isCleaned() != room.isCleaned()){
                continue;
            }
            if( criteria.getCapacityOfAdults() > 0 && criteria.getCapacityOfAdults() > room.getCapacityOfAdults()){
                continue;
            }
            if( criteria.getCapacityOfChildren() > room.getCapacityOfChildren()){
                continue;
            }
            availableRooms.add( room);
        }

        return availableRooms;
    }


    @Override
    public Room findByRoomNumber(int roomNumber) {
        return roomRepository.findByRoomNumber( roomNumber);
    }
    @Override
    public List<Room> findAllCleanedFalse() {
        Iterable<Room> allRooms = roomRepository.findAll();

        List<Room> notCleanedRooms = new ArrayList<>();
        for( Room room: allRooms){

            if(!room.isCleaned()) {
                notCleanedRooms.add(room);
            }
        }

        return notCleanedRooms;
    }
}

