import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout; 
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class CakeOrder2 extends JFrame implements ActionListener{
 private JPanel mainNorthPanel,mainCenterPanel,mainSouthPanel,subSouthPanel1,subSouthPanel2,subSouthPanel3,subNorthPanel1,subNorthPanel2,subNorthPanel3,subCenterPanel0,subCenterPanel1,subCenterPanel2,subCenterPanel3,subCenterPanel4,subCenterPanel5,subCenterPanel6;
 private JTextField firstNameTextField,lastNameTextField,cardNumberTextField,cardDateTextField;
 private JLabel memberLabel, toppingLabel,timeLabel,flavorLabel,chocolateLabel,vanillaLabel,creamLabel,lemonLabel,cakeCreateLabel,specialLabel,cardNumberLabel,dateLabel,visaLabel,discoverLabel,masterLabel,americanExpressLabel,cakeLabel,firstLabel,lastLabel,createLabel;
 private JCheckBox memberBox;
 private JButton orderButton,clearButton;
 private ImageIcon flavorIcon,chocolateIcon,vanillaIcon,creamIcon,lemonIcon,visaIcon,masterIcon,discoverIcon,expressIcon,cakeIcon,createIcon;
 private JComboBox toppingBox,pickupBox;
 private JRadioButton masterCard,visaCard, discoverCard,americanExpressCard,chocolateButton,vanillaButton,creamButton,lemonButton;
 private ButtonGroup cardGroup,flavorGroup;
 private JTextArea specialArea;
 
  public CakeOrder2(){
    super("Cake Express");
    
    //NorthPanel
    subNorthPanel1 = new JPanel();
    cakeIcon = new ImageIcon("cake.png");
    cakeLabel = new JLabel(cakeIcon);
    subNorthPanel1.add(cakeLabel);

    subNorthPanel2 = new JPanel();
    firstNameTextField = new JTextField(7);
    lastNameTextField = new JTextField(7);
    firstLabel = new JLabel("First Name: ");
    lastLabel = new JLabel("Last Name: ");
    subNorthPanel2.add(firstLabel); 
    subNorthPanel2.add(firstNameTextField);
    subNorthPanel2.add(lastLabel);
    subNorthPanel2.add(lastNameTextField);
      
    subNorthPanel3 = new JPanel();
    memberLabel = new JLabel("Existing Membership: ");
    memberBox = new JCheckBox();
    subNorthPanel3.add(memberLabel);
    subNorthPanel3.add(memberBox);
   
    mainNorthPanel = new JPanel();
    mainNorthPanel.setLayout(new BorderLayout());
    mainNorthPanel.add(subNorthPanel1,BorderLayout.NORTH);
    mainNorthPanel.add(subNorthPanel2,BorderLayout.CENTER);
    mainNorthPanel.add(subNorthPanel3,BorderLayout.SOUTH);
    add(mainNorthPanel,BorderLayout.NORTH);
    
    //CenterPanel
    subCenterPanel0 = new JPanel();
    createIcon = new ImageIcon("create.png");
    createLabel = new JLabel(createIcon);
    subCenterPanel0.add(createLabel);
    
    subCenterPanel1 = new JPanel();
    flavorIcon = new ImageIcon("flavor.png");
    flavorLabel = new JLabel(flavorIcon);
    subCenterPanel1.add(flavorLabel);
       
    subCenterPanel2 = new JPanel();
    chocolateIcon = new ImageIcon("chocolate.png");
    vanillaIcon = new ImageIcon("vanilla.png");
    creamIcon = new ImageIcon("cream.png");
    lemonIcon = new ImageIcon("lemon.png");
    chocolateLabel = new JLabel(chocolateIcon);
    vanillaLabel = new JLabel(vanillaIcon);
    creamLabel = new JLabel(creamIcon);
    lemonLabel = new JLabel(lemonIcon);
    chocolateButton = new JRadioButton();
    vanillaButton = new JRadioButton();
    creamButton = new JRadioButton();
    lemonButton = new JRadioButton();
    flavorGroup = new ButtonGroup();
    flavorGroup.add(chocolateButton);
    flavorGroup.add(vanillaButton);
    flavorGroup.add(creamButton);
    flavorGroup.add(lemonButton);
    subCenterPanel2.add(vanillaLabel);
    subCenterPanel2.add(vanillaButton);
    subCenterPanel2.add(chocolateLabel);
    subCenterPanel2.add(chocolateButton);
    subCenterPanel2.add(creamLabel);
    subCenterPanel2.add(creamButton);
    subCenterPanel2.add(lemonLabel);
    subCenterPanel2.add(lemonButton);
    
    subCenterPanel3 = new JPanel();
    subCenterPanel3.setLayout(new BorderLayout());
    specialArea = new JTextArea(9,10);
    specialLabel = new JLabel("Cake Customizations (Optional): ");
    subCenterPanel3.add(specialLabel,BorderLayout.NORTH); 
    subCenterPanel3.add(specialArea,BorderLayout.CENTER);
    subCenterPanel4 = new JPanel();
    subCenterPanel4.add(subCenterPanel3);
    
    subCenterPanel5 = new JPanel();
    String topping [] = {"","Chocolate-Curls","Fruit-Mix","Fondant","Chopped-Nuts"};
    toppingBox = new JComboBox(topping);
    String pickup [] = {"","Monday 12PM-4PM","Tuesday 12PM-4PM","Wednesday 12PM-4PM", "Thursday 12PM-4PM","Friday 12PM-4PM"};
    pickupBox = new JComboBox(pickup);
    toppingLabel = new JLabel("Topping: ");
    timeLabel = new JLabel("Pick-Up Time");
    
    subCenterPanel5.add(toppingLabel,BorderLayout.NORTH); 
    subCenterPanel5.add(toppingBox,BorderLayout.NORTH); 
    subCenterPanel5.add(timeLabel,BorderLayout.NORTH);
    subCenterPanel5.add(pickupBox,BorderLayout.NORTH);
    
    mainCenterPanel = new JPanel();
    mainCenterPanel.setLayout(new BorderLayout());
    mainCenterPanel.add(subCenterPanel0,BorderLayout.NORTH);
    mainCenterPanel.add(subCenterPanel1,BorderLayout.WEST);
    mainCenterPanel.add(subCenterPanel2,BorderLayout.CENTER);
    mainCenterPanel.add(subCenterPanel4,BorderLayout.EAST);
    mainCenterPanel.add(subCenterPanel5,BorderLayout.SOUTH);
    add(mainCenterPanel,BorderLayout.CENTER);
    
    //SouthPanel
    subSouthPanel1 = new JPanel();
    visaIcon = new ImageIcon("visa.png");
    masterIcon = new ImageIcon("master.png");
    discoverIcon = new ImageIcon("discover.png");
    expressIcon = new ImageIcon("american.png");
    visaLabel = new JLabel(visaIcon);
    discoverLabel = new JLabel(discoverIcon);
    masterLabel = new JLabel(masterIcon);
    americanExpressLabel = new JLabel(expressIcon);
    masterCard = new JRadioButton();
    visaCard = new JRadioButton();
    discoverCard = new JRadioButton();
    americanExpressCard = new JRadioButton();
    cardGroup = new ButtonGroup();
    cardGroup.add(masterCard);
    cardGroup.add(visaCard);
    cardGroup.add(discoverCard);
    cardGroup.add(americanExpressCard);
    subSouthPanel1.add(masterLabel);
    subSouthPanel1.add(masterCard);
    subSouthPanel1.add(visaLabel);
    subSouthPanel1.add(visaCard);
    subSouthPanel1.add(discoverLabel);
    subSouthPanel1.add(discoverCard);
    subSouthPanel1.add(americanExpressLabel);
    subSouthPanel1.add(americanExpressCard);
    
    subSouthPanel2 = new JPanel();
    cardNumberTextField = new JTextField(5);
    cardDateTextField = new JTextField(5);
    cardNumberLabel = new JLabel("Card Number: ");
    dateLabel = new JLabel("Expiration Date (MM/DD/YY): ");
    subSouthPanel2.add(cardNumberLabel); 
    subSouthPanel2.add(cardNumberTextField);
    subSouthPanel2.add(dateLabel);
    subSouthPanel2.add(cardDateTextField);
      
    subSouthPanel3 = new JPanel();
    orderButton = new JButton("Order");
    orderButton.addActionListener(this);
    clearButton = new JButton("Clear");
    subSouthPanel3.add(orderButton);
    subSouthPanel3.add(clearButton);
   
    mainSouthPanel = new JPanel();
    mainSouthPanel.setLayout(new BorderLayout());
    mainSouthPanel.add(subSouthPanel1,BorderLayout.NORTH);
    mainSouthPanel.add(subSouthPanel2,BorderLayout.CENTER);
    mainSouthPanel.add(subSouthPanel3,BorderLayout.SOUTH);
    add(mainSouthPanel,BorderLayout.SOUTH);
    
    setVisible(true);
    setSize(546,580);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
   
  public void actionPerformed(ActionEvent event){
//OrderButton 
 if(event.getSource() == orderButton){
//TextField   
    String fName = firstNameTextField.getText();
    String lName = lastNameTextField.getText();
//file
    File myfile = new File("cakeorder.txt");
      try{
    if(fName.equals("")){
     throw new NameException(); }
    if(lName.equals("")){
     throw new NameException(); }
//Checkbox   
 String memberstatus = "No";
    if(memberBox.isSelected()){
    memberstatus = "Yes";}
//DropBox
    String toppingflavor = toppingBox.getSelectedItem().toString();
//RadioButton for flavor
       String cakeflavor = "";
       
       if(chocolateButton.isSelected()){
         cakeflavor = "Chocolate";
         }
       if(vanillaButton.isSelected()){
         cakeflavor = "Vanilla";
         }
       if(creamButton.isSelected()){
         cakeflavor = "Ice Cream";
         }
       if(lemonButton.isSelected()){
         cakeflavor = "Lemon";
         }
 //RadioButton for cards
       String cardtype = "";
       
       if(masterCard.isSelected()){
         cardtype = "Mastercard";
         }
       if(visaCard.isSelected()){
         cardtype = "Visa";
         }
       if(discoverCard.isSelected()){
         cardtype = "Discover";
         }
       if(americanExpressCard.isSelected()){
         cardtype = "American Express";
         }
//GUI Output Message  
       String outputMessage =   "Order Summary"+
                           "\nName: "+fName+" "+lName+
                           "\nExisting Membership: "+memberstatus+
                           "\nCake Flavor: "+cakeflavor+
                           "\nCake Topping: "+toppingflavor+
                           "\nPayment Type: "+cardtype;
  JOptionPane.showMessageDialog(null,outputMessage);
//Database
  String URL = "jdbc:mysql://localhost/cakeapp?user=root&password=";
    //try{
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("JDBC connected successfully.");
    
      Connection con = DriverManager.getConnection(URL);
      System.out.println("MySQL connected successfully.");
    
      String sqlStatement = "insert into cakeorder values('"+fName+"','"+lName+"','"+memberstatus+"','"+cakeflavor+"','"+toppingflavor+"','"+cardtype+"')";
      
      Statement stmt = con.createStatement();
      stmt.execute(sqlStatement);
      System.out.println("Executed successfully.");
 //file
    FileWriter writer = new FileWriter(myfile);//true to repeat
   writer.write("Order Summary\n");
   writer.write("Name: "+fName+" "+lName+"\n");
   writer.write("Existing Membership: "+memberstatus+"\n");
   writer.write("Cake Flavor: "+cakeflavor+"\n");
   writer.write("Cake Topping: "+toppingflavor+"\n");
   writer.write("Payment Type: "+cardtype+"\n");
    writer.close();
    }
   catch(NameException e){
     JOptionPane.showMessageDialog(null,e.getMessage());
    }
   catch(IOException e){
      e.printStackTrace();
      //OR
      System.out.println(e.getMessage());
    }
    catch(ClassNotFoundException ex){
      ex.printStackTrace();
    }
    catch(SQLException ex){
      ex.printStackTrace();
  }
 }
} 
public static void main(String[]args){
  CakeOrder2 app = new CakeOrder2();
  }
}


