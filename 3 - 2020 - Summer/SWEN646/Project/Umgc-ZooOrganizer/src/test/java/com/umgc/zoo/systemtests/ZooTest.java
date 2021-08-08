package com.umgc.zoo.systemtests;

import com.umgc.zoo.enums.Color;
import com.umgc.zoo.model.Animal;
import com.umgc.zoo.model.animals.species.Eagle;
import com.umgc.zoo.model.animals.species.Goat;
import com.umgc.zoo.model.animals.species.Hawk;
import com.umgc.zoo.model.animals.species.Iguana;
import com.umgc.zoo.model.animals.species.Lion;
import com.umgc.zoo.model.attibutes.Leg;
import com.umgc.zoo.model.attibutes.Scale;
import com.umgc.zoo.model.attibutes.Wing;
import com.umgc.zoo.service.Zoo;
import com.umgc.zoo.util.Util;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ZooTest {
    /**
     * This test class adds animals to new zoo.
     */
    @Test
    public void a_AddNewAnimals_FromFile_NewZoo() throws IOException {
        System.out.println("################################# Test case 01 #################################");
        Zoo zoo = new Zoo("zoo1.json", true);
        System.out.println("Adding " + (Objects.nonNull(zoo.getAnimals()) ? zoo.getAnimals().size() : 0) + " animals to the new zoo.");

        try {
            Util.saveToMasterFile(zoo);
            System.out.println("Test case 01: SUCCESSFULLY added animals to the zoo");
        } catch(Exception e) {
            System.out.println("Test case 01: FAILED, Error: " + e.getMessage());
        }
    }

    /**
     * This test class adds animals from a JSON file to existing zoo to the MasterZooFile.
     */
    @Test
    public void b_AddNewAnimals_FromFile_ToMasterList() throws IOException {
        Zoo zoo = new Zoo("zoo2.json", true);
        addAnimalsAndPrintLogs(2, zoo.getAnimals());
    }

    /**
     * This test class adds animals to existing zoo to the MasterZooFile.
     */
    @Test
    public void c_AddNewAnimals_ToMasterList() throws IOException {
        List<Animal> animals = Arrays.asList(
                new Iguana("badguy03", Util.getLocalDateFromString("2007-08-02"), new ArrayList<Scale>()),
                new Eagle("chetak03", Util.getLocalDateFromString("2017-01-22"), new ArrayList<Wing>()),
                new Hawk("maruti03", Util.getLocalDateFromString("2020-12-30"), new ArrayList<Wing>()),
                new Lion("mufasa03", Util.getLocalDateFromString("2012-07-10"), new ArrayList<Leg>())
        );
        addAnimalsAndPrintLogs(3, animals);
    }

    /**
     * Adds birds with wings to the MasterZooFile.
     */
    @Test
    public void d_AddBirds_WithWings_ToMasterList() throws IOException {
        List<Animal> animals = Arrays.asList(
                new Eagle("birdie04",
                        Util.getLocalDateFromString("2017-01-22"),
                        Util.getWingsWithColor(2, Color.RED)),
                new Hawk("hawk004",
                        Util.getLocalDateFromString("2019-05-21"),
                        Util.getWingsWithColor(2, Color.BLUE))
        );
        addAnimalsAndPrintLogs(4, animals);
    }

    /**
     * Adds mammals with wings to the MasterZooFile.
     */
    @Test
    public void e_AddMammals_WithLegs_ToMasterList() {
        List<Animal> animals = Arrays.asList(
                new Goat("goat65",
                        Util.getLocalDateFromString("2007-01-15"),
                        Arrays.asList(new Leg(1.1f), new Leg(1.0f), new Leg(1.11f), new Leg(1.02f))),
                new Lion("lion11",
                        Util.getLocalDateFromString("2012-01-14"),
                        Arrays.asList(new Leg(1.5f), new Leg(1.45f), new Leg(1.41f), new Leg(1.45f)))
        );
        addAnimalsAndPrintLogs(5, animals);
    }

    /**
     * Print all animals with name and life expectancy.
     */
    @Test
    public void f_PrintAllAnimalsInfo(){
        System.out.println("\n\n################################# Test case 06 #################################");
        System.out.println("printing the animals info");
        Util.printAllAnimals();
        System.out.println("Printed the animals info.");
    }

    /**
     * Delete animals and print all animals with name and other info.
     */
    @Test
    public void g_deleteAnimals_PrintAllAnimalsInfo() throws IOException {
        System.out.println("\n\n################################# Test case 07 #################################");
        System.out.println("Deleting the animals");

        Zoo zoo = new Zoo(Util.MASTER_ZOO_FILE_JSON, false);
        Animal animal = new Lion("lion11");
        zoo.deleteAnimal(animal);
        System.out.println("Deleted : " + animal.getSpeciesType() + " with Name :" + animal.getName());

        animal = new Eagle("chetak03");
        zoo.deleteAnimal(animal);
        System.out.println("Deleted : " + animal.getSpeciesType() + " with Name :" + animal.getName());

        Util.saveToMasterFile(zoo);
        Util.printAllAnimals();
        System.out.println("Printed the animals info.");
    }

    /**
     * Add an animal from json to the zoo.
     */
    @Test
    public void h_AddSingleAnimal_FromJsonFile() throws IOException {
        System.out.println("\n\n################################# Test case 08 #################################");
        System.out.println("Adding a single animal from the JSON file");

        Zoo zoo = new Zoo(Util.MASTER_ZOO_FILE_JSON, false);
        zoo.getAnimals().addAll(Collections.singletonList(Animal.loadFromString("animal1.json", true)));
        Util.saveToMasterFile(zoo);

        Util.printAllAnimals();
        System.out.println("Printed the animals info.");
    }

    private void addAnimalsAndPrintLogs(int testcaseNumber, List<Animal> animals) {
        System.out.println("\n\n################################# Test case 0" + testcaseNumber + " #################################");
        System.out.println("Adding " + animals.size() + " animals to the existing list of the animals.");
        try {
            Util.addAnimalsToMasterFile(new Zoo(animals));
            System.out.println("TestCase :0" + testcaseNumber + ": SUCCESSFULLY added animals to the zoo");
        } catch(Exception e) {
            System.out.println("TestCase :0" + testcaseNumber + ": FAILED, Error: " + e.getMessage());
        }
    }
}
