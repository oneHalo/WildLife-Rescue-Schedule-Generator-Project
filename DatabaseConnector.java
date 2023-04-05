package edu.ucalgary.oop;


import java.sql.*;
import java.util.*;

public class DatabaseConnector {
    private static Connection dbConnect;
    private static ResultSet results;
    private static ArrayList<Task> tasks = new ArrayList<>(30);
    private static ArrayList<Animal> animals = new ArrayList<>(30);
    private static ArrayList<Treatment> treatments = new ArrayList<>(40);
    private static ArrayList<ArrayList<Treatment>> schedule = new ArrayList<>(24);
    
     public DatabaseConnector() {
         for (int i = 0; i < 24; i++) {
             schedule.add(i, new ArrayList<>());
         }
     }

    public void createConnection(){

        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EWR", "root", "Oshouman123!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void storeTasks() {
        try {
            Statement taskResults = dbConnect.createStatement();
            results = taskResults.executeQuery("SELECT *FROM TASKS ORDER BY MaxWindow ASC");
            while (results.next()) {
                int id = results.getInt(1);
                String description = results.getString(2);
                int duration = results.getInt(3);
                int maxWindow = results.getInt(4);
                Task task = new Task(id, description, duration, maxWindow);
                tasks.add(task);
            }
            // tasks.add(temp);
        }catch(SQLException e){
            e.printStackTrace();
        }        
    }

    public void storeAnimals() {
        try {
            Statement animalResults = dbConnect.createStatement();
            results = animalResults.executeQuery("SELECT * FROM ANIMALS");
            while (results.next()) {
                int id = results.getInt(1);
                String nickname = results.getString(2);
                String species = results.getString(3);
                Animal animal = new Animal(id, nickname, species);
                animals.add(animal);
            }
            // tasks.add(temp);
        }catch(SQLException e){
            e.printStackTrace();
        }        
    }

    public static int getWindowFromTaskID(int id) {
         int window = 0;
         for (int i = 0; i < tasks.size(); i++) {
             if (id == tasks.get(i).getID()) {
                 window = tasks.get(i).getWindow();
             }
         }
         return window;
    }

    public static int getDurationFromTaskID(int id) {
        int duration = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (id == tasks.get(i).getID()) {
                duration = tasks.get(i).getDuration();
            }
        }
        return duration;
    }

    public static void main(String[] args) throws IllegalScheduleException {
        DatabaseConnector myJDBC = new DatabaseConnector();
        myJDBC.createConnection();
        myJDBC.storeTasks();
        myJDBC.storeAnimals();
        //         try {
        //     Statement taskResults = dbConnect.createStatement();
        //     results = taskResults.executeQuery("SELECT * FROM TASKS");
        //     while (results.next()) {
        //         int id = results.getInt(1);
        //         String description = results.getString(2);
        //         int duration = results.getInt(3);
        //         int maxWindow = results.getInt(4);
        //         Task task = new Task(id, description, duration, maxWindow);
        //         tasks.add(task);
        //     }
        //     // tasks.add(temp);
        // }catch(SQLException e){
        //     e.printStackTrace();
        // }

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

        }catch(SQLException e){
            e.printStackTrace();
        }

    //minMindowReturner();
        System.out.println("hi");

        for(int i = 0; i<tasks.size(); i++){
            var scanningForTheTask = tasks.get(i);

            for(int j = 0; j< treatments.size(); j++){
                if(treatments.get(j).getTaskID() == scanningForTheTask.taskID){
                    schedule.get(treatments.get(j).getStartHour()).add(treatments.get(j));
                   // treatments.remove(j);
                }

            }
        }
        System.out.println("Hi");
//                for (int i = 0; i<schedule.size(); i++){
//                    for (int j = 0; j< schedule.get(i).size(); j++){
//                        Treatment treatment = schedule.get(i).get(j);
//                        for (int k = 1; k< getWindowFromTaskID(treatment.getTaskID()); k++) {
//                            schedule.get(i+k).add(treatment);
//                        }
//                    }
//                }
        for (int i = 0; i < schedule.size(); i++) {
            int time_slot = 0;
            for (int j = 0; j < schedule.get(i).size(); j++) {
                Treatment treatment = schedule.get(i).get(j);
                int taskID = treatment.getTaskID();
                time_slot += getDurationFromTaskID(taskID);
                if (time_slot > 60) {
                    if (getWindowFromTaskID(taskID) > 1 && (getWindowFromTaskID(taskID) + treatment.getStartHour() - 1) > i && i < 23) {
//                        for (int k = j; k < schedule.get(i).size(); k++)
                        schedule.get(i).remove(j);
                        j-=1;
                        schedule.get(i+1).add(treatment);
                    }
                    else {
                        throw new IllegalScheduleException("");
                    }
//                    for (int k = 1; k < getWindowFromTaskID(taskID); j++) {
//                        schedule.remove(treatment);
//                        schedule.get(i+k).add(treatment);
//                    }
//                    schedule.get(i).get(j)
                }
            }
        }
        for (int i = 0; i < schedule.size(); i++) {
            int time_slot = 0;
            for (int j = 0; j < schedule.get(i).size(); j++) {
                Treatment treatment = schedule.get(i).get(j);
                int taskID = treatment.getTaskID();
                time_slot += getDurationFromTaskID(taskID);
            }
        }
        System.out.println("hi");
    //     for (int i = 0; i < treatments.size(); i++) {
    //         for (int j = 0; j < treatments.get(i).size(); j++) {
    //             System.out.println(treatments.get(i).get(j).getStartHour());
    //         }
    //         System.out.print("\n");
    //     }
    //         tasks.add(temp);


    }

    public static void minMindowReturner(){
        ArrayList<Task> tempSort = new ArrayList<>(tasks.size());
        for(int i = 0; i<tasks.size(); i++){
            int maxWindow = tasks.get(i).maxWindow;
            for(int j = i+1; j<tasks.size(); j++){
                if(maxWindow >= tasks.get(j).maxWindow){
                  if(!tasks.contains(tasks.get(j))){
                    tempSort.add(i,tasks.get(j));}
                }
            }
        }
        tasks = tempSort;

    }
}
