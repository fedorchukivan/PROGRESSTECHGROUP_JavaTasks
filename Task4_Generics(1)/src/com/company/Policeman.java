package com.company;

import java.io.Serializable;

public class Policeman extends Human implements Serializable {
    int workExperience;

    Policeman(String name, String surname, int workExperience) {
        super(name, surname);
        this.workExperience = Math.max(workExperience, 0);
    }

    @Override
    public String toString() {
        return super.toString() + "Policeman\n" + "Work experience: " + workExperience + "\n";
    }
}
