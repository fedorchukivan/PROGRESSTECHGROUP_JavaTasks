package com.company;

public class Main {

    public static void main(String[] args) {
        Model model = new Model(10);
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.start();
    }
}
