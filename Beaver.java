package edu.ucalgary.oop;

public class Beaver extends Animal {

    public Beaver(String name, int id) {
        super(id, name, "Beaver");
    }

    public Beaver(String name, int id, int numberOfSpecies) {
        super(id, name, numberOfSpecies, "Beaver");
    }
}
