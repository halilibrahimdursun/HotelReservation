package com.application.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    long totallyPrice;
    private long id;
    private int roomNumber;
    private String telephoneNumber;
    private String email;
    private int guests;
    private Date date;
    private Date startDate;
    private Date endDate;
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

    public Reservation(long totallyPrice, int roomNumber, String telephoneNumber, String email, int guests, Date date, Date startDate, Date endDate) {
        this.roomNumber = roomNumber;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.guests = guests;
        this.date = date;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totallyPrice = totallyPrice;
    }

    public long getTotallyPrice() {
        return totallyPrice;
    }

    public void setTotallyPrice(long totallyPrice) {
        this.totallyPrice = totallyPrice;
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


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
