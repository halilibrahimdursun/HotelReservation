package com.application.service;

import com.application.model.Reservation;
import com.application.model.Room;
import com.application.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


//
//@Service
//public class RoomServiceImpl implements RoomService {
//    @Autowired
//    RoomRepository roomRepository;
//    @Override
//    public Iterable<Room> findAll() {
//        return roomRepository.findAll();
//    }
//    @Override
//    public Optional<Room> findById(long id){
//        return roomRepository.findById(id);
//
//    }
//    @Override
//    public Room save(Room room) {
//
//        return roomRepository.save(room);
//    }
//
//    @Override
//    public void remove(long id) {
//
//    }
//
//    @Override
//    public Iterable<Room> findAllFiltered(Room room) {
//        List<Room> rooms = (List<Room>) roomRepository.findAll();
//
//        Iterable<Room> filtered = rooms
//                .stream()
//                .filter(checkRoom -> checkRoom.isCleaned() == room.isCleaned())
//                .filter(checkRoom -> checkRoom.isDisabled() == room.isDisabled())
////                .filter(checkRoom -> checkRoom.isSmoking() == room.isSmoking())
////                .filter(checkRoom -> checkRoom.getTypeOfRoom() == checkRoom(checkRoom))
//                .toList();
//        return filtered;
//    }
//
//    private String checkRoom(Room checkRoom) {
//
//        if (checkRoom.getCapacityOfAdults() == 1 && checkRoom.getCapacityOfChildren() == 0) {
//            return "single bed";
//        } else if (checkRoom.getCapacityOfAdults() == 1 && checkRoom.getCapacityOfChildren() <= 1) {
//            return "single bed + children";
//        } else if (checkRoom.getCapacityOfAdults() <= 2 && checkRoom.getCapacityOfChildren() == 0) {
//            return "double bed";
//        } else if (checkRoom.getCapacityOfAdults() <= 2 && checkRoom.getCapacityOfChildren() <= 2) {
//            return "double bed or 2 x single bed + children";
//        } else if (checkRoom.getCapacityOfAdults() <= 4 && checkRoom.getCapacityOfChildren() <= 2) {
//            return "2 x Double bed + children";
//        } else if (checkRoom.getCapacityOfAdults() <= 8 && checkRoom.getCapacityOfChildren() <= 2) {
//            return "base penthouse";
//        } else if (checkRoom.getCapacityOfAdults() <= 10 && checkRoom.getCapacityOfChildren() <= 2) {
//            return "luxury penthouse";
//        }
//        return null;
//    }}


import com.application.model.Room;
import com.application.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//    @Override
//    public Iterable<Room> findAllFiltered(Room room) {
//        List<Room> rooms = (List<Room>) roomRepository.findAll();
//
//
//        Iterable<Room> filtered = rooms
//                .stream()
//               // .filter(checkRoom -> checkRoom.getCheckInDate() == reservations.getCheckInDate())
//               // .filter(checkRoom ->checkRoom.getCheckOutDate() == reservations.getCheckOutDate())
//
//
//                .filter(checkRoom -> checkRoom.isCleaned() == room.isCleaned())
//                .filter(checkRoom -> checkRoom.isDisabled() == room.isDisabled())
//                .filter(checkRoom -> checkRoom.isSmoking() == room.isSmoking())
//                .filter(checkRoom -> checkRoom.getTypeOfRoom() == checkRoom(checkRoom))
//                .toList();
//        return filtered;
//    }



//    @Override
//    public List<Room> findAllFiltered(Room criteria, Date startDate, Date endDate) {
//
//        Iterable<Reservation> reservations = reservationService.findAll();
//
//        List<Long> roomIds = new ArrayList<>();
//
//        for(Reservation reservation: reservations){
//            roomIds.add(reservation.getRoom().getId());
//        }
//
//        Iterable<Room> allRooms = roomRepository.findAll();
//
//        List<Room> availableRooms = new ArrayList<>();
//
//        for( Room room: allRooms){
//
//          if(roomIds.contains(room.getId() )){
//              continue;
//          }
//            if( room.isDisabled() == criteria.isDisabled()){
//                availableRooms.add(room);
//            }
//           if( criteria.isSmoking() == room.isSmoking()){
//               continue;
//            }
//            if( criteria.isCleaned() != room.isCleaned()){
//              continue;
//            }
//            if( criteria.getCapacityOfAdults() > 0 && criteria.getCapacityOfAdults() > room.getCapacityOfAdults()){
//                continue;
//           }
//
//        }

//        return availableRooms;
//
//    }


    @Override
    public List<Room> findAllFiltered(Room criteria, Date startDate, Date endDate) {

        Iterable<Reservation> reservations = reservationService.findReservationByEndDateBeforeAndStartDateAfter(startDate, endDate);

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
            availableRooms.add( room);
        }

        return availableRooms;

    }

    private String checkRoom(Room checkRoom) {

        if (checkRoom.getCapacityOfAdults() == 1 && checkRoom.getCapacityOfChildren() == 0) {
            return "single bed";
        } else if (checkRoom.getCapacityOfAdults() == 1 && checkRoom.getCapacityOfChildren() <= 1) {
            return "single bed + children";
        } else if (checkRoom.getCapacityOfAdults() <= 2 && checkRoom.getCapacityOfChildren() == 0) {
            return "double bed";
        } else if (checkRoom.getCapacityOfAdults() <= 2 && checkRoom.getCapacityOfChildren() <= 2) {
            return "double bed or 2 x single bed + children";
        } else if (checkRoom.getCapacityOfAdults() <= 4 && checkRoom.getCapacityOfChildren() <= 2) {
            return "2 x Double bed + children";
        } else if (checkRoom.getCapacityOfAdults() <= 8 && checkRoom.getCapacityOfChildren() <= 2) {
            return "base penthouse";
        } else if (checkRoom.getCapacityOfAdults() <= 10 && checkRoom.getCapacityOfChildren() <= 2) {
            return "luxury penthouse";
        }
        return null;
    }}
