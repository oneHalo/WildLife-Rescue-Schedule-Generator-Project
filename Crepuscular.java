package edu.ucalgary.oop;

// Crepuscular class allows for creation of all crepuscular animal instances currently in EWR
// Crepuscular animals inherit all animal features
public class Crepuscular extends Animal{

    // initialize crepuscular animals' name, id, species, feeding max window, and feeding start hours
    public Crepuscular(String name, int id, String species) {
        super(id,name,species);
        super.feedMaxWindow = 3;
        super.feedStartHour = 19;
    }
}
