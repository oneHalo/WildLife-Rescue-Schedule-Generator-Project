package edu.ucalgary.oop;

public class Porcupine extends Animal {
    public Porcupine(String name, int id) {
        super(id, name, "Porcupine");
    }

    public Porcupine(String name, int id, int numberOfSpecies) {
        super(id, name, numberOfSpecies, "Porcupine");
    }
}