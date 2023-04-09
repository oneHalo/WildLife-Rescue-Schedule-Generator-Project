package edu.ucalgary.oop;

public class Fox extends Animal {
    public Fox(String name, int id) {
        super(id, name, "Fox");
    }

    public Fox(String name, int id, int numberOfSpecies) {
        super(id, name, numberOfSpecies, "Fox");
    }
}
