package com.umgc.zoo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.umgc.zoo.enums.Color;
import com.umgc.zoo.exception.InvalidAnimalException;
import com.umgc.zoo.model.Animal;
import com.umgc.zoo.model.attibutes.Wing;
import com.umgc.zoo.service.Zoo;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Util {

    public static final String MASTER_ZOO_FILE_JSON = "MasterZooFile.json";

    public Util() {
    }

    public static Zoo getZooFromJsonFile(String fileName, boolean isInput) throws IOException {
        Object obj = getObjectFromJson(fileName, isInput);
        obj = Objects.nonNull(obj) ? obj : new Zoo();
        try {
            return getMapper().readValue(obj.toString(), Zoo.class);
        } catch (InvalidTypeIdException e) {
            throw new InvalidAnimalException(e.getTypeId());
        }
    }

    public static Animal getAnimalFromJsonFile(String fileName, boolean isInput) throws IOException {
        Object obj = getObjectFromJson(fileName, isInput);
        assert obj != null;
        try {
            return getMapper().readValue(obj.toString(), Animal.class);
        } catch (InvalidTypeIdException e) {
            throw new InvalidAnimalException(e.getTypeId());
        }
    }

    public static String getResourcePath(String fileName, boolean isInput) {
        return System.getProperty("user.dir") +
                "/src/main/resources/" +
                (isInput ? "input" : "output") +
                "/" + fileName;
    }

    public static boolean isValidColor(String str) {
        for (Color c : Color.values()) {
            if (c.name().equalsIgnoreCase(str))
                return true;
        }
        return false;
    }

    public static void saveToMasterFile(Object object) throws IOException {
        saveToFile(object, MASTER_ZOO_FILE_JSON);
    }

    public static void saveToFile(Object object, String fileName) throws IOException {
        ObjectMapperContextResolver mapperResolver = new ObjectMapperContextResolver();
        ObjectMapper mapper = mapperResolver.getContext(Animal.class);
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(Util.getResourcePath(fileName, false)), object);
    }

    public static void addAnimalsToMasterFile(Zoo newZoo) throws Exception {
        Zoo zoo = new Zoo(MASTER_ZOO_FILE_JSON, false);
        List<Animal> animalsInZoo = zoo.getAnimals();
        if(Objects.nonNull(animalsInZoo)) {
            animalsInZoo.addAll(newZoo.getAnimals());
        } else {
            animalsInZoo = newZoo.getAnimals();
        }
        zoo.setAnimals(animalsInZoo);
        saveToFile(zoo, MASTER_ZOO_FILE_JSON);
    }

    public static String convertToString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void printAllAnimals() {
        Zoo zoo = new Zoo(Util.MASTER_ZOO_FILE_JSON, false);
        System.out.println("Total number of animals: " + (Objects.nonNull(zoo.getAnimals()) ? zoo.getAnimals().size() : 0));
        if(Objects.nonNull(zoo.getAnimals())) {
            zoo.getAnimals()
                    .forEach(animal -> System.out.println(animal.printAnimalInformation()));
        } else {
            System.out.println("No animals in the list.");
        }
    }

    public static LocalDate getLocalDateFromString(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(str, formatter);
    }

    public static List<Wing> getWingsWithColor(int numberOfWings, Color color) {
        List<Wing> wings = new ArrayList<>();
        for(int i=0; i<numberOfWings; i++) {
            wings.add(new Wing(color));
        }
        return wings;
    }

    private static Object getObjectFromJson(String fileName, boolean isInput) {
        JSONParser jsonParser = new JSONParser();
        Object obj = null;
        try {
            FileReader reader = new FileReader (getResourcePath(fileName, isInput));
            obj = jsonParser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }

    private static ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return mapper;
    }
}
