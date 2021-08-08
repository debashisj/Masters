package com.umgc.zoo.model.animals.species;

import com.umgc.zoo.model.animals.Mammal;

import java.time.LocalDate;

public class Pig extends Mammal {
    public Pig() {
    }

    public Pig(String name) {
        super(name);
    }

    public Pig(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Pig(String name, LocalDate birthDate, int age, int lifeExpectancy) {
        super(name, birthDate, age, lifeExpectancy);
    }

    public Pig(String name, String birthDateStr) {
        super(name, birthDateStr);
    }
}
