package com.example.ParkingLot.model;

import java.util.Vector;

public class ParkingLot {

    public Vector<Floor> floors = new Vector<>();

    public ParkingLot(int l, int m, int n) {

        Floor floor = new Floor(l, m, n);

        floors.add(floor);
    }

    public void addFloor(int l, int m, int n) {

        Floor floor = new Floor(l, n, m);

        floors.add(floor);
    }

    public void removeFloor(int l) {

        floors.remove(l);
    }
}