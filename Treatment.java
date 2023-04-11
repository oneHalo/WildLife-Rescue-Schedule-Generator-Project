package edu.ucalgary.oop;

// Treatment class used to connect between the animal and its task
// -> task (id) needs to be done to animal (id) at time (start hour)
public class Treatment {

    private int animalID; // Stores animal id for the treatment
    private int taskID; // Stores task id for the treatment
    private int startHour; // Stores start hour when the treatment needs to be done
    private boolean backupVolunteer = false; // Stores if back-up volunteer is needed (false -> not needed)
//    private int timeAvailable;

    // Initializes animal id, task id, and start hour for the treatment
    public Treatment (int animalID, int taskID, int startHour) {
        this.animalID = animalID;
        this.taskID = taskID;
        this.startHour = startHour;
//        this.timeAvailable = 60;
    }

    public int getStartHour() {return this.startHour;} // get treatment start hour
    public int getTaskID() {return this.taskID;} // get treatment task id
    public int getAnimalID() {return this.animalID;} // get treatment animal id
    public boolean getBackupVolunteer() {return this.backupVolunteer;} // get back-up volunteer status
    public void setBackupVolunteer(boolean backupVolunteer) { // set back-up volunteer status
//        if (backupVolunteer) {
//            this.timeAvailable = 120;
//        }
        this.backupVolunteer = backupVolunteer;
    }
//    public int getTimeAvailable(){
//        return this.timeAvailable;
//    }
//    public void setTimeAvailable(int timeAvailable){
//        this.timeAvailable = timeAvailable;
//    }
}
