package com.company;

public class Circle extends Shape {
    private final int radius;
    Circle(int radius) {
        this.radius = Math.max(radius, 1);
    }
    public void setShapeColor(String color) {
        this.shapeColor = color;
    }
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    public void draw() {
        System.out.println();
        for (int y = 0; y < radius*2+1; y++) {
            for (int x = 0; x < radius*2+1; x++) {
                if (radius >= Math.ceil(Math.sqrt(Math.pow(radius-x, 2) + Math.pow(radius-y, 2))))
                    System.out.print("**");
                else System.out.print("  ");
            }
            System.out.print("\n");
        }
    }
    public String toString() {
        return super.toString() + "Type: Circle\nRadius: " + radius + "\nArea: " + calcArea() + "\n";
    }
}
