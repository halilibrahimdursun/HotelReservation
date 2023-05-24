package com.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int roomNumber;
    private String telephoneNumber;
    private String email;
    private int guests;
    private LocalDate date;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Reservation() {
    }

    public Reservation(int roomNumber, String telephoneNumber, String email, int guests, LocalDate date, LocalDate checkInDate, LocalDate checkOutDate) {
        this.roomNumber = roomNumber;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.guests = guests;
        this.date = date;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public LocalDate getDate() {
        return date;
    }


//    @Override
//    public String toString() {
//        return "Reservation{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", price=" + price +
//                ", images=" + Arrays.toString(image) +
//                ", stock=" + stock +
//                '}';
//
//    }

    public void setDate(LocalDate date) {
        this.date = date;
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
