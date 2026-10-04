package com.example.ParkingLot.service;


import com.example.ParkingLot.model.ParkingLot;
import com.example.ParkingLot.model.Spot;

import java.util.*;

import org.springframework.stereotype.Service;
@Service 
public class ParkingLotService {

    ParkingLot lot;
    public ParkingLotService(){
        lot = new ParkingLot(6, 2, 1);
    }

    HashMap<Integer, int[]> vehicleIdAndSpot = new HashMap<>();

    public HashMap<Integer,ArrayList<ArrayList<Spot>>> getAvailabSpots() {
        HashMap<Integer,ArrayList<ArrayList<Spot>>>result=new HashMap<>();
        
        for (int i = 0; i < lot.floors.size(); i++) {
            ArrayList<ArrayList<Spot>> availableBlocks = new ArrayList<>();
            for (int j = 0; j < lot.floors.get(i).blocks.size(); j++) {

                ArrayList<Spot> availableSpot = new ArrayList<>();

                for (int k = 0; k < lot.floors.get(i).blocks.get(j).spots.size(); k++) {

                    if (lot.floors.get(i).blocks.get(j).spots.get(k).isAvailable) {
                        availableSpot.add(
                            lot.floors.get(i).blocks.get(j).spots.get(k)
                        );
                    }
                }
                availableBlocks.add(availableSpot);

            }
            result.put(i+1, availableBlocks);
        }

        return result;
    }
    
    public void bookSpot(int i, int j, int k, int id) {

        if (lot.floors.get(i).blocks.get(j).spots.get(k).isAvailable) {

            lot.floors.get(i).blocks.get(j).spots.get(k).isAvailable = false;

            vehicleIdAndSpot.put(id, new int[]{i, j, k});

            return;
        }

        System.out.println("Spot Not Available");
    }

    public void releaseSpot(int vehicleId) {

        int[] spot = vehicleIdAndSpot.get(vehicleId);

        int i = spot[0];
        int j = spot[1];
        int k = spot[2];

        lot.floors.get(i).blocks.get(j).spots.get(k).isAvailable = true;

        vehicleIdAndSpot.remove(vehicleId);
    }
}