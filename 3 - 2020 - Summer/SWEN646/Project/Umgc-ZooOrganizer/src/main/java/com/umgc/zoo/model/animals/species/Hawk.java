package com.umgc.zoo.model.animals.species;

import com.umgc.zoo.model.animals.Bird;
import com.umgc.zoo.model.attibutes.Wing;

import java.time.LocalDate;
import java.util.List;

public class Hawk extends Bird {
    public Hawk() {
    }

    public Hawk(String name) {
        super(name);
    }

    public Hawk(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Hawk(String name, LocalDate birthDate, int age, int lifeExpectancy, List<Wing> wings) {
        super(name, birthDate, age, lifeExpectancy, wings);
    }

    public Hawk(String name, String birthDateStr) {
        super(name, birthDateStr);
    }

    public Hawk(String name, LocalDate birthDate, List<Wing> wings) {
        super(name, birthDate, wings);
    }
}
