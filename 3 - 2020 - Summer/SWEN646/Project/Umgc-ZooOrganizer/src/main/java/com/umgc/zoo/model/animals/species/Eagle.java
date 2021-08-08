package com.umgc.zoo.model.animals.species;

import com.umgc.zoo.model.animals.Bird;
import com.umgc.zoo.model.attibutes.Wing;

import java.time.LocalDate;
import java.util.List;

public class Eagle extends Bird {
    public Eagle() {
        super();
    }

    public Eagle(String name) {
        super(name);
    }

    public Eagle(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Eagle(String name, LocalDate birthDate, int age, int lifeExpectancy, List<Wing> wings) {
        super(name, birthDate, age, lifeExpectancy, wings);
    }

    public Eagle(String name, String birthDateStr) {
        super(name, birthDateStr);
    }

    public Eagle(String name, LocalDate birthDate, List<Wing> wings) {
        super(name, birthDate, wings);
    }
}
