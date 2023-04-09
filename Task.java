package edu.ucalgary.oop;

public class Task {


    protected int duration;
    protected String description; //three type exists(Medical,Feeding,Cleaning)
    //    protected int time;
    protected int maxWindow;
    protected int taskID;

    //Feeding Task or Medical
    public Task(int taskID, String description, int duration, int maxWindow) {

        this.description = description;
        this.duration = duration;
        this.taskID = taskID;
        this.maxWindow = maxWindow;
    }

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
