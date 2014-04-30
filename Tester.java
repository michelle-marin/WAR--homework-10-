import javax.swing.*;

public class Tester
{
   public static void main(String[] args)
   {
      JFrame frame = new WarGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frame.setTitle("War game");
      frame.setSize(12,6);
      frame.validate();
      frame.setVisible(true);
   }
}