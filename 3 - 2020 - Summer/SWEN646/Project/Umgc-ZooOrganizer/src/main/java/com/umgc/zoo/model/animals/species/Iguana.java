package com.umgc.zoo.model.animals.species;

import com.umgc.zoo.model.animals.Reptile;
import com.umgc.zoo.model.attibutes.Scale;

import java.time.LocalDate;
import java.util.List;

public class Iguana extends Reptile {
    public Iguana() {
    }

    public Iguana(String name) {
        super(name);
    }

    public Iguana(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Iguana(String name, LocalDate birthDate, int age, int lifeExpectancy, List<Scale> scales) {
        super(name, birthDate, age, lifeExpectancy, scales);
    }

    public Iguana(String name, String birthDateStr) {
        super(name, birthDateStr);
    }

    public Iguana(String name, LocalDate birthDate, List<Scale> scales) {
        super(name, birthDate, scales);
    }

    @Override
    protected int calculateLifeExpectancy() {
        return 10 / this.getAge();
    }

    @Override
    public String toString() {
        return "Iguana{" +
                "age=" + age +
                ", lifeExpectancy=" + lifeExpectancy +
                '}';
    }
}
