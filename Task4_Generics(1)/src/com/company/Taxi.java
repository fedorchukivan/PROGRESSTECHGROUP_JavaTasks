package com.company;

public class Taxi extends Car<Human> {
    public String toString() {
        return "Type: Taxi\nPassengers: " + getNumberOfOccupiedSeats() + "\n";
    }
}
