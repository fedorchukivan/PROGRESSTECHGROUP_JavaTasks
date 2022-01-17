package com.company;

public abstract class Car <T extends Human> extends Transport <T> {
    static { numberOfSeats = 4; }
}
