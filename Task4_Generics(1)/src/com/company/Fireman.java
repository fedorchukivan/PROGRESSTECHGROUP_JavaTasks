package com.company;

import java.io.Serializable;

public class Fireman extends Human implements Serializable {
    int workExperience;

    Fireman(String name, String surname, int workExperience) {
        super(name, surname);
        this.workExperience = Math.max(workExperience, 0);
    }

    @Override
    public String toString() {
        return super.toString() + "Fireman\n" + "Work experience: " + workExperience + "\n";
    }
}
