import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
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
    
    private int task=0;
    private JComboBox<String> animalDropdown;
    
    private JLabel instructions;
    private JLabel animalLabel;
    private JLabel orphanLabel;
    private JLabel numberLabel;
    private JLabel medicaltaskLabel;
    private JLabel medicalLable;
    private JLabel animalnameLabel;

    
    private JRadioButton yesButton;
    private JRadioButton noButton;
    private JRadioButton YesmedicalButton;
    private JRadioButton NomedicalButton;


    private JTextField animalInput;
    private JTextField animalnameInput;
    private JTextField orphanInput;
    private JTextField numberInput;
    private JTextField medicalInput;

    private JPanel clientPanel = new JPanel();
    JPanel medicaltaskJPanel = new JPanel();
    


       public WildlifeScheduleGenerator(){
        super("Wildlife  Schedule Generator");
        setSize(500,300);
        setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            
        
    }
    public void setupGUI() {
        instructions = new JLabel("Please enter your information to generate a schedule.");
        animalLabel = new JLabel("Type of animal:");
        animalnameLabel = new JLabel("Animal name");
        orphanLabel = new JLabel("Is it a rescue :");
        medicaltaskLabel= new JLabel("Does the animal need Medical tasks");


        numberLabel = new JLabel("Number of animals:");
        numberLabel.setVisible(false);
        numberInput = new JTextField("e.g. 5, 10", 15);
        numberInput.setVisible(false);

        medicalLable = new JLabel("Insert the medical Tasks");
        medicalLable.setVisible(false);
        medicalInput= new JTextField("",15);
        medicalInput.setVisible(false);
        
        
        animalnameInput = new JTextField("e.g. Toto", 15);

        animalDropdown = new JComboBox<>(validAnimalTypes);

        yesButton = new JRadioButton("Yes");
        noButton = new JRadioButton("No");
        ButtonGroup group = new ButtonGroup();
        group.add(yesButton);
        group.add(noButton);


        YesmedicalButton= new JRadioButton("Yes");
        NomedicalButton = new JRadioButton("No");
        ButtonGroup groupM = new ButtonGroup();
        groupM.add(YesmedicalButton);
        groupM.add(NomedicalButton);
        JButton addButton = new JButton("Add");
        addButton.setVisible(false);

        numberInput.addMouseListener(this);
        animalnameInput.addMouseListener(this);

        clientPanel.setLayout(new BoxLayout(clientPanel, BoxLayout.PAGE_AXIS));

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberLabel.setVisible(true);
                numberInput.setVisible(true);
            }
        });
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberLabel.setVisible(false);
                numberInput.setVisible(false);
            }
        });

        YesmedicalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                medicalLable.setVisible(true);
                medicalInput.setVisible(true);
                addButton.setVisible(true);
            }
            

        });

        NomedicalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                medicalLable.setVisible(false);
                medicalInput.setVisible(false);
                addButton.setVisible(false);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                task++;
                JTextField textField= new JTextField("",15);
                medicaltaskJPanel.add(textField);
                textField.requestFocusInWindow();
                medicaltaskJPanel.revalidate();
                medicaltaskJPanel.repaint();

            }
        });

        JButton submitInfo = new JButton("Submit");
        submitInfo.addActionListener(this);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());

        //JPanel clientPanel = new JPanel();
        //clientPanel.setLayout(new BoxLayout(clientPanel, BoxLayout.PAGE_AXIS));


        JPanel animalnamePanel = new JPanel();
        animalnamePanel.setLayout(new FlowLayout());
        animalnamePanel.add(animalnameLabel);
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

        JPanel medicalPanel= new JPanel();
        medicalPanel.setLayout(new FlowLayout());
        medicalPanel.add(medicaltaskLabel);
        medicalPanel.add(YesmedicalButton);
        medicalPanel.add(NomedicalButton);
        clientPanel.add(medicalPanel);

        //JPanel medicaltaskJPanel = new JPanel();
        medicaltaskJPanel.add(medicalLable);
        medicaltaskJPanel.add(medicalInput);
        medicaltaskJPanel.add(addButton);
        clientPanel.add(medicaltaskJPanel);


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
        // if (YesmedicalButton.isSelected()) {
        //     medicalLable.setVisible(true);
        //     JTextArea medicalInput = new JTextArea(5, 20);
        //     JScrollPane medicalScroll = new JScrollPane(medicalInput);
        //     JPanel medicalTaskPanel = new JPanel(new BorderLayout());
        //     medicalTaskPanel.add(medicalScroll, BorderLayout.CENTER);
        //     medicalTaskPanel.add(new JLabel("Medical Tasks:"), BorderLayout.NORTH);
        //     JOptionPane.showMessageDialog(this, medicalTaskPanel, "Medical Tasks", JOptionPane.PLAIN_MESSAGE);
        // }
    
        // if(NomedicalButton.isSelected()){
        //     medicalLable.setVisible(false);
        // }


        // if (validateInput()) {
        //     JOptionPane.showMessageDialog(this, "Your schedule of the day is ");
        //     String[] columnNames = {"Time", "Task", "Qty", "Time Available", "Time Spent"};
        //     Object[][] data = new Object[5][5];

        //     JTable table = new JTable(data, columnNames);
        //     table.setFillsViewportHeight(true);
        //     JScrollPane scrollPane = new JScrollPane(table);
        //     scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //     JOptionPane.showMessageDialog(this, scrollPane);
        // }
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
        
        if(!Character.isUpperCase(name.charAt(0)) || name.length() < 2 || name.length() > 26){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, name + " is an invalid name input.");
        }
     
        
        return allInputValid;
        
    }

    
    
  

     public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            new WildlifeScheduleGenerator().setVisible(true);        
        });
    }


}
