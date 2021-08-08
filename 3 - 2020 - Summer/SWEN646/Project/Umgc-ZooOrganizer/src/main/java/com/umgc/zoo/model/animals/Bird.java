package com.umgc.zoo.model.animals;

import com.umgc.zoo.exception.InvalidNumberOfWingsException;
import com.umgc.zoo.model.Animal;
import com.umgc.zoo.model.attibutes.Wing;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Bird extends Animal {
    private List<Wing> wings;

    public Bird() {
    }

    public Bird(String name) {
        super(name);
    }

    public Bird(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Bird(String name, LocalDate birthDate, int age, int lifeExpectancy, List<Wing> wings) {
        super(name, birthDate, age, lifeExpectancy);
        this.wings = wings;
    }

    public Bird(String name, LocalDate birthDate, List<Wing> wings) {
        super(name, birthDate);
        this.wings = wings;
    }

    public Bird(String name, String birthDateStr) {
        super(name, birthDateStr);
    }

    @Override
    public String toString() {
        return "Bird{" +
                "wings=" + wings +
                ", age=" + age +
                ", lifeExpectancy=" + lifeExpectancy +
                '}';
    }

    @Override
    protected int calculateLifeExpectancy() {
        return 5;
    }


    public List<Wing> getWings() {
        return wings;
    }

    public void setWings(List<Wing> wings) {
        if(Objects.isNull(wings) || wings.size() > 2) {
            throw new InvalidNumberOfWingsException(this.getSpeciesType() + ": Number of wings : " + (Objects.nonNull(wings) ? wings.size() : null));
        }
        this.wings = wings;
    }
}
