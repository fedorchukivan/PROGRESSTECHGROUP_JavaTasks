package com.company;

public class View {
    public final String MAIN_MENU = "1. Add transport to road\n2. Show all transport\n3. Show count of humans\n4. Add passenger to car\n5. Save passenger\n6. Show all saved passengers\nElse to exit\nEnter option: ";
    public final String ADD_CAR_SUB_MENU = "1. Add bus\n2. Add taxi\n3. Add police car\n4. Add fire truck\nEnter option: ";
    public final String SEPARATOR = "-----------------------------\n";
    public final String TAKE_CAR = "Enter number of car (or else num to return): ";
    public final String TAKE_PASSENGER = "Enter number of passenger (or else num to return): ";
    public final String CHOOSE_PASSENGER_TYPE_SUB_MENU = "1. Human\n2. Policeman\n3. Fireman\nEnter option: ";
    public final String PASSENGER_TYPE_ERROR = "Failed to add passenger to transport! Wrong type of passenger!\n";
    public final String FULL_TRANSPORT_ERROR = "Failed to add passenger to transport! The transport is full!\n";

    public void print(String message) {
        System.out.print(message);
    }
}
