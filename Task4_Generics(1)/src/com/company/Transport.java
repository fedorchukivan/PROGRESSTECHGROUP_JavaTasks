package com.company;

import java.util.ArrayList;

public abstract class Transport <T extends Human> {
    protected static int numberOfSeats;
    protected int numberOfOccupiedSeats = 0;
    protected ArrayList<T> listOfPassengers = new ArrayList<>();

    public void addPassenger(T passenger) throws FullTransportException {
        if (hasFreeSeat()) {
            numberOfOccupiedSeats++;
            listOfPassengers.add(passenger);
        }
        else throw new FullTransportException();
    }

    public void removePassenger(T passenger) throws RemoveNotExistingPassengerException {
        if (listOfPassengers.contains(passenger)) {
            listOfPassengers.remove(passenger);
        }
        else throw new RemoveNotExistingPassengerException();
    }

    public static int getNumberOfSeats() { return numberOfSeats; }
    public int getNumberOfOccupiedSeats() { return numberOfOccupiedSeats; }
    public boolean hasFreeSeat() { return getNumberOfOccupiedSeats() != getNumberOfSeats(); }
    public ArrayList<T> getListOfPassengers() { return listOfPassengers; }

    public String toString() { return "Object: Transport"; }
}
