package edu.ucalgary.oop;

import java.util.ArrayList;

public class VolunteerTask implements Task {
    private String TYPE; //Not final -> changed
    private ArrayList<String>[] task;
    private static final String[] TYPES = {"S", "M"};
    private  boolean FLEXIBILITY; //Not final  -> changed
    private Schedule schedule;

    VolunteerTask(String TYPE, ArrayList<String>[] allTasks, Schedule schedule){
        boolean validType = false;
        for(int i = 0; i< TYPES.length; i++){
            if(TYPE.equalsIgnoreCase(TYPES[i])){
                this.TYPE = TYPES[i];
                validType = true;
                if(TYPE.equalsIgnoreCase("s")){
                    FLEXIBILITY = false;
                }
                else{
                    FLEXIBILITY = true;
                }
                break;
            }
        }
        if(!validType){
            throw new IllegalArgumentException("Please specify a type of task. Either S(standard) or M(medical)");
        }
        this.schedule = schedule;
        this.task = allTasks;

    }

    @Override
    public String getType() {
        return this.TYPE;
    }

    @Override
    public boolean getFlexibility() {
        return this.FLEXIBILITY;
    }

    @Override
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }


}
