package edu.ucalgary.oop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.FlowLayout;
import java.awt.Panel;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Component;


public class WildlifeScheduleGenerator extends JFrame {
    JFrame WildLifeMain;
    public WildlifeScheduleGenerator() {
        WildLifeMain = new JFrame();
        WildLifeMain.setTitle("Schedule Viewer");
        WildLifeMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WildLifeMain.setSize(900, 400);
        WildLifeMain.setLocationRelativeTo(null);

        // Create a panel for the button
        JPanel panel = new JPanel();
        JButton viewScheduleButton = new JButton("View Schedule");
        viewScheduleButton.addActionListener(new ScheduleButton());
        panel.add(viewScheduleButton);

        // Add the panel to the bottom of the frame
        WildLifeMain.add(panel, BorderLayout.SOUTH);

        JPanel welcomePanel = new JPanel();
        ImageIcon i = new ImageIcon("WildLifeRescue.png");

        JLabel welcomeText = new JLabel("Welcome to WildLife Rescue Centre",i, SwingConstants.HORIZONTAL);
        welcomeText.setBounds(50, 50 , 50 , 50);
        welcomePanel.add(welcomeText);
        WildLifeMain.add(welcomePanel, BorderLayout.NORTH);

        WildLifeMain.setVisible(true);
    }
    public class ScheduleButton implements ActionListener{
        JFrame forTable;
        JTable table;
        JScrollPane scrollPane;
        DefaultTableModel tableModel;
        @Override
        public void actionPerformed(ActionEvent e) {
            WildLifeMain.setVisible(false);
            forTable = new JFrame("Task and Schedule Table");
            forTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            forTable.setSize(900, 700);
            forTable.setLocationRelativeTo(null);
            addToTable();
//            tableModel = new DefaultTableModel(new Object[]{"Hours", "Tasks", "Time Spent", "Time Available"}, 24);
//
//            for (int i = 0; i < 24; i++) {
//                tableModel.setValueAt(i, i, 0);
//                tableModel.setValueAt("", i, 3);
//            }
//
//            table = new JTable(tableModel);
//            addToTable(table);
//            table.setRowHeight(230);

//            scrollPane = new JScrollPane(table);
//            forTable.add(scrollPane, BorderLayout.CENTER);

            forTable.setVisible(true);
        }
        public void addToTable(){
           var schedule = Schedule.getSchedule();
           var tasks = Schedule.getTasks();
           var animals = Schedule.getAnimals();
            DefaultTableCellRenderer centre = new DefaultTableCellRenderer();
            centre.setHorizontalAlignment(10);
//           for(int i = 0; i< schedule.size(); i++){
//               StringBuilder task = new StringBuilder();
//               for(int j = 0; j<schedule.get(i).size(); j++){
//                   task.append(tasks.get(schedule.get(i).get(j).getTaskID()-1).getDescription()+ "\n ");
//                  task.append(animals.get(schedule.get(i).get(j).getAnimalID()-1).getName()+ "\n ");
//
//                }
//               JPanel temp = new JPanel();
//               JLabel tempLabel = new JLabel(task.toString());
//               temp.add(tempLabel);
//               table.add(temp);
//
//            }
            try {
                FileWriter myWriter = new FileWriter("schedule.txt");
                JTextArea textArea = new JTextArea();
                textArea.setEditable(false);
                JScrollPane scrollPane1 = new JScrollPane(textArea);
                this.forTable.add(scrollPane1);

//                DefaultTableCellRenderer centre = new DefaultTableCellRenderer();
//                centre.setHorizontalAlignment(10);
                for (int i = 0; i < schedule.size(); i++) {
                    StringBuilder task = new StringBuilder();
                    task.append("Time: " + i + ":00");

                    if (backUpVolunteerChecker(schedule.get(i))) {
                        task.append(" [+ backup volunteer]\n");
                    } else {
                        task.append("\n");
                    }
                    for (int j = 0; j < schedule.get(i).size(); j++) {
                        task.append(tasks.get(schedule.get(i).get(j).getTaskID() - 1).getDescription() + " ");
                        task.append(animals.get(schedule.get(i).get(j).getAnimalID() - 1).getName() + "\n");

                    }
                    task.append("\n");
                    //JTextArea textArea = new JTextArea();
                    //textArea.setEditable(false);
                    textArea.append(task.toString() + "\n");
                    //JScrollPane scrollPane1 = new JScrollPane(textArea);
                    myWriter.write(task.toString());
                    //this.forTable.add(scrollPane1);
                }myWriter.close();//this.forTable.add(this.table);

            }catch (IOException e){
                System.out.println("Something Went Wrong");
                e.printStackTrace();
            }
        }
        public boolean backUpVolunteerChecker(ArrayList<Treatment> check){
            for(int i = 0; i<check.size(); i++){
                if(check.get(i).getBackupVolunteer()){
                    return true;
                }
            }
            return false;
        }
    }



    public static void main(String[] args) throws IllegalScheduleException{
        Schedule myJDBC = new Schedule();
        myJDBC.createConnection();
        myJDBC.storeAnimals();
        myJDBC.storeTasks();
        int totalTasks = myJDBC.storeSortedMedicalTasks();
        myJDBC.storeTreatments();
        myJDBC.storeGeneralTasks(totalTasks+1);
        myJDBC.fillSchedule();
        myJDBC.fixSchedule();

        var array = myJDBC.fixSchedule();
        if(array[0] > -1){
            var schedule = Schedule.getSchedule();
            var treatment = schedule.get(array[0]).get(array[1]);

            JOptionPane.showMessageDialog(null, "The schedule is conflicting.\n The following treatment has been deleted from the database. Please provide a new starting hour for this treatment in the database OR Proceed without it:\n " + Schedule.getTasks().get(treatment.getTaskID()-1).getDescription() + " - " + Schedule.getAnimals().get(treatment.getAnimalID()-1).getName()
                    +"\nThe detailed information is: " + "\n AnimalID: " + treatment.getAnimalID() + "\n TaskID: " + treatment.getTaskID() +
                    "\n StartHour: " + treatment.getStartHour());
            myJDBC.deleteTreatment(treatment.getAnimalID(), treatment.getTaskID(), treatment.getStartHour());
            System.exit(1);
        }
        new WildlifeScheduleGenerator();
    }

}
