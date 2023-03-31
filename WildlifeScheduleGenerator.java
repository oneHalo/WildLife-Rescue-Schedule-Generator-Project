import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class WildlifeScheduleGenerator extends  JFrame implements  ActionListener, MouseListener {

    private String animaltype;
    private String orphantype;
    private int numberofanimals;
    private String[] validAnimalTypes = {"fox", "raccoon", "coyote", "porcupine", "beaver"};
    
    private JLabel instructions;
    private JLabel animalLabel;
    
    private JLabel orphanLabel;
    private JLabel numberLabel;
    
    private JTextField animalInput;
    private JTextField orphanInput;
    private JTextField numberInput;


       public WildlifeScheduleGenerator(){
        super("Wildlife  Schedule Generator");
        setSize(500,300);
        setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            
        
    }
    public void setupGUI(){
        instructions = new JLabel("Please enter your information to generate a schedule.");
        animalLabel = new JLabel("Type of animal:");
        orphanLabel = new JLabel("                             Is it a orphan:");
        numberLabel= new JLabel("             number of animals:");

        animalInput= new JTextField("e.g. Fox", 15);
        orphanInput= new JTextField("e.g. yes or no", 15);
        numberInput= new JTextField("e.g. 5, 10", 15);

           
        
        animalInput.addMouseListener(this);
        orphanInput.addMouseListener(this);
        numberInput.addMouseListener(this);

        JButton submitInfo = new JButton("Submit");
        submitInfo.addActionListener(this);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
        
        headerPanel.add(instructions);
        clientPanel.add(animalLabel);
        clientPanel.add(animalInput);
        clientPanel.add(orphanLabel);
        clientPanel.add(orphanInput);
        clientPanel.add(numberLabel);
        clientPanel.add(numberInput);
        submitPanel.add(submitInfo);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);


    }




    public void actionPerformed(ActionEvent event){
        animaltype = animalInput.getText();
        orphantype = orphanInput.getText();
        numberofanimals = Integer.parseInt(numberInput.getText());
        
        if(validateInput()){
            JOptionPane.showMessageDialog(this, "Your schedule of the day is " );
            String[] columnNames = {"Time", "Task", "Qty", "Time Available", "Time Spent"};
            Object[][] data = new Object[5][5];

            JTable table = new JTable(data, columnNames);
            table.setFillsViewportHeight(true);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            //table.setPreferredScrollableViewportSize(new Dimension(650, 400));

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