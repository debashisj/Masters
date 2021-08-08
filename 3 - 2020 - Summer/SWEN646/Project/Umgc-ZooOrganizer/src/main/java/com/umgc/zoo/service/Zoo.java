package com.umgc.zoo.service;


import com.umgc.zoo.model.Animal;
import com.umgc.zoo.model.Person;
import com.umgc.zoo.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Zoo {
    private static final Logger logger = LoggerFactory.getLogger(Zoo.class);

    private List<Animal> animals;
    public Person zooKeeper;
    public String theme;

    public Zoo() {
        this.initializeAllElements();
    }

    public Zoo(String fileName, boolean isInput) {
        try {
            this.initializeAllElements();
            Zoo inputZoo = Util.getZooFromJsonFile(fileName, isInput);
            this.zooKeeper = inputZoo.getZooKeeper();
            this.theme = inputZoo.getTheme();
            this.animals = inputZoo.getAnimals();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public void deleteAnimal(final Animal animal) {
        this.getAnimals().removeIf(a -> a.getName().equalsIgnoreCase(animal.getName()));
    }

    public void editAnimal(Animal animal) {
        this.setAnimals(
                this.animals.stream()
                        .map(a -> a = animal.getName().equalsIgnoreCase(a.getName()) ? animal : a)
                        .collect(Collectors.toList())
        );
    }

    public Person getZooKeeper() {
        return zooKeeper;
    }

    public void setZooKeeper(Person zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    private void initializeAllElements() {
        this.animals = new ArrayList<>();
        this.zooKeeper = new Person();
        this.theme = "";
    }
}
