package edu.ucalgary.oop;

public class Task {
//    protected int timeWindowStart;
//    protected String type;
//    protected int duration;
//    private static ArrayList<Task> tasks;
//    protected int quantityOfTask;
//
//
//    public Task(boolean medical ,int timeWindowStart,String description, int duration){
//        this.description = description;
//        this.duration = duration;
//        this.timeWindowStart = timeWindowStart;
//        tasks.add()
//        Schedule.updateSchedule(this);
//    }
//    public Task(int timeWindowStart, ArrayList<String> description) {
//
//
//    }
//
//    public ArrayList<Task> getTasks() {return this.tasks;}


    protected int duration;
    protected String description; //three type exists(Medical,Feeding,Cleaning)
    //    protected int time;
    protected int maxWindow;
    protected int taskID;

    //Feeding Task or Medical
    public Task(int taskID, String description, int duration, int maxWindow) {
//       if (medical){
//           this.window = 1;
//       }
//       else{
//           this.window = 3;
//       }
        this.description = description;
        this.duration = duration;
        this.taskID = taskID;
        this.maxWindow = maxWindow;
    }

    //Cleaning Task
//    public Task(String description, int duration){
//        this.description = description;
//        this.duration = duration;
//        this.time = -1;
//        this.window = -1;
//    }
//}
    public int getWindow() {
        return this.maxWindow;
    }
    public int getID() {
        return this.taskID;
    }
    public int getDuration() {
        return this.duration;
    }
    public String getDescription() {
        return this.description;
    }
}