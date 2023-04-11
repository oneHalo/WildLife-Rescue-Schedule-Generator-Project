package edu.ucalgary.oop;

// Raccoon class allows for creation of all raccoon instances currently in EWR
// Animal type raccoon is nocturnal --> inherits nocturnal animal feeding hours
public class Raccoon extends Nocturnal {

    // initialize raccoon name, id, feeding duration, cleaning duration, and food preparing duration
    public Raccoon(String name, int id) {
        super(name, id, "Raccoon");
        super.feedingDuration = 5;
        super.cleaningDuration = 5;
        super.preparingDuration = 0;
    }

//    public Raccoon(String name, int id, int numberOfSpecies) {
//        super(id, name, numberOfSpecies, "Raccoon");
//    }
}
