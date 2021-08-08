package com.umgc.zoo.model.animals.species;

import com.umgc.zoo.model.animals.Mammal;
import com.umgc.zoo.model.attibutes.Leg;

import java.time.LocalDate;
import java.util.List;

public class Goat extends Mammal {
    public Goat() {
    }

    public Goat(String name) {
        super(name);
    }

    public Goat(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Goat(String name, LocalDate birthDate, int age, int lifeExpectancy) {
        super(name, birthDate, age, lifeExpectancy);
    }

    public Goat(String name, LocalDate birthDate, List<Leg> legs) {
        super(name, birthDate, legs);
    }

    public Goat(String name, String birthDateStr) {
        super(name, birthDateStr);
    }
}
