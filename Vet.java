package edu.ucalgary.oop;

public class Vet {
    private final String NAME;
    private Schedule schedule;
    private VetTask tasks;//Does this make sense?? New typeofTasks

    Vet(String NAME, Schedule schedule, VetTask tasks){
        this.NAME = NAME;
        this.schedule = schedule;
        this.tasks = tasks;
    }
    public String getName(){
        return this.NAME;
    }
    public Schedule getSchedule(){
        return this.schedule;
    }
    public VetTask getTasks(){
        return this.tasks;
    }
    public void setSchedule(Schedule schedule){
        this.schedule = schedule;
    }
    public void setTasks(VetTask task){
        this.tasks = task;
    }
}
