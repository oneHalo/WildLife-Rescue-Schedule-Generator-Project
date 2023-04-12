import














































        java.util.ArrayList;

//import org.junit.Assert;
//import org.junit.Test;
//
//import edu.ucalgary.oop.Schedule;
//import edu.ucalgary.oop.Treatment;
//
//import static org.junit.Assert.*;
//
//public class Test {
//
//    @Test
//    public void testIllegalScheduleException() {
//        Schedule schedule = new Schedule();
//        boolean flag = false;
//        for (int i = 0; i < 20; i++) {
//            Task task = new Task(i+1, "Test" + i, 130, 1);
//            Animal animal = new Animal(i+1, "Test" + i,"Test" + i);
//            Treatment treatment = new Treatment(i+1, i+1, i);
//            Schedule.getTasks().add(task);
//            Schedule.getAnimals().add(animal);
//            Schedule.getTreatments().add(treatment);
//            schedule.fillSchedule();
//        }
//        try {
//            schedule.fixSchedule();
//        } catch (IllegalScheduleException e) {
//            flag = true;
//        }
//
//        assertTrue("Exception was not thrown",flag);
//    }
//
//    @Test
//    public void testBackupVolunteer() {
//        Schedule schedule = new Schedule();
//        Task task1 = new Task(1, "Test1", 40, 1);
//        Schedule.getTasks().add(task1);
//        Animal animal1 = new Animal(1, "Spike", "Fox");
//        Animal animal2 = new Animal(2, "Joe", "Fox");
//        Schedule.getAnimals().add(animal1);
//        Schedule.getAnimals().add(animal2);
//        Treatment treatment1 = new Treatment(1, 1, 1);
//        Treatment treatment2 = new Treatment(2, 1, 1);
//        Schedule.getTreatments().add(treatment1);
//        Schedule.getTreatments().add(treatment2);
//        schedule.fillSchedule();
//        schedule.fixSchedule();
//        assertEquals(Schedule.getSchedule().get(0).get(1).getBackupVolunteer(), true);
//    }
//
//    @Test
//    public void testSortedTasks() {
//        Schedule schedule = new Schedule();
//        int totalTasks = schedule.storeSortedMedicalTasks();
//        int window = 0;
//        boolean flag = true;
//        for (int i = 0; i < Schedule.getTasks().size(); i++) {
//            if (window < Schedule.getTasks().get(i).getWindow()) {
//                window = Schedule.getTasks().get(i).getWindow();
//            }
//            else {
//                flag = false;
//            }
//        }
//        assertTrue("Tasks were not sorted in order of maxWindow (ascending order)", flag);
//    }
//
//    @Test
//    public void testOneHourBeforeMidnightPush() {
//        boolean flag;
//        Schedule schedule = new Schedule();
//        Task task1 = new Task(1, "Test1", 40,2);
//        Task task2 = new Task(2, "Test2", 30, 2);
//        Schedule.getTasks().add(task1);
//        Schedule.getTasks().add(task2);
//        Animal animal1 = new Animal(1, "Spike", "Fox");
//        Schedule.getAnimals().add(animal1);
//        Treatment treatment1 = new Treatment(1, 1, 23);
//        Treatment treatment2 = new Treatment(1, 2, 23);
//        Schedule.getTreatments().add(treatment1);
//        Schedule.getTreatments().add(treatment2);
//        schedule.fillSchedule();
//        try {
//            schedule.fixSchedule();
//        } catch (IllegalScheduleException e){
//            flag = true;
//        }
//        assertTrue("Exception was not thrown", flag);
//    }
//
//    @Test
//    public void testPushTaskToWindowEnd() {
//        Schedule schedule = new Schedule();
//        Task task1 = new Task(1, "Test1", 60,1);
//        Task task2 = new Task(2, "Test2", 30, 4);
//        Schedule.getTasks().add(task1);
//        Schedule.getTasks().add(task2);
//        Animal animal1 = new Animal(1, "Spike", "Fox");
//        Animal animal2 = new Animal(2, "Jack", "Fox");
//        Animal animal3 = new Animal(1, "Henry", "Fox");
//        Schedule.getAnimals().add(animal1);
//        Schedule.getAnimals().add(animal2);
//        Schedule.getAnimals().add(animal3);
//        Treatment treatment1 = new Treatment(1, 1, 10);
//        Treatment treatment2 = new Treatment(2, 1, 11);
//        Treatment treatment3 = new Treatment(3, 1, 12);
//        Treatment treatment4 = new Treatment(3, 2, 10);
//        Schedule.getTreatments().add(treatment1);
//        Schedule.getTreatments().add(treatment2);
//        Schedule.getTreatments().add(treatment3);
//        Schedule.getTreatments().add(treatment4);
//        schedule.fillSchedule();
//        schedule.fixSchedule();
//        assertEquals(Schedule.getSchedule().get(13).get(0), treatment4);
//    }
//
//    @Test
//    public void testPushTaskBehindPriorityTasks() {
//        Schedule schedule = new Schedule();
//        Task task1 = new Task(1, "Test1", 60,1);
//        Task task2 = new Task(2, "Test2", 20, 4);
//        Schedule.getTasks().add(task1);
//        Schedule.getTasks().add(task2);
//        Animal animal1 = new Animal(1, "Spike", "Fox");
//        Animal animal2 = new Animal(2, "Jack", "Fox");
//        Animal animal3 = new Animal(1, "Henry", "Fox");
//        Schedule.getAnimals().add(animal1);
//        Schedule.getAnimals().add(animal2);
//        Schedule.getAnimals().add(animal3);
//        Treatment treatment1 = new Treatment(1, 1, 10);
//        Treatment treatment2 = new Treatment(2, 1, 11);
//        Treatment treatment3 = new Treatment(3, 2, 12);
//        Treatment treatment4 = new Treatment(2, 2, 12);
//        Treatment treatment5 = new Treatment(1, 2, 10);
//        Schedule.getTreatments().add(treatment1);
//        Schedule.getTreatments().add(treatment2);
//        Schedule.getTreatments().add(treatment3);
//        Schedule.getTreatments().add(treatment4);
//        Schedule.getTreatments().add(treatment5);
//        schedule.fillSchedule();
//        schedule.fixSchedule();
//        assertEquals(Schedule.getSchedule().get(13).get(2), treatment5);
//    }
//}
