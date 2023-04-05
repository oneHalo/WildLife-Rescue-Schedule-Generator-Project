package edu.ucalgary.oop;

public class Fox extends Animal {

    public Fox(String name, int id){

        super(id, name, "Porcupine");
//        super.cleaningTime = 5;
//        super.feedTime = 5;
//        super.feedWindow = 3;
//        super.prepTime = 0;
//        addInitialTask();

    }
//    public Fox(String name, int id, int numberofAnimals){
//        super(name, id, numberofAnimals);
//        super.cleaningTime = 5;
//        super.feedTime = 5;
//        super.feedWindow = 3;
//        super.prepTime = 0;
//        addInitialTask();
//    }
//    public void addInitialTask(){
//
//        //Make sure this is correctly implemented
//        Task tempFeedingTask= new ask(false,"Feeding",this.calculateFeedDuration(), 7);
//        Task tempCleaningTask= new Task("Cleaning",this.getCleaningTime());
//
//        animalTasks.add(tempFeedingTask);
//        animalTasks.add(tempCleaningTask);
//    }
}
