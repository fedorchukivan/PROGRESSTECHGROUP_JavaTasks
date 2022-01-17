package com.company;

import java.util.Scanner;

public class Controller {
    private final Model model;
    private final View view;
    private final static Scanner sc = new Scanner(System.in);

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        boolean quit = false;
        while (!quit) {
            int option = getMenuOption();
            switch (option) {
                case 1 -> view.printShapes(model.shapes);
                case 2 -> printTotalAreas();
                case 3 -> sortShapesByArea();
                case 4 -> sortShapesByColor();
                default -> quit = true;
            }
        }
    }

    private int getMenuOption() {
        view.printMessage(view.MENU);
        view.printMessage(view.INT_INPUT);
        while (!sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT + " " + view.INT_INPUT);
            sc.next();
        }
        return sc.nextInt();
    }
    private void printTotalAreas() {
        view.printTotalArea("shapes", model.getAllShapesArea());
        view.printTotalArea("rectangles", model.getAllRectanglesArea());
        view.printTotalArea("triangles", model.getAllTrianglesArea());
        view.printTotalArea("circles", model.getAllCirclesArea());
    }
    private void sortShapesByArea() {
        model.sortByArea();
        view.printSorted("area");
    }
    private void sortShapesByColor() {
        model.sortByColor();
        view.printSorted("color");
    }
}
