package edu.ucalgary.oop;

// Porcupine class allows for creation of all porcupine instances currently in EWR
// Animal type porcupine is crepuscular --> inherits crepuscular animal feeding hours
public class Porcupine extends Crepuscular {

    // initialize porcupine name, id, feeding duration, cleaning duration, and food preparing duration
    public Porcupine(String name, int id) {
        super(name, id, "Porcupine");
        super.feedingDuration = 5;
        super.cleaningDuration = 10;
        super.preparingDuration = 0;
    }

//    public Porcupine(String name, int id, int numberOfSpecies) {
//        super(id, name, numberOfSpecies, "Porcupine");
//    }
}