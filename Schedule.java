package edu.ucalgary.oop;

import java.sql.*;
import java.util.*;

// Schedule class used to connect to database and generate schedule accordingly
public class Schedule {
    private static Connection dbConnect; // Used to connect to database
    private static ResultSet results; // Stores results of interaction with database

    // Stores array list of tasks sorted by their maximum window
    private static ArrayList<Task> sortedTasks = new ArrayList<>(30);

    // Stores array list of tasks (not sorted)
    private static ArrayList<Task> tasks = new ArrayList<>(30);

    // Stores array list of animals by in order of animal id
    private static ArrayList<Animal> animals = new ArrayList<>(30);

    // Stores array list of treatments by in order of the maximum window of the according task
    private static ArrayList<Treatment> treatments = new ArrayList<>(40);

    // Stores array list of array lists of treatments
    // -> Each index in first array list represents the time using 24h format (e.g. index 2 represents hour 2 to 2:59)
    // -> Each element inside the nested array list stores the treatments sorted in terms of maximum window for that
    // specific start hour
    private static ArrayList<ArrayList<Treatment>> schedule = new ArrayList<>(24);

    // Initialize each nested array list of the schedule
    public Schedule() {
        for (int i = 0; i < 24; i++) {
            schedule.add(i, new ArrayList<>());
        }
    }

    // Connect to database
    public void createConnection(){

        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EWR", "root", "Oshouman123!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Store all medical tasks from database in sorted tasks arraylist sorted by maximum window (ascending order)
    public int storeSortedMedicalTasks() {
        int counter = 0;
        try {
            Statement taskResults = dbConnect.createStatement();
            results = taskResults.executeQuery("SELECT *FROM TASKS ORDER BY MaxWindow ASC");
            while (results.next()) {
                int id = results.getInt(1);
                String description = results.getString(2);
                int duration = results.getInt(3);
                int maxWindow = results.getInt(4);
                Task task = new Task(id, description, duration, maxWindow);
                sortedTasks.add(task);
                counter++;
            }
            // tasks.add(temp);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return counter;
    }

    // Store all medical tasks from database in tasks arraylist (not sorted)
    // -> Returns total number of tasks to continue as the task ID for the general tasks to be added later on
    public int storeTasks() {
        int counter = 0;
        try {
            Statement taskResults = dbConnect.createStatement();
            results = taskResults.executeQuery("SELECT *FROM TASKS ORDER BY TaskID ASC");
            while (results.next()) {
                int id = results.getInt(1);
                String description = results.getString(2);
                int duration = results.getInt(3);
                int maxWindow = results.getInt(4);
                Task task = new Task(id, description, duration, maxWindow);
                tasks.add(task);
                counter++;
            }
            // tasks.add(temp);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return counter;
    }

    // Store all general tasks (feeding and cleaning tasks for each animal) and append them to sorted and unsorted
    // tasks array list
    // -> If animal/s is/are orphaned, remove need for general feeding task since feeding is stored as
    // medical tasks in database
    // -> Uses total number of medical tasks from database as a continuation for task id for next coming tasks
    public void storeGeneralTasks(int totalTasks) {
        HashMap<String, Integer> speciesMap = new HashMap<>(5);
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            if (!speciesMap.containsKey(animal.getSpecies())) {
                int totalFeeding = animal.getFeedingDuration() + animal.getPreparingDuration(); // Feeding is stored as feeding + preparing for food
                Task feedingTask = new Task(totalTasks, "Feeding", totalFeeding, animal.getFeedWindow());
                tasks.add(feedingTask);
                sortedTasks.add(feedingTask);
                speciesMap.put(animal.getSpecies(), totalTasks);
                totalTasks = totalTasks + 1;
            }
            if (!animal.getOrphanedStatus()) {
                Treatment feedingTreatment = new Treatment(animal.getID(),speciesMap.get(animal.getSpecies()), animal.getFeedStartHour());
                treatments.add(feedingTreatment);
            }
        }
        speciesMap = new HashMap<>(5);
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            if (!speciesMap.containsKey(animal.getSpecies())) {
                Task cleaningTask = new Task(totalTasks, "Cage Cleaning", animal.getCleaningDuration(),
                        animal.getCleanWindow());
                tasks.add(cleaningTask);
                sortedTasks.add(cleaningTask);
                speciesMap.put(animal.getSpecies(), totalTasks);
                totalTasks = totalTasks + 1;
            }
            Treatment cleaningTreatment = new Treatment(animal.getID(), speciesMap.get(animal.getSpecies()), animal.getCleanStartHour());
            treatments.add(cleaningTreatment);
        }
        System.out.println("Hi");
    }

    // Store all animals from database in animals array list in order of animal id
    public void storeAnimals() {
        try {
            Statement animalResults = dbConnect.createStatement();
            results = animalResults.executeQuery("SELECT * FROM ANIMALS");
            while (results.next()) {
                int id = results.getInt(1);
                String nickname = results.getString(2);
                String species = results.getString(3);
                Animal animal = null;
                if (species.equalsIgnoreCase("fox")) {
                    animal = new Fox(nickname, id);
                }
                else if(species.equalsIgnoreCase("porcupine")){
                    animal = new Porcupine(nickname, id);
                }
                else if(species.equalsIgnoreCase("raccoon")){
                    animal = new Raccoon(nickname, id);
                }
                else if(species.equalsIgnoreCase("coyote")){
                    animal = new Coyote(nickname, id);
                }
                else {
                    animal = new Beaver(nickname, id);
                }
                animals.add(animal);
            }
            // tasks.add(temp);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    // Prints fixed schedule
    public static void printSchedule(){
        for(int i =0; i<schedule.size(); i++){
            System.out.println("Time: " + i);
            for(int j = 0; j<schedule.get(i).size(); j++){
                System.out.print(tasks.get(schedule.get(i).get(j).getTaskID()-1).getDescription() + " - ");
                System.out.print(animals.get(schedule.get(i).get(j).getAnimalID()-1).getName() + " ");
                if (schedule.get(i).get(j).getBackupVolunteer()) {
                    System.out.print("(Backup Volunteer)");
                }
                System.out.println();
//                System.out.print("\n------- next task--------\n");
            }
            System.out.println();
        }
    }

    // gets schedule array list
    public static ArrayList<ArrayList<Treatment>> getSchedule(){
        return schedule;
    }

    // gets array list of tasks
    public static ArrayList<Task>getTasks(){
        return tasks;
    }

    // gets array list of animals
    public static ArrayList<Animal> getAnimals(){
        return animals;
    }

    // Store all treatments from database in treatments array list
    public void storeTreatments() {
        try {
            Statement treatmentsResults = dbConnect.createStatement();
            results = treatmentsResults.executeQuery("SELECT * FROM TREATMENTS");

            while (results.next()) {
                // int id = results.getInt(1);
                int animalID = results.getInt(2);
                int taskID = results.getInt(3);
                int startHour = results.getInt(4);
                Treatment treatment = new Treatment(animalID, taskID, startHour);
                treatments.add(treatment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // gets maximum window of the task, given the task id of a treatment
    public static int getWindowFromTaskID(int id) {
        int window = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (id == tasks.get(i).getID()) {
                window = tasks.get(i).getWindow();
            }
        }
        return window;
    }

    // gets duration of the task, given the task id of a treatment
    public static int getDurationFromTaskID(int id) {
        int duration = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (id == tasks.get(i).getID()) {
                duration = tasks.get(i).getDuration();
            }
        }
        return duration;
    }

    // fills up the schedule array list according to start hours of the treatments
    public void fillSchedule() {
        for (int i = 0; i < tasks.size(); i++) {
            var scanningForTheTask = sortedTasks.get(i);

            for (int j = 0; j < treatments.size(); j++) {
                if (treatments.get(j).getTaskID() == scanningForTheTask.getID()) {
                    schedule.get(treatments.get(j).getStartHour()).add(treatments.get(j));
                    // treatments.remove(j);
                }

            }
        }
    }

    // fixes the schedule according to treatments maximum windows, empty schedule time slots, and requests backup
    // volunteer when needed
    public void fixSchedule() throws IllegalScheduleException {
        for (int i = 0; i < schedule.size(); i++) {
            int time_spent = 0;
            for (int j = 0; j < schedule.get(i).size(); j++) {
                Treatment treatment = schedule.get(i).get(j);
                int taskID = treatment.getTaskID();
                time_spent += getDurationFromTaskID(taskID);
//                if (time_spent > 60) {
//                    treatment.setBackupVolunteer(true);
//                }
                if (!treatment.getBackupVolunteer()) {
                    if (time_spent > 60) {
                        if (getWindowFromTaskID(taskID) > 1 && (getWindowFromTaskID(taskID) + treatment.getStartHour() - 1) > i && i < 23) {
                            //                        for (int k = j; k < schedule.get(i).size(); k++)
                            schedule.get(i).remove(j);
                            j -= 1;
                            schedule.get(i + 1).add(treatment);
                        } else {
//                        throw new IllegalScheduleException("");
                            treatment.setBackupVolunteer(true);
                            i = treatment.getStartHour();
                        }
                    }
                } else if (treatment.getBackupVolunteer()) {
                    if (time_spent > 120) {
                        if (getWindowFromTaskID(taskID) > 1 && (getWindowFromTaskID(taskID) + treatment.getStartHour() - 1) > i && i < 23) {
                            //                        for (int k = j; k < schedule.get(i).size(); k++)
                            schedule.get(i).remove(j);
                            j -= 1;
                            schedule.get(i + 1).add(treatment);
                        } else {
                            throw new IllegalScheduleException("");
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IllegalScheduleException {
        Schedule myJDBC = new Schedule();
        myJDBC.createConnection();
        myJDBC.storeAnimals();
        myJDBC.storeTasks();
        int totalTasks = myJDBC.storeSortedMedicalTasks();
        myJDBC.storeTreatments();
        myJDBC.storeGeneralTasks(totalTasks+1);
        myJDBC.fillSchedule();
        myJDBC.fixSchedule();

        //minMindowReturner();
//        System.out.println("hi");
//
//
//
//
//
//        for (int i = 0; i < schedule.size(); i++) {
//            int time_slot = 0;
//            for (int j = 0; j < schedule.get(i).size(); j++) {
//                Treatment treatment = schedule.get(i).get(j);
//                int taskID = treatment.getTaskID();
//                time_slot += getDurationFromTaskID(taskID);
//            }
//            System.out.println(time_slot);
//        }
//        System.out.println("hi");
        printSchedule();
    }

//    public static void minMindowReturner(){
//        ArrayList<Task> tempSort = new ArrayList<>(tasks.size());
//        for(int i = 0; i<tasks.size(); i++){
//            int maxWindow = tasks.get(i).maxWindow;
//            for(int j = i+1; j<tasks.size(); j++){
//                if(maxWindow >= tasks.get(j).maxWindow){
//                    if(!tasks.contains(tasks.get(j))){
//                        tempSort.add(i,tasks.get(j));}
//                }
//            }
//        }
//        tasks = tempSort;
//
//    }
}
