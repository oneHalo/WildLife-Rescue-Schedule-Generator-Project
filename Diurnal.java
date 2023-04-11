package edu.ucalgary.oop;

// Diurnal class allows for creation of all diurnal animal instances currently in EWR
// Diurnal animals inherit all animal features
public class Diurnal extends Animal{

    // initialize diurnal animals' name, id, species, feeding max window, and feeding start hours
    public Diurnal(String name, int id, String species) {
        super(id,name,species);
        super.feedMaxWindow = 3;
        super.feedStartHour = 8;
    }
}
