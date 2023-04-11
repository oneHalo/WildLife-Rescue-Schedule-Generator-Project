package edu.ucalgary.oop;

// Nocturnal class allows for creation of all nocturnal animal instances currently in EWR
// Nocturnal animals inherit all animal features
public class Nocturnal extends Animal {

    // initialize nocturnal animals' name, id, species, feeding max window, and feeding start hours
    public Nocturnal(String name, int id, String species) {
        super(id,name,species);
        super.feedMaxWindow = 3;
        super.feedStartHour = 0;
    }
}
