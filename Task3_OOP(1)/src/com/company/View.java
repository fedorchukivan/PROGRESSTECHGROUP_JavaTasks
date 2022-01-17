package com.company;

public class View {
    public final String MENU = "1.Print Info\n2.Show Total Areas\n3.Sort by Area\n4.Sort by Color\nOther integer to exit\n";
    public final String INT_INPUT = "Enter your option: ";
    public final String WRONG_INPUT = "Wrong input!";
    public final String SEPARATOR = "-----------------------------------";
    public void printMessage(String message) {
        System.out.println(message);
    }
    public void printShapes(Shape[] shapes) {
        printMessage(SEPARATOR);
        for (Shape shape : shapes) {
            System.out.print(shape.toString());
            printMessage(SEPARATOR);
        }
    }
    public void printTotalArea(String type, double value) {
        printMessage("Area of all " + type + ": " + value);
    }
    public void printSorted(String type) {
        printMessage("Shapes were successfully sorted by " + type);
    }
}
