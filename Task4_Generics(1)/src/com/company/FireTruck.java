package com.company;

public class FireTruck extends Car<Fireman> {
    @Override
    public void addPassenger(Fireman passenger) throws FullTransportException, ClassCastException {
        if (hasFreeSeat()) {
            numberOfOccupiedSeats++;
            listOfPassengers.add(passenger);
        }
        else throw new FullTransportException();
    }
    public String toString() {
        return "Type: Fire Truck\nPassengers: " + getNumberOfOccupiedSeats() + "\n";
    }
}
