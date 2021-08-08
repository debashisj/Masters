package com.umgc.zoo.unittests;

import com.umgc.zoo.model.Animal;
import com.umgc.zoo.model.animals.Bird;
import com.umgc.zoo.service.Zoo;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyUnitTests {

    @Test
    public void deleteAnimalTest() {
        List<Animal> animals = getAnimals();

        Zoo zoo = new Zoo(animals);
        Assert.assertEquals(4, zoo.getAnimals().size());
        Animal bird = new Bird("b1");
        zoo.deleteAnimal(bird);
        Assert.assertEquals(3, zoo.getAnimals().size());
    }

    @Test
    public void editAnimalTest() {
        List<Animal> animals = getAnimals();

        Zoo zoo = new Zoo(animals);
        Animal bird = new Bird("b1", LocalDate.now().minusYears(10));
        zoo.editAnimal(bird);
        Assert.assertEquals(10, zoo.getAnimals().get(0).getAge());
    }

    private List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Bird("b1", LocalDate.now()));
        animals.add(new Bird("b2", LocalDate.now()));
        animals.add(new Bird("b3", LocalDate.now()));
        animals.add(new Bird("b4", LocalDate.now()));
        return animals;
    }
}
