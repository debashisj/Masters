package com.umgc.zoo.unittests;

import com.umgc.zoo.model.animals.Bird;
import com.umgc.zoo.model.animals.Mammal;
import com.umgc.zoo.model.animals.species.Iguana;
import com.umgc.zoo.model.animals.species.Turtle;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class LifeExpectancyUnitTests {

    @Test
    public void testMammal() {
        Mammal mammal = new Mammal("mam1", LocalDate.of(2014, Month.JANUARY, 1));
        Assert.assertEquals(9, mammal.getLifeExpectancy());
    }

    @Test
    public void testBird() {
        Bird bird = new Bird("bird", LocalDate.of(2017, Month.JANUARY, 1));
        Assert.assertEquals(5, bird.getLifeExpectancy());
    }

    @Test
    public void testIguana() {
        Iguana iguana = new Iguana("igua", LocalDate.of(2010, Month.JANUARY, 1));
        Assert.assertEquals(1, iguana.getLifeExpectancy());
    }

    @Test
    public void testTurtle() {
        Turtle turtle = new Turtle("turt", LocalDate.of(1964, Month.JANUARY, 1));
        Assert.assertEquals(54, turtle.getLifeExpectancy());
    }
}
