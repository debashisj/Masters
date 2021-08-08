package com.umgc.zoo.model.animals;

import com.umgc.zoo.exception.InvalidNumberOfLegsException;
import com.umgc.zoo.model.Animal;
import com.umgc.zoo.model.attibutes.Leg;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Mammal extends Animal {
    private List<Leg> legs;

    public Mammal() {
    }

    public Mammal(String name) {
        super(name);
    }

    public Mammal(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Mammal(String name, LocalDate birthDate, int age, int lifeExpectancy) {
        super(name, birthDate, age, lifeExpectancy);
    }

    public Mammal(String name, LocalDate birthDate, List<Leg> legs) {
        super(name, birthDate);
        this.legs = legs;
    }

    public Mammal(String name, String birthDateStr) {
        super(name, birthDateStr);
    }

    @Override
    public String toString() {
        return "Mammal{" +
                "legs=" + legs +
                ", age=" + age +
                ", lifeExpectancy=" + lifeExpectancy +
                '}';
    }

    @Override
    protected int calculateLifeExpectancy() {
        return 15 - this.getAge();
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        if(Objects.isNull(legs) || legs.size() > 4) {
            throw new InvalidNumberOfLegsException(this.getSpeciesType() + ": Number of legs : " + (Objects.nonNull(legs) ? legs.size() : null));
        }
        this.legs = legs;
    }
}
