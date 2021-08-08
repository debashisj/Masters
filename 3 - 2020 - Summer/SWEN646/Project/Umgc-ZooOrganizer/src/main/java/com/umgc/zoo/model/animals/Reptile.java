package com.umgc.zoo.model.animals;

import com.umgc.zoo.exception.InvalidScaleAttributeException;
import com.umgc.zoo.model.Animal;
import com.umgc.zoo.model.attibutes.Scale;
import com.umgc.zoo.util.Util;

import java.time.LocalDate;
import java.util.List;

public abstract class Reptile extends Animal {
    private List<Scale> scales;

    public Reptile() {
        super();
    }

    public Reptile(String name) {
        super(name);
    }

    public Reptile(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Reptile(String name, LocalDate birthDate, int age, int lifeExpectancy, List<Scale> scales) {
        super(name, birthDate, age, lifeExpectancy);
        this.scales = scales;
    }

    public Reptile(String name, String birthDateStr) {
        super(name, birthDateStr);
    }

    public Reptile(String name, LocalDate birthDate, List<Scale> scales) {
        super(name, birthDate);
        this.scales = scales;
    }

    @Override
    protected abstract int calculateLifeExpectancy();

    public List<Scale> getScales() {
        return scales;
    }

    public void setScales(List<Scale> scales) {
        for(Scale scale : scales) {
            if(!Util.isValidColor(scale.getColor())) {
                throw new InvalidScaleAttributeException(this.getSpeciesType() + ": Color : " + scale.getColor());
            }
        }
        this.scales = scales;
    }
}
