package com.company;

interface Drawable {
    void draw();
}

public abstract class Shape implements Drawable {
    protected String shapeColor;
    public abstract double calcArea();
    public String toString() {
        return "Color: " + shapeColor + "\n";
    }
}
