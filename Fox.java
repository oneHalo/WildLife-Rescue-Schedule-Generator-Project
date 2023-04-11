package edu.ucalgary.oop;

// Fox class allows for creation of all fox instances currently in EWR
// Animal type fox is nocturnal --> inherits nocturnal animal feeding hours
public class Fox extends Nocturnal {

    // initialize fox name, id, feeding duration, cleaning duration, and food preparing duration
    public Fox(String name, int id) {
        super(name, id, "Fox");
        super.feedingDuration = 5;
        super.cleaningDuration = 5;
        super.preparingDuration = 5;
    }

//    public Fox(String name, int id, int numberOfSpecies) {
//        super(id, name, numberOfSpecies, "Fox");
//    }
}
