package com.company;

import java.io.Serializable;

public class Human implements Serializable {
    public String name;
    public String surname;

    Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nSurname: " + surname + "\n";
    }
}
