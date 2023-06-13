package com.application.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;    // This is reservation ID !!!
    //    private int roomNumber;
    @Column(name = "CHECK_IN_DATE")
    private Date checkInDate;
    @Column(name = "CHECK_OUT_DATE")
    private Date checkOutDate;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEPHONE_NUMBER")
    private String telephoneNumber;
    @Column(name = "NUMBER_OF_ADULTS")
    private int numberOfAdults;
    @Column(name = "NUMBER_OF_CHILDREN")
    private int numberOfChildren;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservation() {
    }

    public Reservation(Date checkInDate, Date checkOutDate, String name, String surName, String email, String telephoneNumber, int numberOfAdults, int numberOfChildren, Room room) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }
}