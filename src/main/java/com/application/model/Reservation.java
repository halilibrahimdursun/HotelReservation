package com.application.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "RESERVATION_NUMBER")
    private int reservationNumber;

    @Column(name = "ROOM_NUMBER")
    private int roomNumber;

    @Column(name = "TELEPHONE_NUMBER")
    private String telephoneNumber;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "GUESTS")
    private String guests;
    @Column(name = "CHECK_IN_DATE")
    private LocalDate checkInDate;
    @Column(name = "CHECK_OUT_DATE")
    private LocalDate checkOutDate;


    public Reservation() {
    }

    public Reservation(long id, int reservationNumber, int roomNumber, String telephoneNumber, String email, String guests, LocalDate checkInDate, LocalDate checkOutDate) {
        this.id = id;
        this.reservationNumber = reservationNumber;
        this.roomNumber = roomNumber;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.guests = guests;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGuests() {
        return guests;
    }

    public void setGuests(String guests) {
        this.guests = guests;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
