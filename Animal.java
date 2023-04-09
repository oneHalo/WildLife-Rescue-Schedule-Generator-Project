package edu.ucalgary.oop;

public class Animal {
    protected final int ID;
    protected final String NAME;
    protected final String SPECIES;
    protected final int numberOfSpecies;
    public Animal(int id, String name, String species){
        this.NAME = name;
        this.ID = id;
        this.SPECIES = species;
        this.numberOfSpecies = -1;
    }
    public Animal(int id, String name, int numberOfSpecies, String species){
        this.NAME = name;
        this.ID = id;
        this.SPECIES = species;
        this.numberOfSpecies = numberOfSpecies;
    }


    public  String getName(){return this.NAME;}

    public int getID() {return this.ID;}



}
