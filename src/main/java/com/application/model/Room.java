package com.application.model;

import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    long Id;
    int roomNumber;
    boolean smoking;
    double price;
    String typeOfRoom;

    int capacityOfAdults;
    int capacityOfChildren;
    int capacityOfGuests;
    String typeOfBed;

    boolean disabled;
    String facilities;
    String imageLink;

    boolean cleaned;
//


    public Room(boolean smoking, double price, String typeOfRoom, int capacityOfAdults, int capacityOfChildren, int capacityOfGuests, String typeOfBed, boolean disabled, String facilities, String imageLink, boolean cleaned, int roomNumber) {
        this.smoking = smoking;
        this.price = price;
        this.typeOfRoom = typeOfRoom;
        this.capacityOfAdults = capacityOfAdults;
        this.capacityOfChildren = capacityOfChildren;
        this.capacityOfGuests = capacityOfGuests;
        this.typeOfBed = typeOfBed;
        this.disabled = disabled;
        this.facilities = facilities;
        this.imageLink = imageLink;
        this.cleaned = cleaned;
        this.roomNumber = roomNumber;
//
    }
    public Room(){

    }

    public long getId() {
        return Id;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public double getPrice() {
        return price;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public int getCapacityOfAdults() {
        return capacityOfAdults;
    }

    public int getCapacityOfChildren() {
        return capacityOfChildren;
    }
    public int getCapacityOfGuests() { return capacityOfGuests; }

    public String getTypeOfBed() {
        return typeOfBed;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public String getFacilities() {
        return facilities;
    }
    public String getImageLink() { return imageLink; }
    public boolean isCleaned() {
        return cleaned;
    }
    public int getRoomNumber() { return roomNumber; }


//

    public void setId(long id) {
        Id = id;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public void setCapacityOfAdults(int capacityOfAdults) {
        this.capacityOfAdults = capacityOfAdults;
    }

    public void setCapacityOfChildren(int capacityOfChildren) {
        this.capacityOfChildren = capacityOfChildren;
    }

    public void setCapacityOfGuests(int capacityOfGuests) { this.capacityOfGuests = capacityOfGuests; }

    public void setTypeOfBed(String typeOfBed) {
        this.typeOfBed = typeOfBed;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }
    public void setImageLink(String imageLink) { this.imageLink = imageLink; }
    public void setCleaned(boolean cleaned) {
        this.cleaned = cleaned;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

//
}