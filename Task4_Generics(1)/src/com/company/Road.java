package com.company;

import java.util.ArrayList;
import java.util.List;

public class Road {
    public List<Transport> carsInRoad = new ArrayList<>();
    public int getCountOfHumans() {
        int count = 0;
        for (Transport car : carsInRoad) {
            count += car.getNumberOfOccupiedSeats();
        }
        return count;
    }
    public void addCarToRoad(Transport transport) { carsInRoad.add(transport); }
}
