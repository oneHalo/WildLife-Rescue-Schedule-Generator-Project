package edu.ucalgary.oop;

// Coyote class allows for creation of all coyote instances currently in EWR
// Animal type coyote is crepuscular --> inherits crepuscular animal feeding hours
public class Coyote extends Crepuscular {

    // initialize coyote name, id, feeding duration, cleaning duration, and food preparing duration
    public Coyote(String name, int id){
        super(name, id, "Coyote");
        super.feedingDuration = 5;
        super.cleaningDuration = 5;
        super.preparingDuration = 10;
    }
//    public Coyote(String name, int id, int numberOfSpecies){
//        super(id, name, numberOfSpecies,"Coyote" );
//    }

}
