package edu.ucalgary.oop;

import java.util.LinkedList;

public class Animal {
    protected final int ID;
    protected final String NAME;
    protected final String SPECIES;
//    protected final boolean RESC_TYPE;
//    protected  int feedTime;
//    protected  int prepTime;
//    protected  int cleaningTime;
//    protected  int feedWindow;
//    protected  int numberOfAnimals;
    // protected LinkedList<Task> animalTasks;
    public Animal(int id, String name, String species){
        this.NAME = name;
//        this.RESC_TYPE = resc_type;
        this.ID = id;
        this.SPECIES = species;
//        this.numberOfAnimals = 1;
//        animalTasks = new LinkedList<>();
//        edu.ucalgary.oop2.Task tempFeedingTask= new edu.ucalgary.oop2.Task("Feeding",this.calculateFeedDuration());
//        edu.ucalgary.oop2.Task tempCleaningTask= new edu.ucalgary.oop2.Task("Cleaning",this.getCleaningTime());
//
//        animalTasks.add(tempCleaningTask);
//        animalTasks.add(tempFeedingTask);
    }
//    public Animal(String name, int id, int numberOfAnimals){
//        this.NAME = name;
//        this.ID = id;
//        this.numberOfAnimals = numberOfAnimals;
//        animalTasks = new LinkedList<>();
//
//    }
//    public  int getFeedTime(){return this.feedTime;}
//
//    public  int getPrepTime(){return this.prepTime;}
//
//    public  int getCleaningTime(){return this.cleaningTime;}
//
//    public  int getFeedWindow(){return this.feedWindow;}

//    public  String getRescType(){return this.RESC_TYPE;}

    public  String getName(){return this.NAME;}

    public int getID() {return this.ID;}
//
//    public int calculateFeedDuration(){
//        return this.getPrepTime() + (this.getFeedTime() * numberOfAnimals);
//    }
//    public void updateTask(Task task){
//        this.animalTasks.add(task);
//    }


}
