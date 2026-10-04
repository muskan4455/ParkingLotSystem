package com.example.ParkingLot.controller;

import com.example.ParkingLot.model.Spot;
import com.example.ParkingLot.service.ParkingLotService;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/parking")
public class ParkingLotController {

    ParkingLotService service;

    public ParkingLotController(ParkingLotService service) {
        this.service = service;
    }

    @GetMapping("/availableSpots")
    public HashMap<Integer,ArrayList<ArrayList<Spot>>> getAvailableSpots() {
        return service.getAvailabSpots();
    }

    @GetMapping("/book")
    public void bookSpots(
            @RequestParam("i") int i,
            @RequestParam("j") int j,
            @RequestParam("k") int k,
            @RequestParam("l") int l) {

        service.bookSpot(i, j, k, l);
    }
}