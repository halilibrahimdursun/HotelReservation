package com.application.service;

import com.application.model.Reservation;

import java.util.List;

public class ReservationServiceTest {

    static ReservationService reservationService = new ReservationServiceImpl();

    private static void stockTest(int minimumStock, int expectedNumberOfreservations){
        List<Reservation> test = reservationService.checkStock(minimumStock);
        if(test.size() == expectedNumberOfreservations){
            System.out.println("Test passed.");
        }else{
            System.out.println("Test failed!");
        }
    }
    public static void main(String[] args) {
        Reservation reservation1 = new Reservation("bike2000", "Electrical bike for sporty people", 3823.54D, "this is a picture".getBytes(), 12);
        Reservation reservation2 = new Reservation("bike4650", "Economy bike", 2234.99D, "this is a picture os a cheap bike".getBytes(), 3);
        Reservation reservation3 = new Reservation("bike7650", "Economy bike", 2234.99D, "this is a picture os a cheap bike".getBytes(), 7);
        reservationService.save(reservation1);
        reservationService.save(reservation2);
        reservationService.save(reservation3);
//12 3 7
        stockTest(5, 1);
        stockTest(1, 0);
        stockTest(100, 3);
        stockTest(11, 2);


    }
}
