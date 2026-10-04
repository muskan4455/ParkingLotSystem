package com.example.ParkingLot.model;

import java.util.Vector;

public class Block {
    public int blockNo;
    public Vector<Spot>spots=new Vector<>();
    public Block(int id,int n){
        this.blockNo=id;
        for(int i=1;i<=n;i++){
            Spot spot=new Spot(i);
            spots.add(spot);
    }
}
}
