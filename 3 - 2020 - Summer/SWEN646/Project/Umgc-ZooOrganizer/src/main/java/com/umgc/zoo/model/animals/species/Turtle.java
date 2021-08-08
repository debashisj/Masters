package com.umgc.zoo.model.animals.species;

import com.umgc.zoo.model.animals.Reptile;
import com.umgc.zoo.model.attibutes.Scale;

import java.time.LocalDate;
import java.util.List;

public class Turtle extends Reptile {
    public Turtle() {
    }

    public Turtle(String name) {
        super(name);
    }

    public Turtle(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Turtle(String name, LocalDate birthDate, int age, int lifeExpectancy, List<Scale> scales) {
        super(name, birthDate, age, lifeExpectancy, scales);
    }

    public Turtle(String name, String birthDateStr) {
        super(name, birthDateStr);
    }

    public Turtle(String name, LocalDate birthDate, List<Scale> scales) {
        super(name, birthDate, scales);
    }

    @Override
    public String toString() {
        return "Turtle{" +
                "age=" + age +
                ", lifeExpectancy=" + lifeExpectancy +
                '}';
    }

    @Override
    protected int calculateLifeExpectancy() {
        return 110 - this.getAge();
    }
}
