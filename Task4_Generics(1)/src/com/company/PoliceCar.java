package com.company;

public class PoliceCar extends Car<Policeman> {
    @Override
    public void addPassenger(Policeman passenger) throws FullTransportException, ClassCastException {
        if (hasFreeSeat()) {
            numberOfOccupiedSeats++;
            listOfPassengers.add(passenger);
        }
        else throw new FullTransportException();
    }
    public String toString() {
        return "Type: Police Car\nPassengers: " + getNumberOfOccupiedSeats() + "\n";
    }
}
