package edu.ucalgary.oop;

public class Coyote extends Animal {
    public Coyote(String name, int id){
        super(id, name, "Coyote");
    }
    public Coyote(String name, int id, int numberOfSpecies){
        super(id, name, numberOfSpecies,"Coyote" );
    }

}
