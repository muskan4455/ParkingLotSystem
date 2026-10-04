package com.example.ParkingLot.model;

import java.util.Vector;

public class Floor {
    public int floorNo;
    public Vector<Block>blocks=new Vector<>();
    public Floor(int id,int n,int m){
        this.floorNo=id;
        for(int i=1;i<=n;i++){
            Block block=new Block(i,m);
            blocks.add(block);
    }
}
}
