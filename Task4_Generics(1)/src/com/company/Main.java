package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static View view = new View();
    static Scanner sc = new Scanner(System.in);
    static Road road = new Road();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            int option = getMenuOption(view.MAIN_MENU);
            switch (option) {
                case 1 -> addCar();
                case 2 -> showCars();
                case 3 -> showCountOfHumans();
                case 4 -> addPassenger();
                case 5 -> savePassenger();
                case 6 -> getSavedPassengers();
                default -> exit = true;
            }
        }
    }

    public static int getMenuOption(String menuText) {
        view.print(menuText);
        while (!sc.hasNextInt()) {
            view.print("Wrong input type! Enter option: ");
            sc.next();
        }
        return sc.nextInt();
    }

    public static void addCar() {
        int option = getMenuOption(view.ADD_CAR_SUB_MENU);
        switch (option) {
            case 1 -> road.addCarToRoad(new Bus());
            case 2 -> road.addCarToRoad(new Taxi());
            case 3 -> road.addCarToRoad(new PoliceCar());
            case 4 -> road.addCarToRoad(new FireTruck());
        }
    }

    public static void showCars() {
        for (int i = 0; i < road.carsInRoad.size(); i++) {
            view.print(view.SEPARATOR);
            view.print("#" + (i+1) + " " + road.carsInRoad.get(i).toString());
        }
        view.print(view.SEPARATOR);
    }

    public static void showCountOfHumans() {
        view.print(view.SEPARATOR);
        view.print("Count: " + road.getCountOfHumans() + "\n");
        view.print(view.SEPARATOR);
    }

    public static void addPassenger() {
        showCars();
        int option = getMenuOption(view.TAKE_CAR);
        if (option > 0 && option <= road.carsInRoad.size()) {
            try {
                switch (getMenuOption(view.CHOOSE_PASSENGER_TYPE_SUB_MENU)) {
                    case 1 -> road.carsInRoad.get(option-1).addPassenger(new Human("Name", "Surname"));
                    case 2 -> road.carsInRoad.get(option-1).addPassenger(new Policeman("Police", "Man", 1));
                    case 3 -> road.carsInRoad.get(option-1).addPassenger(new Fireman("Fire", "Man", 2));
                }
            }
            catch (ClassCastException e) {
                view.print(view.PASSENGER_TYPE_ERROR);
            }
            catch (FullTransportException e) {
                view.print(view.FULL_TRANSPORT_ERROR);
            }
        }
    }

    public static void savePassenger() {
        showCars();
        int option = getMenuOption(view.TAKE_CAR);
        if (option > 0 && option <= road.carsInRoad.size()) {
            ArrayList<? extends Human> passengers = road.carsInRoad.get(option-1).listOfPassengers;
            for (int i = 0; i < passengers.size(); i++) {
                view.print(view.SEPARATOR);
                view.print("#" + (i+1) + " " + passengers.get(i).toString());
            }
            view.print(view.SEPARATOR);
            int passenger = getMenuOption(view.TAKE_PASSENGER);
            if (passenger > 0 && passenger <= passengers.size()) {
                ArrayList<Human> ps = new ArrayList<>();
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Passengers.txt"));
                    ps = (ArrayList<Human>) ois.readObject();
                    ois.close();
                }
                catch (IOException | ClassNotFoundException e) {
                    //e.printStackTrace();
                }
                finally {
                    try {
                        ps.add(passengers.get(passenger - 1));
                        ObjectOutputStream s = new ObjectOutputStream(new FileOutputStream("Passengers.txt"));
                        s.writeObject(ps);
                        s.flush();
                        s.close();
                    }  catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void getSavedPassengers() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Passengers.txt"));
            ArrayList<Human> passengers = (ArrayList<Human>) ois.readObject();
            for (Human passenger : passengers) {
                view.print(view.SEPARATOR);
                view.print(passenger.toString());
            }
            view.print(view.SEPARATOR);
            ois.close();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
