package com.umgc.zoo.unittests;

import com.umgc.zoo.enums.Color;
import com.umgc.zoo.exception.InvalidNumberOfLegsException;
import com.umgc.zoo.exception.InvalidNumberOfWingsException;
import com.umgc.zoo.exception.InvalidScaleAttributeException;
import com.umgc.zoo.model.animals.Bird;
import com.umgc.zoo.model.animals.Mammal;
import com.umgc.zoo.model.animals.Reptile;
import com.umgc.zoo.model.animals.species.Turtle;
import com.umgc.zoo.model.attibutes.Leg;
import com.umgc.zoo.model.attibutes.Scale;
import com.umgc.zoo.model.attibutes.Wing;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class ExceptionUnitTests {


    @Test
    public void testMammalsException() {
        Mammal mammal = new Mammal("mam1", LocalDate.of(2014, Month.JANUARY, 1));

        List<Leg> legs = Arrays.asList(new Leg(1), new Leg(1), new Leg(1), new Leg(1), new Leg(1));
        Exception exception = assertThrows(InvalidNumberOfLegsException.class, () -> {
            mammal.setLegs(legs);
        });

        assertTrue(exception.getMessage().contains("Invalid number of legs exception"));
    }

    @Test
    public void testBirdsException() {
        Bird bird = new Bird("bird1", LocalDate.of(2017, Month.JULY, 1));

        List<Wing> wings = Arrays.asList(new Wing(Color.RED), new Wing(Color.BLUE), new Wing(Color.GREEN));
        Exception exception = assertThrows(InvalidNumberOfWingsException.class, () -> {
            bird.setWings(wings);
        });

        assertTrue(exception.getMessage().contains("Invalid number of wings exception"));
    }

    @Test
    public void testReptileException() {
        Reptile reptile = new Turtle("turtle1", LocalDate.of(1987, Month.JULY, 1));

        List<Scale> scales = Arrays.asList(new Scale("White"), new Scale("Black"));
        Exception exception = assertThrows(InvalidScaleAttributeException.class, () -> {
            reptile.setScales(scales);
        });

        assertTrue(exception.getMessage().contains("Invalid scale attribute exception"));
    }
}
