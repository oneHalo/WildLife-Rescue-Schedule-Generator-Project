package edu.ucalgary.oop;

public class Volunteer {
    private final String NAME;
    private final String LNAME;
    private Schedule schedule;
    private VolunteerTask volunteerTask;
    Volunteer(String FNAME, String LNAME, Schedule schedule, VolunteerTask volunteerTask){
        this.NAME = FNAME;
        this.LNAME = LNAME;
        this.schedule = schedule;
        this.volunteerTask = volunteerTask;
    }
    public String getNAME(){
        return this.NAME;
    }
    public Schedule getSchedule(){
        return this.schedule;
    }
    public VolunteerTask getVolunteerTask(){
        return this.volunteerTask;
    }
    public void setSchedule(){
        this.schedule = schedule;
    }
    public void setVolunteerTask(){
        this.volunteerTask = volunteerTask;
    }
}
