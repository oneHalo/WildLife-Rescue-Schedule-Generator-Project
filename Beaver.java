package edu.ucalgary.oop;

// Beaver class allows for creation of all beaver instances currently in EWR
// Animal type beaver is diurnal --> inherits diurnal animal feeding hours
public class Beaver extends Diurnal {

    // initialize beaver name, id, feeding duration, cleaning duration, and food preparing duration
    public Beaver(String name, int id) {
        super(name, id, "Beaver");
        super.feedingDuration = 5;
        super.cleaningDuration = 5;
        super.preparingDuration = 0;
    }

//    public Beaver(String name, int id, int numberOfSpecies) {
//        super(id, name, numberOfSpecies, "Beaver");
//    }
}
