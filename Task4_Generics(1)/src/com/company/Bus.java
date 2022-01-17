package com.company;

public class Bus extends Transport<Human> {
    static { numberOfSeats = 28; }

    public String toString() {
        return "Type: Bus\nPassengers: " + getNumberOfOccupiedSeats() + "\n";
    }
}
