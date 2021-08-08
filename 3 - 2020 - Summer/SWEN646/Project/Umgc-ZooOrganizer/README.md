# UMGC - Zoo Organizer #

## Project Source Folder Structure ##

The project name is Umgc-ZooOrganizer. It has all the source code in the source folder (src). The source folder contains main and test directories.

The main directory contains the source code for the project

* Source project has multiple packages, and they are all self-explanatory.
    1. The service folder in the com.umgc.zoo package has the Zoo class which has the service methods
    2. The util folder has Util class which contains the reusable methods that can be reused at many different places.
    3. The model folder contains the entities. This folder has been extended to the AnimalType and SpeciesType folders based on the inheritance level.
    4. Resources directory contains the input and output folders. Each of them contains the data files for testing. The files are in `JSON` format.
        1. The input folder has some of the input sample files.
        2. The output folder has the `MasterZooFile.json`. This is a required file which needs to be present for any test run.

* Test directory contains all the test cases; including the unit tests and the system tests.
    1. To make it more streamlined the test methods are in alphabetical order of their names.
    2. The alphabetic order has been maintained so as to run them in an order to get a desired result.


## Java Version ##
This project will run in `Java version 8`.


## Instructions to run the project ##
The project can be run by running the test classes present in the `ZooTest.java` class in the test directory.
The unit tests are present in the unittests folder of the project.
