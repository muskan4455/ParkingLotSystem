package com.example.ParkingLot.model;

public class Spot {
    public int SpotId;
    public Boolean isAvailable;
    public Spot(int id){
        this.SpotId=id;
        isAvailable=true;
    }
}
