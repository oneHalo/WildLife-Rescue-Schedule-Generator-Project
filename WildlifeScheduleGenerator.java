import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.Panel;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Component;


public class WildlifeScheduleGenerator extends  JFrame implements  ActionListener, MouseListener {

    private String animaltype;
    private String orphantype;
    private int numberofanimals;
    private String name;
    private String[] validAnimalTypes = {"fox", "raccoon", "coyote", "porcupine", "beaver"};
    
    private JComboBox<String> animalDropdown;
    
    private JLabel instructions;
    private JLabel animalLabel;
    private JLabel orphanLabel;
    private JLabel numberLabel;
    private JLabel animalnamLabel;

    private JRadioButton yesButton;
    private JRadioButton noButton;
    
    private JTextField animalInput;
    private JTextField animalnameInput;
    private JTextField orphanInput;
    private JTextField numberInput;


       public WildlifeScheduleGenerator(){
        super("Wildlife  Schedule Generator");
        setSize(500,300);
        setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            
        
    }
    public void setupGUI() {
        instructions = new JLabel("Please enter your information to generate a schedule.");
        animalLabel = new JLabel("Type of animal:");
        animalnamLabel= new JLabel("Animal name");
        orphanLabel = new JLabel("Is it a rescue :");
        numberLabel = new JLabel("Number of animals:");

        numberInput = new JTextField("e.g. 5, 10", 15);
        animalnameInput= new JTextField("e.g. Toto", 15);

        animalDropdown = new JComboBox<>(validAnimalTypes);

        yesButton = new JRadioButton("Yes");
        noButton = new JRadioButton("No");
        ButtonGroup group = new ButtonGroup();
        group.add(yesButton);
        group.add(noButton);

        numberInput.addMouseListener(this);
        animalnameInput.addMouseListener(this);

        JButton submitInfo = new JButton("Submit");
        submitInfo.addActionListener(this);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());

        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new BoxLayout(clientPanel, BoxLayout.PAGE_AXIS));

        
        JPanel animalnamePanel = new JPanel();
        animalnamePanel.setLayout(new FlowLayout());
        animalnamePanel.add(animalnamLabel);
        animalnamePanel.add(animalnameInput);
        clientPanel.add(animalnamePanel);



        JPanel animalPanel = new JPanel();
        animalPanel.setLayout(new FlowLayout());
        animalPanel.add(animalLabel);
        animalPanel.add(animalDropdown);
        clientPanel.add(animalPanel);
    

        JPanel orphanPanel = new JPanel();
        orphanPanel.setLayout(new FlowLayout());
        orphanPanel.add(orphanLabel);
        orphanPanel.add(yesButton);
        orphanPanel.add(noButton);
        clientPanel.add(orphanPanel);

        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(new FlowLayout());
        numberPanel.add(numberLabel);
        numberPanel.add(numberInput);
        clientPanel.add(numberPanel);

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
        submitPanel.add(submitInfo);

        headerPanel.add(instructions);
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
    }

    public void actionPerformed(ActionEvent event) {
        animaltype = (String) animalDropdown.getSelectedItem();
        numberofanimals = Integer.parseInt(numberInput.getText());
        name= animalInput.getText();

        if (yesButton.isSelected()) {
            orphantype = "Yes";
        } else if (noButton.isSelected()) {
            orphantype = "No";
        }

        if (validateInput()) {
            JOptionPane.showMessageDialog(this, "Your schedule of the day is ");
            String[] columnNames = {"Time", "Task", "Qty", "Time Available", "Time Spent"};
            Object[][] data = new Object[5][5];

            JTable table = new JTable(data, columnNames);
            table.setFillsViewportHeight(true);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            JOptionPane.showMessageDialog(this, scrollPane);
        }
    }
    
    
    public void mouseClicked(MouseEvent event){
        
        if(event.getSource().equals(animalInput))
            animalInput.setText("");


        if(event.getSource().equals(orphanInput))
            orphanInput.setText("");

        if(event.getSource().equals(numberInput))
            numberInput.setText("");

        if (event.getSource().equals(animalnameInput))
            animalnameInput.setText("");
          
                
    }
    
    public void mouseEntered(MouseEvent event){
        
    }

    public void mouseExited(MouseEvent event){
        
    }

    public void mousePressed(MouseEvent event){
        
    }

    public void mouseReleased(MouseEvent event){
        
    }
    private boolean validateInput(){
        
        boolean allInputValid = true;
        
        if(!animaltype.equalsIgnoreCase("fox")&&!animaltype.equalsIgnoreCase("raccoon")
        &&!animaltype.equalsIgnoreCase("coyote")&&!animaltype.equalsIgnoreCase("porcupine")
        &&!animaltype.equalsIgnoreCase("beaver")){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, animaltype + " is an invalid name input.");
        }
        if (!orphantype.equalsIgnoreCase("yes")&&!orphantype.equalsIgnoreCase("no")){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, orphantype + " is an invalid insert yes or no.");
        }
        
      
        
        return allInputValid;
        
    }
  

     public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            new WildlifeScheduleGenerator().setVisible(true);        
        });
    }


}
