package com.application.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    SEQUENCE, generator ="room_generator"
//            @SequenceGenerator(name="room_generator", sequenceName = "room_seq")
    long id;
    long roomNumber;
    String floor;
    String roomType;
    int adults;
    int childrenBaby;
    String comments;
    String facilities;
    String bedType;
    int price;

    public Room() {
    }
    public Room(long roomNumber, String floor, String roomType, int adults, int childrenBaby, String bedType, String comments, String facilities, int price) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.roomType = roomType;
        this.adults = adults;
        this.childrenBaby = childrenBaby;
        this.bedType = bedType;
        this.comments = comments;
        this.facilities = facilities;
        this.price = price;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildrenBaby() {
        return childrenBaby;
    }

    public void setChildrenBaby(int childrenBaby) {
        this.childrenBaby = childrenBaby;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
