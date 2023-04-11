package edu.ucalgary.oop;

// Task class used to store all types of task instances
public class Task {

    private int duration; // Stores required time to complete task
    private String description; // Stores description of the task
    private int maxWindow; // Stores maximum window of the task
    private int taskID; // Stores task id

    // Initializes task id, description, duration, and max window
    public Task(int taskID, String description, int duration, int maxWindow) {

        this.description = description;
        this.duration = duration;
        this.taskID = taskID;
        this.maxWindow = maxWindow;
    }

    public int getWindow() {
        return this.maxWindow;
    } // get task maximum window
    public int getID() {
        return this.taskID;
    } // get task id
    public int getDuration() {
        return this.duration;
    } // get task duration
    public String getDescription() {
        return this.description;
    } // get task description
}
