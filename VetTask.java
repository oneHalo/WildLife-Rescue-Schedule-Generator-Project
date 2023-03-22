package edu.ucalgary.oop;

import java.util.ArrayList;

public class VetTask implements Task {
    // private final String TYPE = "M";
    private ArrayList<String>[] task;
    private Schedule schedule;

    VetTask(Schedule schedule, ArrayList<String>[] tasks) {
        this.task = tasks;
        this.schedule = schedule;
    }

    @Override
    public String getType() {
        return "M";
    }

    @Override
    public boolean getFlexibility() {
        return false;
    }

    @Override
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public ArrayList<String>[] getTask(){
        return this.task;
    }
    public void setTask(ArrayList<String>[] tasks){
        this.task = tasks;
    }

}