package edu.ucalgary.oop;
import java.util.ArrayList;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;


import edu.ucalgary.oop.Schedule;
import edu.ucalgary.oop.Treatment;


public class ScheduleTest {

    @Test
    public void testBeaverConstructor(){
        String expectedName = new String("Joe");
        String expectedSpecies = new String("Beaver");
        int expectedID = 0;
        int expectedFeedingDuration = 5;
        int expectedCleaningDuration = 5;
        int expectedPreparingDuration = 0;
        int expectedFeedMaxWindow = 3;
        int expectedFeedStartHour = 8;
        Beaver testBeaver = new Beaver(expectedName, expectedID);

        String actualName = testBeaver.getName();
        String actualSpecies = testBeaver.getSpecies();
        int actualID = testBeaver.getID();
        int actualFeedingDuration = testBeaver.getFeedingDuration();
        int actualCleaningDuration = testBeaver.getCleaningDuration();
        int actualPreparingDuration = testBeaver.getPreparingDuration();
        int actualFeedMaxWindow = testBeaver.getFeedWindow();
        int actualFeedStartHour = testBeaver.getFeedStartHour();

        assertEquals("Name does not match",expectedName,actualName);
        assertEquals("Species does not match",expectedSpecies,actualSpecies);
        assertEquals("ID does not match",expectedID,actualID);
        assertEquals("Feeding Duration does not match",expectedFeedingDuration,actualFeedingDuration);
        assertEquals("Cleaning Duration does not match",expectedCleaningDuration,actualCleaningDuration);
        assertEquals("Preparing Duration does not match",expectedPreparingDuration,actualPreparingDuration);
        assertEquals("Feed Max Window does not match",expectedFeedMaxWindow,actualFeedMaxWindow);

        assertEquals("Feed Start Hour does not match",expectedFeedStartHour,actualFeedStartHour);


    }

    @Test
    public void testCoyotetConstructor(){
        String expectedName = new String("Bilal");
        String expectedSpecies = new String("Coyote");
        int expectedID = 1;
        int expectedFeedingDuration = 5;
        int expectedCleaningDuration = 5;
        int expectedPreparingDuration = 10;
        int expectedFeedMaxWindow = 3;
        int expectedFeedStartHour = 19;
        Coyote testCoyote = new Coyote(expectedName, expectedID);

        String actualName = testCoyote.getName();
        String actualSpecies = testCoyote.getSpecies();
        int actualID = testCoyote.getID();
        int actualFeedingDuration = testCoyote.getFeedingDuration();
        int actualCleaningDuration = testCoyote.getCleaningDuration();
        int actualPreparingDuration = testCoyote.getPreparingDuration();
        int actualFeedMaxWindow = testCoyote.getFeedWindow();
        int actualFeedStartHour = testCoyote.getFeedStartHour();

        assertEquals("Name does not match",expectedName,actualName);
        assertEquals("Species does not match",expectedSpecies,actualSpecies);
        assertEquals("ID does not match",expectedID,actualID);
        assertEquals("Feeding Duration does not match",expectedFeedingDuration,actualFeedingDuration);
        assertEquals("Cleaning Duration does not match",expectedCleaningDuration,actualCleaningDuration);
        assertEquals("Preparing Duration does not match",expectedPreparingDuration,actualPreparingDuration);
        assertEquals("Feed Max Window does not match",expectedFeedMaxWindow,actualFeedMaxWindow);

        assertEquals("Feed Start Hour does not match",expectedFeedStartHour,actualFeedStartHour);


    }

    @Test
    public void testFoxtConstructor(){
        String expectedName = new String("Bob");
        String expectedSpecies = new String("Fox");
        int expectedID = 1;
        int expectedFeedingDuration = 5;
        int expectedCleaningDuration = 5;
        int expectedPreparingDuration = 5;
        int expectedFeedMaxWindow = 3;
        int expectedFeedStartHour = 0;
        Fox testFox = new Fox(expectedName, expectedID);

        String actualName = testFox.getName();
        String actualSpecies = testFox.getSpecies();
        int actualID = testFox.getID();
        int actualFeedingDuration = testFox.getFeedingDuration();
        int actualCleaningDuration = testFox.getCleaningDuration();
        int actualPreparingDuration = testFox.getPreparingDuration();
        int actualFeedMaxWindow = testFox.getFeedWindow();
        int actualFeedStartHour = testFox.getFeedStartHour();

        assertEquals("Name does not match",expectedName,actualName);
        assertEquals("Species does not match",expectedSpecies,actualSpecies);
        assertEquals("ID does not match",expectedID,actualID);
        assertEquals("Feeding Duration does not match",expectedFeedingDuration,actualFeedingDuration);
        assertEquals("Cleaning Duration does not match",expectedCleaningDuration,actualCleaningDuration);
        assertEquals("Preparing Duration does not match",expectedPreparingDuration,actualPreparingDuration);
        assertEquals("Feed Max Window does not match",expectedFeedMaxWindow,actualFeedMaxWindow);

        assertEquals("Feed Start Hour does not match",expectedFeedStartHour,actualFeedStartHour);


    }

    @Test
    public void testPorcupinetConstructor(){
        String expectedName = new String("Spiky");
        String expectedSpecies = new String("Porcupine");
        int expectedID = 1;
        int expectedFeedingDuration = 5;
        int expectedCleaningDuration = 10;
        int expectedPreparingDuration = 0;
        int expectedFeedMaxWindow = 3;
        int expectedFeedStartHour = 19;
        Porcupine testPorcupine = new Porcupine(expectedName, expectedID);

        String actualName = testPorcupine.getName();
        String actualSpecies = testPorcupine.getSpecies();
        int actualID = testPorcupine.getID();
        int actualFeedingDuration = testPorcupine.getFeedingDuration();
        int actualCleaningDuration = testPorcupine.getCleaningDuration();
        int actualPreparingDuration = testPorcupine.getPreparingDuration();
        int actualFeedMaxWindow = testPorcupine.getFeedWindow();
        int actualFeedStartHour = testPorcupine.getFeedStartHour();

        assertEquals("Name does not match",expectedName,actualName);
        assertEquals("Species does not match",expectedSpecies,actualSpecies);
        assertEquals("ID does not match",expectedID,actualID);
        assertEquals("Feeding Duration does not match",expectedFeedingDuration,actualFeedingDuration);
        assertEquals("Cleaning Duration does not match",expectedCleaningDuration,actualCleaningDuration);
        assertEquals("Preparing Duration does not match",expectedPreparingDuration,actualPreparingDuration);
        assertEquals("Feed Max Window does not match",expectedFeedMaxWindow,actualFeedMaxWindow);

        assertEquals("Feed Start Hour does not match",expectedFeedStartHour,actualFeedStartHour);


    }

    @Test
    public void testRacoontConstructor(){
        String expectedName = new String("Frisky");
        String expectedSpecies = new String("Raccoon");
        int expectedID = 1;
        int expectedFeedingDuration = 5;
        int expectedCleaningDuration = 5;
        int expectedPreparingDuration = 0;
        int expectedFeedMaxWindow = 3;
        int expectedFeedStartHour = 0;
        Raccoon testRaccoon = new Raccoon(expectedName, expectedID);

        String actualName = testRaccoon.getName();
        String actualSpecies = testRaccoon.getSpecies();
        int actualID = testRaccoon.getID();
        int actualFeedingDuration = testRaccoon.getFeedingDuration();
        int actualCleaningDuration = testRaccoon.getCleaningDuration();
        int actualPreparingDuration = testRaccoon.getPreparingDuration();
        int actualFeedMaxWindow = testRaccoon.getFeedWindow();
        int actualFeedStartHour = testRaccoon.getFeedStartHour();

        assertEquals("Name does not match",expectedName,actualName);
        assertEquals("Species does not match",expectedSpecies,actualSpecies);
        assertEquals("ID does not match",expectedID,actualID);
        assertEquals("Feeding Duration does not match",expectedFeedingDuration,actualFeedingDuration);
        assertEquals("Cleaning Duration does not match",expectedCleaningDuration,actualCleaningDuration);
        assertEquals("Preparing Duration does not match",expectedPreparingDuration,actualPreparingDuration);
        assertEquals("Feed Max Window does not match",expectedFeedMaxWindow,actualFeedMaxWindow);

        assertEquals("Feed Start Hour does not match",expectedFeedStartHour,actualFeedStartHour);

    }

    @Test
    public void testOrphanedStatus(){
        Beaver testBeaver = new Beaver("Winston and Clara", 0);

        assertTrue("Orphaned State is not correct",testBeaver.getOrphanedStatus() );
    }

    @Test
    public void testTaskConstructor(){
        String expectedDescription = new String("null");
        int expectedDuration = 20;
        int expectedTaskID = 1;
        int expectedMaxWindow = 3;

        Task testTask = new Task(expectedTaskID, expectedDescription,expectedDuration,expectedMaxWindow);

        String actualDescription = testTask.getDescription();
        int actualDuration = testTask.getDuration();
        int actualTaskID = testTask.getID();
        int actualMaxWindow = testTask.getWindow();

        assertEquals("Description does not match",expectedDescription, actualDescription);
        assertEquals("Duration does not match",expectedDuration, actualDuration);
        assertEquals("Task ID does not match",expectedTaskID, actualTaskID);
        assertEquals("Max Window does not match",expectedMaxWindow, actualMaxWindow);

    }

    @Test
    public void testTreatmentConstructor(){
        int expectedAnimalID = 1;
        int expectedTaskID = 10;
        int expectedStartHour = 19;

        Treatment testTreatment = new Treatment(expectedAnimalID,expectedTaskID, expectedStartHour);

        int actualAnimalID = testTreatment.getAnimalID();
        int actualTaskID = testTreatment.getTaskID();
        int actualStartHour = testTreatment.getStartHour();

        assertEquals("Animal ID does not match",expectedAnimalID, actualAnimalID);
        assertEquals("Task ID does not match",expectedTaskID, actualTaskID);
        assertEquals("Start hour does not match",expectedStartHour, actualStartHour);


    }

    @Test
    public void testIllegalScheduleException() {
        Schedule schedule = new Schedule();
        boolean exceptionThrownFlag = false;
        for (int i = 0; i < 20; i++) {
            Task task = new Task(i+1, "Test" + i, 130, 1);
            Animal animal = new Animal(i+1, "Test" + i,"Test" + i);
            Treatment treatment = new Treatment(i+1, i+1, i);
            Schedule.getTasks().add(task);
            Schedule.getAnimals().add(animal);
            Schedule.getTreatments().add(treatment);
            Schedule.setSortedTasks(Schedule.getTasks());


        }
        try {
            Schedule.fillSchedule();
            Schedule.fixSchedule();
        } catch (IllegalScheduleException e) {
            exceptionThrownFlag = true;
        }

        assertTrue("Exception was not thrown",exceptionThrownFlag);
    }

    @Test
    public void testBackupVolunteer() throws IllegalScheduleException{
        Schedule schedule = new Schedule();
        Task task1 = new Task(1, "Test1", 40, 1);
        Schedule.getTasks().add(task1);
        Animal animal1 = new Animal(1, "Spike", "Fox");
        Animal animal2 = new Animal(2, "Joe", "Fox");
        Schedule.getAnimals().add(animal1);
        Schedule.getAnimals().add(animal2);
        Treatment treatment1 = new Treatment(1, 1, 1);
        Treatment treatment2 = new Treatment(2, 1, 1);
        Schedule.getTreatments().add(treatment1);
        Schedule.getTreatments().add(treatment2);
        Schedule.setSortedTasks(Schedule.getTasks());
        Schedule.fillSchedule();
        Schedule.fixSchedule();
        assertEquals(Schedule.getSchedule().get(1).get(1).getBackupVolunteer(), true);
    }

    @Test
    public void testSortedTasks() {
        Schedule schedule = new Schedule();
        int totalTasks = schedule.storeSortedMedicalTasks();
        int window = 0;
        boolean flag = true;
        for (int i = 0; i < Schedule.getTasks().size(); i++) {
            if (window < Schedule.getTasks().get(i).getWindow()) {
                window = Schedule.getTasks().get(i).getWindow();
            }
            else {
                flag = false;
            }
        }
        assertTrue("Tasks were not sorted in order of maxWindow (ascending order)", flag);
    }

    @Test
    public void testOneHourBeforeMidnightPush() {
        boolean flag = false;
        Schedule schedule = new Schedule();
        Task task1 = new Task(1, "Test1", 40,2);
        Task task2 = new Task(2, "Test2", 30, 2);
        Schedule.getTasks().add(task1);
        Schedule.getTasks().add(task2);
        Animal animal1 = new Animal(1, "Spike", "Fox");
        Schedule.getAnimals().add(animal1);
        Treatment treatment1 = new Treatment(1, 1, 23);
        Treatment treatment2 = new Treatment(1, 2, 23);
        Schedule.getTreatments().add(treatment1);
        Schedule.getTreatments().add(treatment2);
        Schedule.fillSchedule();
        try {
            schedule.fixSchedule();
        } catch (IllegalScheduleException e){
            flag = true;
        }
        assertTrue("Exception was not thrown", flag);
    }

    @Test
    public void testPushTaskToWindowEnd() throws IllegalScheduleException {
        Schedule schedule = new Schedule();
        Task task1 = new Task(1, "Test1", 60,1);
        Task task2 = new Task(2, "Test2", 30, 4);
        Schedule.getTasks().add(task1);
        Schedule.getTasks().add(task2);
        Animal animal1 = new Animal(1, "Spike", "Fox");
        Animal animal2 = new Animal(2, "Jack", "Fox");
        Animal animal3 = new Animal(1, "Henry", "Fox");
        Schedule.getAnimals().add(animal1);
        Schedule.getAnimals().add(animal2);
        Schedule.getAnimals().add(animal3);
        Treatment treatment1 = new Treatment(1, 1, 10);
        Treatment treatment2 = new Treatment(2, 1, 11);
        Treatment treatment3 = new Treatment(3, 1, 12);
        Treatment treatment4 = new Treatment(3, 2, 10);
        Schedule.getTreatments().add(treatment1);
        Schedule.getTreatments().add(treatment2);
        Schedule.getTreatments().add(treatment3);
        Schedule.getTreatments().add(treatment4);
        schedule.fillSchedule();
        schedule.fixSchedule();
        assertEquals(Schedule.getSchedule().get(13).get(0), treatment4);
    }

    @Test
    public void testPushTaskBehindPriorityTasks()  throws IllegalScheduleException {
        Schedule schedule = new Schedule();
        Task task1 = new Task(1, "Test1", 60,1);
        Task task2 = new Task(2, "Test2", 20, 4);
        Schedule.getTasks().add(task1);
        Schedule.getTasks().add(task2);
        Animal animal1 = new Animal(1, "Spike", "Fox");
        Animal animal2 = new Animal(2, "Jack", "Fox");
        Animal animal3 = new Animal(1, "Henry", "Fox");
        Schedule.getAnimals().add(animal1);
        Schedule.getAnimals().add(animal2);
        Schedule.getAnimals().add(animal3);
        Treatment treatment1 = new Treatment(1, 1, 10);
        Treatment treatment2 = new Treatment(2, 1, 11);
        Treatment treatment3 = new Treatment(3, 2, 12);
        Treatment treatment4 = new Treatment(2, 2, 12);
        Treatment treatment5 = new Treatment(1, 2, 10);
        Schedule.getTreatments().add(treatment1);
        Schedule.getTreatments().add(treatment2);
        Schedule.getTreatments().add(treatment3);
        Schedule.getTreatments().add(treatment4);
        Schedule.getTreatments().add(treatment5);
        schedule.fillSchedule();
        schedule.fixSchedule();
        assertEquals(Schedule.getSchedule().get(13).get(2), treatment5);
    }
}














































        java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import edu.ucalgary.oop.Schedule;
import edu.ucalgary.oop.Treatment;

import static org.junit.Assert.*;

public class Test {

    @Test
    public void testIllegalScheduleException() {
        Schedule schedule = new Schedule();
        boolean flag = false;
        for (int i = 0; i < 20; i++) {
            Task task = new Task(i+1, "Test" + i, 130, 1);
            Animal animal = new Animal(i+1, "Test" + i,"Test" + i);
            Treatment treatment = new Treatment(i+1, i+1, i);
            Schedule.getTasks().add(task);
            Schedule.getAnimals().add(animal);
            Schedule.getTreatments().add(treatment);
            schedule.fillSchedule();
        }
        try {
            schedule.fixSchedule();
        } catch (IllegalScheduleException e) {
            flag = true;
        }

        assertTrue("Exception was not thrown",flag);
    }

    @Test
    public void testBackupVolunteer() {
        Schedule schedule = new Schedule();
        Task task1 = new Task(1, "Test1", 40, 1);
        Schedule.getTasks().add(task1);
        Animal animal1 = new Animal(1, "Spike", "Fox");
        Animal animal2 = new Animal(2, "Joe", "Fox");
        Schedule.getAnimals().add(animal1);
        Schedule.getAnimals().add(animal2);
        Treatment treatment1 = new Treatment(1, 1, 1);
        Treatment treatment2 = new Treatment(2, 1, 1);
        Schedule.getTreatments().add(treatment1);
        Schedule.getTreatments().add(treatment2);
        schedule.fillSchedule();
        schedule.fixSchedule();
        assertEquals(Schedule.getSchedule().get(0).get(1).getBackupVolunteer(), true);
    }

    @Test
    public void testSortedTasks() {
        Schedule schedule = new Schedule();
        int totalTasks = schedule.storeSortedMedicalTasks();
        int window = 0;
        boolean flag = true;
        for (int i = 0; i < Schedule.getTasks().size(); i++) {
            if (window < Schedule.getTasks().get(i).getWindow()) {
                window = Schedule.getTasks().get(i).getWindow();
            }
            else {
                flag = false;
            }
        }
        assertTrue("Tasks were not sorted in order of maxWindow (ascending order)", flag);
    }

    @Test
    public void testOneHourBeforeMidnightPush() {
        boolean flag;
        Schedule schedule = new Schedule();
        Task task1 = new Task(1, "Test1", 40,2);
        Task task2 = new Task(2, "Test2", 30, 2);
        Schedule.getTasks().add(task1);
        Schedule.getTasks().add(task2);
        Animal animal1 = new Animal(1, "Spike", "Fox");
        Schedule.getAnimals().add(animal1);
        Treatment treatment1 = new Treatment(1, 1, 23);
        Treatment treatment2 = new Treatment(1, 2, 23);
        Schedule.getTreatments().add(treatment1);
        Schedule.getTreatments().add(treatment2);
        schedule.fillSchedule();
        try {
            schedule.fixSchedule();
        } catch (IllegalScheduleException e){
            flag = true;
        }
        assertTrue("Exception was not thrown", flag);
    }

    @Test
    public void testPushTaskToWindowEnd() {
        Schedule schedule = new Schedule();
        Task task1 = new Task(1, "Test1", 60,1);
        Task task2 = new Task(2, "Test2", 30, 4);
        Schedule.getTasks().add(task1);
        Schedule.getTasks().add(task2);
        Animal animal1 = new Animal(1, "Spike", "Fox");
        Animal animal2 = new Animal(2, "Jack", "Fox");
        Animal animal3 = new Animal(1, "Henry", "Fox");
        Schedule.getAnimals().add(animal1);
        Schedule.getAnimals().add(animal2);
        Schedule.getAnimals().add(animal3);
        Treatment treatment1 = new Treatment(1, 1, 10);
        Treatment treatment2 = new Treatment(2, 1, 11);
        Treatment treatment3 = new Treatment(3, 1, 12);
        Treatment treatment4 = new Treatment(3, 2, 10);
        Schedule.getTreatments().add(treatment1);
        Schedule.getTreatments().add(treatment2);
        Schedule.getTreatments().add(treatment3);
        Schedule.getTreatments().add(treatment4);
        schedule.fillSchedule();
        schedule.fixSchedule();
        assertEquals(Schedule.getSchedule().get(13).get(0), treatment4);
    }

    @Test
    public void testPushTaskBehindPriorityTasks() {
        Schedule schedule = new Schedule();
        Task task1 = new Task(1, "Test1", 60,1);
        Task task2 = new Task(2, "Test2", 20, 4);
        Schedule.getTasks().add(task1);
        Schedule.getTasks().add(task2);
        Animal animal1 = new Animal(1, "Spike", "Fox");
        Animal animal2 = new Animal(2, "Jack", "Fox");
        Animal animal3 = new Animal(1, "Henry", "Fox");
        Schedule.getAnimals().add(animal1);
        Schedule.getAnimals().add(animal2);
        Schedule.getAnimals().add(animal3);
        Treatment treatment1 = new Treatment(1, 1, 10);
        Treatment treatment2 = new Treatment(2, 1, 11);
        Treatment treatment3 = new Treatment(3, 2, 12);
        Treatment treatment4 = new Treatment(2, 2, 12);
        Treatment treatment5 = new Treatment(1, 2, 10);
        Schedule.getTreatments().add(treatment1);
        Schedule.getTreatments().add(treatment2);
        Schedule.getTreatments().add(treatment3);
        Schedule.getTreatments().add(treatment4);
        Schedule.getTreatments().add(treatment5);
        schedule.fillSchedule();
        schedule.fixSchedule();
        assertEquals(Schedule.getSchedule().get(13).get(2), treatment5);
    }
}
