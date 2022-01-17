package com.company;

public class Triangle extends Shape {
    private final Point a, b, c;
    Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.a = new Point(x1, y1);
        this.b = new Point(x2, y2);
        this.c = new Point(x3, y3);
    }
    public void setShapeColor(String color) {
        this.shapeColor = color;
    }

    private static class Vec2D {
        private final int x, y;
        Vec2D(Point a, Point b) {
            this.x = b.x - a.x;
            this.y = b.y - a.y;
        }
        public long multiplyWithVec(Vec2D vec) {
            return (long) this.x * vec.y - (long) this.y * vec.x;
        }
    }

    public double calcArea() {
        Vec2D v1 = new Vec2D(a, b);
        Vec2D v2 = new Vec2D(a, c);
        return Math.abs(v1.multiplyWithVec(v2)) / 2.0f;
    }
    public void draw() {
        System.out.println("Triangle");
    }
    public String toString() {
        return super.toString() + "Type: Triangle\nPoints: " + printPoints() + "\nArea: " + calcArea() + "\n";
    }
    private String printPoints() {
        return a + ", " + b + ", " + c;
    }
}
