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
    long id;
    int tableNumber;
    String telephoneNumber;
    String email;
    int guests;
    LocalDate date;

    public Reservation() {
    }

    public Reservation(int tableNumber, String telephoneNumber, String email, int guests, boolean vegan, LocalDate date) {
        this.tableNumber = tableNumber;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.guests = guests;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
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

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", images=" + Arrays.toString(image) +
                ", stock=" + stock +
                '}';

    }
}
