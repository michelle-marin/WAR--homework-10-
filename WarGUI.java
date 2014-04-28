// GUI for tic tac toe
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   private War game; // the guts
   private JPanel topPanel,gamePanel;  // break up regions
   private JButton [][] buttons;    // grid of buttons
   private JLabel status;  // game status
   private JLabel title;   // static title
   public WarGUI()
   {
      setLayout(new GridLayout(2,1));
      game =new War();
      topPanel = new JPanel();
      topPanel.setBackground(Color.gray);
         
      title = new JLabel("Michelle Marin's  War Game");
      title.setFont(new Font("HELVETICA", Font.PLAIN, 36));
      topPanel.add(title);
         
      status = new JLabel("Game in progress");
      status.setFont(new Font("ARIAL",Font.BOLD,24));
      topPanel.add(status);
      

      add(topPanel);
      add(gamePanel);
   }

}