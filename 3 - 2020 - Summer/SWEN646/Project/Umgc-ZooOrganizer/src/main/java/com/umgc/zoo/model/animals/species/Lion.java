package com.umgc.zoo.model.animals.species;

import com.umgc.zoo.model.animals.Mammal;
import com.umgc.zoo.model.attibutes.Leg;

import java.time.LocalDate;
import java.util.List;

public class Lion extends Mammal {
    public Lion() {
    }

    public Lion(String name) {
        super(name);
    }

    public Lion(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Lion(String name, LocalDate birthDate, int age, int lifeExpectancy) {
        super(name, birthDate, age, lifeExpectancy);
    }

    public Lion(String name, String birthDateStr) {
        super(name, birthDateStr);
    }

    public Lion(String name, LocalDate birthDate, List<Leg> legs) {
        super(name, birthDate, legs);
    }
}
