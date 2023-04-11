package edu.ucalgary.oop;


// Animal class to store all animals rescued by EWR
public class Animal {
    // All variables are inherited by subclasses --> protected visibility

    protected final int ID; // Stores animal ID
    protected final String NAME; // Stores animal nickname
    protected final String SPECIES; // Stores animal species
//    protected final int numberOfSpecies;
    protected int cleaningDuration; // Stores time required to clean animal's cage
    protected int preparingDuration; // Stores time required to prepare food for animal
    protected int feedingDuration; // Stores time required to feed animal

    // Stores max window to clean animal's cage (cleaning can be done any time and is flexible) - same for all animals
    protected final int CLEANMAXWINDOW = 24;

    protected int feedMaxWindow; // Stores max window to feed animal
    protected int feedStartHour; // Stores animal feeding task start hour
    protected final int CLEANSTARTHOUR = 0; // Stores animal cleaning task start hour - same for all animals
    protected boolean orphanedStatus; // Stores animal orphaned status (true -> orphaned)

    // Initialize animal id, name, species and orphaned status
    // If animal name in database contains "and" -> assumed to be orphaned since all orphaned animals count as one
    public Animal(int id, String name, String species){
        this.NAME = name;
        this.ID = id;
        this.SPECIES = species;
        if (name.contains("and")) {
            this.orphanedStatus = true;
        }
        else {
            this.orphanedStatus = false;
        }
    }
//    public Animal(int id, String name, int numberOfSpecies, String species){
//        this.NAME = name;
//        this.ID = id;
//        this.SPECIES = species;
//        this.numberOfSpecies = numberOfSpecies;
//    }


    public  String getName(){return this.NAME;} // get animal name
    public  String getSpecies(){return this.SPECIES;} // get animal species
    public int getID() {return this.ID;} // get animal id
    public boolean getOrphanedStatus() {return this.orphanedStatus;} // get animal orphaned status
    public int getCleaningDuration() {return this.cleaningDuration;} // get animal clean duration
    public int getPreparingDuration() {return this.preparingDuration;} // get animal food preparing duration
    public int getFeedingDuration() {return this.feedingDuration;} // get animal feeding duration
    public int getFeedWindow() {return this.feedMaxWindow;} // get animal feeding max window
    public int getCleanWindow() {return this.CLEANMAXWINDOW;} // get animal cleaning max window
    public int getFeedStartHour() {return this.feedStartHour;} // get animal feeding start hour
    public int getCleanStartHour() {return this.CLEANSTARTHOUR;} // get animal cleaning start hour



}
