package com.company;

public class Rectangle extends Shape {
    private final Point a, b;
    Rectangle(int x1, int y1, int x2, int y2) {
        this.a = new Point(x1, y1);
        this.b = new Point(x2, y2);
    }
    public void setShapeColor(String color) {
        this.shapeColor = color;
    }
    public double calcArea() {
        return Math.abs((a.x-b.x) * (a.y-b.y));
    }
    public void draw() {
        System.out.println("");
        for (int y = 0; y < Math.abs(a.y-b.y); y++) {
            for (int x = 0; x < Math.abs(a.x-b.x); x++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    public String toString() {
        return super.toString() + "Type: Rectangle\nPoints: " + printPoints() + "\nArea: " + calcArea() + "\n";
    }
    private String printPoints() {
        return a + ", " + b;
    }
}
