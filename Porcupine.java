package edu.ucalgary.oop;

public class Porcupine extends Animal {
    public Porcupine(String name, int id){
        super(id, name, "Porcupine");
        // super(name,id);
//        super.cleaningTime = 5;
//        super.feedTime = 5;
//        super.feedWindow = 3;
//        super.prepTime = 0;
//        addInitialTask();
    }
//    public Porcupine(String name, int id, int numberOfAnimals){
//        super(name, id,numberOfAnimals);
//        super.cleaningTime = 5;
//        super.feedTime = 5;
//        super.feedWindow = 3;
//        super.prepTime = 0;
//        addInitialTask();
//    }
//    public void addInitialTask(){
//        Task tempFeedingTask= new Task("Feeding",this.calculateFeedDuration());
//        Task tempCleaningTask= new Task("Cleaning",this.getCleaningTime());
//
//        animalTasks.add(tempFeedingTask);
//        animalTasks.add(tempCleaningTask);
//    }

}
