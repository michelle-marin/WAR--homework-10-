import javax.swing.*;
/**
Michelle Marin
CS 110
Final Project (War tester)
*/

public class Tester
{
   //main method
   public static void main(String[] args) 
   {
      //initialize GUI
      JFrame frame = new WarGUI();
      //close GUI
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Frame characteristics
      frame.setTitle("War game");
      frame.setSize(1000,700);
      frame.validate();
      frame.setVisible(true);
   }
}