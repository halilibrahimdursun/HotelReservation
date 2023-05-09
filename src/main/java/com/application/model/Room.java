package com.application.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    Long id;
    int NumberOfAdults;
    int NumberOfChildren;
    String typeOfBed;
    Boolean smoke;
    String [] Facilities ;

    public Room(int numberOfAdults, int numberOfChildren, String typeOfBed, Boolean smoke, String[] facilities) {
        NumberOfAdults = numberOfAdults;
        NumberOfChildren = numberOfChildren;
        this.typeOfBed = typeOfBed;
        this.smoke = smoke;
        Facilities = facilities;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfAdults() {
        return NumberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        NumberOfAdults = numberOfAdults;
    }

    public int getNumberOfChildren() {
        return NumberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        NumberOfChildren = numberOfChildren;
    }

    public String getTypeOfBed() {
        return typeOfBed;
    }

    public void setTypeOfBed(String typeOfBed) {
        this.typeOfBed = typeOfBed;
    }

    public Boolean getSmoke() {
        return smoke;
    }

    public void setSmoke(Boolean smoke) {
        this.smoke = smoke;
    }

    public String[] getFacilities() {
        return Facilities;
    }

    public void setFacilities(String[] facilities) {
        Facilities = facilities;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", NumberOfAdults=" + NumberOfAdults +
                ", NumberOfChildren=" + NumberOfChildren +
                ", typeOfBed='" + typeOfBed + '\'' +
                ", smoke=" + smoke +
                ", Facilities=" + Arrays.toString(Facilities) +
                '}';
    }
}
