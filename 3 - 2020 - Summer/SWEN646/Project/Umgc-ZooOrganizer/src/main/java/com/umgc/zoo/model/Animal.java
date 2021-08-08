package com.umgc.zoo.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.umgc.zoo.model.animals.species.Eagle;
import com.umgc.zoo.model.animals.species.Goat;
import com.umgc.zoo.model.animals.species.Hawk;
import com.umgc.zoo.model.animals.species.Iguana;
import com.umgc.zoo.model.animals.species.Lion;
import com.umgc.zoo.model.animals.species.Pig;
import com.umgc.zoo.model.animals.species.Turtle;
import com.umgc.zoo.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "speciesType")
@JsonSubTypes({
        @JsonSubTypes.Type(value= Pig.class, name = "Pig"),
        @JsonSubTypes.Type(value= Lion.class, name = "Lion"),
        @JsonSubTypes.Type(value= Goat.class, name = "Goat"),
        @JsonSubTypes.Type(value= Iguana.class, name = "Iguana"),
        @JsonSubTypes.Type(value= Turtle.class, name = "Turtle"),
        @JsonSubTypes.Type(value= Eagle.class, name = "Eagle"),
        @JsonSubTypes.Type(value= Hawk.class, name = "Hawk"),
})
public abstract class Animal {
    private static final Logger logger = LoggerFactory.getLogger(Animal.class);

    private String name;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthDate;

    protected int age;

    protected int lifeExpectancy;

    private String animalType = this.getClass().getSuperclass().getSimpleName();

    private String speciesType = this.getClass().getSimpleName();

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Animal(String name, String birthDateStr) {
        this.name = name;
        this.birthDate = Util.getLocalDateFromString(birthDateStr);
    }

    public Animal(String name, LocalDate birthDate, int age, int lifeExpectancy) {
        this.name = name;
        this.birthDate = birthDate;
        this.age = age;
        this.lifeExpectancy = lifeExpectancy;
    }

    public abstract String toString();

    public String printAnimalInformation() {
        return "Name: " + this.name + "\t\t" +
                "Animal Type: " + this.animalType + "\t\t" +
                "Species Type: " + this.speciesType + "\t\t" +
                "Age: " + this.age + "\t\t" +
                "Life Expectancy: " + this.lifeExpectancy;
    }

    public static Animal loadFromString(String fileName, boolean isInput) {
        Animal animal = null;
        try {
            animal = Util.getAnimalFromJsonFile(fileName, isInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return animal;
    }

    protected abstract int calculateLifeExpectancy();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        this.age = 0;
        try {
            this.age = Period.between(this.birthDate, LocalDate.now()).getYears();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLifeExpectancy() {
        this.lifeExpectancy = this.calculateLifeExpectancy();
        return lifeExpectancy;
    }

    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getSpeciesType() {
        return speciesType;
    }

    public void setSpeciesType(String speciesType) {
        this.speciesType = speciesType;
    }
}
