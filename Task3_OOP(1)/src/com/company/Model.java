package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Model {
    public Shape[] shapes;
    Model(int count) {
        this.generateShapes(Math.max(count, 1));
    }

    public double getAllShapesArea() {
        double sum = 0;
        for (Shape sh : shapes) {
            sum += sh.calcArea();
        }
        return sum;
    }
    public double getAllRectanglesArea() {
        double sum = 0;
        for (Shape sh : shapes) {
            if (sh instanceof Rectangle) sum += sh.calcArea();
        }
        return sum;
    }
    public double getAllTrianglesArea() {
        double sum = 0;
        for (Shape sh : shapes) {
            if (sh instanceof Triangle) sum += sh.calcArea();
        }
        return sum;
    }
    public double getAllCirclesArea() {
        double sum = 0;
        for (Shape sh : shapes) {
            if (sh instanceof Circle) sum += sh.calcArea();
        }
        return sum;
    }

    private static class ShapeAreaComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Shape sh1 = (Shape) o1;
            Shape sh2 = (Shape) o2;
            return Double.compare(sh2.calcArea(), sh1.calcArea());
        }
    }
    private static class ShapeColorComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            String sh1 = ((Shape) o1).shapeColor;
            String sh2 = ((Shape) o2).shapeColor;
            return sh1.compareTo(sh2);
        }
    }

    public void sortByArea() {
        Arrays.sort(shapes, new ShapeAreaComparator());
    }
    public void sortByColor() {
        Arrays.sort(shapes, new ShapeColorComparator());
    }

    private void generateShapes(int count) {
        shapes = new Shape[count];
        for (int i = 0; i < count; i++) {
            switch ((int)(Math.random()*3)) {
                case 0 -> shapes[i] = generateRectangle();
                case 1 -> shapes[i] = generateTriangle();
                case 2 -> shapes[i] = generateCircle();
            }
        }
    }

    private Rectangle generateRectangle() {
        int[] coords = {
                (int) (Math.random() * 20),
                (int) (Math.random() * 20),
                (int) (Math.random() * 20),
                (int) (Math.random() * 20)
        };
        Rectangle res = new Rectangle(coords[0],coords[1],coords[2],coords[3]);
        res.setShapeColor(getRandomColor());
        return res;
    }
    private Triangle generateTriangle() {
        int[] coords = {
                (int) (Math.random() * 20),
                (int) (Math.random() * 20),
                (int) (Math.random() * 20),
                (int) (Math.random() * 20),
                (int) (Math.random() * 20),
                (int) (Math.random() * 20)
        };
        Triangle res = new Triangle(coords[0],coords[1],coords[2],coords[3],coords[4],coords[5]);
        res.setShapeColor(getRandomColor());
        return res;
    }
    private Circle generateCircle() {
        Circle res = new Circle((int)(Math.random()*5)+2);
        res.setShapeColor(getRandomColor());
        return res;
    }

    private String getRandomColor() {
        String color = "";
        switch ((int)(Math.random()*6)) {
            case 0 -> color = "red";
            case 1 -> color = "green";
            case 2 -> color = "blue";
            case 3 -> color = "yellow";
            case 4 -> color = "black";
            case 5 -> color = "white";
        }
        return color;
    }
}
