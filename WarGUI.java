// GUI for tic tac toe
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   private War game;
   private static final int WAR = 2;

   private Card card1, card2;
   private ListArrayListBased temp;
   
   private JLabel player1, player2;
   private JLabel p1, p2, p3, p4;
   private ImageIcon f1, f2, b;
      
   private JPanel panel1, panel2, panel3, panel4, panel5, panel6;  // break up regions
   private JButton button1, button2;    // grid of buttons
   private JLabel status1, status2;  // game status
   private JLabel title;   // static title


   public WarGUI()
   {
      temp = new ListArrayListBased();
      
      setLayout(new GridLayout(2,3));
      game = new War();
      
      panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER,50,50));
      panel1.setBackground(new Color(20,132,7));
      panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,50));
      panel2.setBackground(new Color(20,132,7));
      panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER,50,50));
      panel3.setBackground(new Color(20,132,7));
      panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER,50,50));
      panel4.setBackground(new Color(20,132,7));
      panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER,50,10));
      panel5.setBackground(new Color(20,132,7));
      panel6 = new JPanel(new FlowLayout(FlowLayout.CENTER,50,50));
      panel6.setBackground(new Color(20,132,7));
      
      
      // topPanel = new JPanel();
//       topPanel.setBackground(Color.gray);
//          
//       title = new JLabel("Michelle Marin's  War Game");
//       title.setFont(new Font("HELVETICA", Font.PLAIN, 36));
//       topPanel.add(title);
         
      status1 = new JLabel(game.toString());
      status2 = new JLabel();
      
      status1.setFont(new Font("ARIAL",Font.BOLD,24));
      panel2.add(status1);
      panel2.add(status2);
      
      button1 = new JButton("Draw a card");
      button1.addActionListener(new ButtonListener());
      panel5.add(button1);
      
      button2 = new JButton("Complete War");
      button2.addActionListener(new ButtonListener2());
      panel5.add(button2);
      button2.setEnabled(false);
      
      b = new ImageIcon("cardPics/back.jpg");
      p1 = new JLabel(b);
      p2 = new JLabel(b);
      p3 = new JLabel(b);
      p4 = new JLabel(b);
      
      panel1.add(p1);
      panel3.add(p2);
      panel4.add(p3);
      panel6.add(p4);
      
      add(panel1);
      add(panel2);
      add(panel3);
      add(panel4);
      add(panel5);
      add(panel6);

   }
   public void flip()
   {
      card1 = game.draw(1);
      card2 = game.draw(2);
      
      if(card1.compareTo(card2) == true)
      {
         game.add(1,card1,card2);
         
         status1.setText(game.toString());
         status2.setText(card1.getString() + " is greater than " + 
                         card2.getString()+ ". You won the batle! (+1 card)");
                         
      }
      
      else if(card1.compareTo(card2) == false)
      {
        game.add(2,card1,card2);
         
         status1.setText(game.toString());
         status2.setText(card1.getString() + " is less than " + 
                         card2.getString()+ ". You lose the batle :( (-1 card)"); 
      }
      
      else if(card1.equals(card2))
      {
         status2.setText(card1.getString()+" is equal to "+card2.getString()+"...WAR!");
         
         temp.add(1, card1);
         temp.add(2, card2);
         
         button1.setEnabled(false);
         button2.setEnabled(true);
      }
   }// end of flip
   
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(!game.outOfCards(1) && !game.outOfCards(2))
         {
            flip();
            
            f1 = new ImageIcon("cardPics/"+card1+".jpg");
            f2 = new ImageIcon("cardPics/"+card2+".jpg");
            
            p1.setIcon(f1);
            p2.setIcon(f2);
         }
         
         else if (game.outOfCards(1))
         {
            status2.setText("Sorry you are out of cards. Computer wins");
            
            button1.setEnabled(false);
            button2.setEnabled(false);
         }
         
         else if (game.outOfCards(2))
         {
            status2.setText("Computer is out of cards. You win!!");
            
            button1.setEnabled(false);
            button2.setEnabled(false);
         }
         
         status1.setText(game.toString());
      }
      
   }
   
   private class ButtonListener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         button1.setEnabled(true);
         button2.setEnabled(false);
         
         int statusWhile = 0;
         
         if(game.pileSize(1)>= WAR && game.pileSize(2) >= WAR)
         {
            do
            {
               if(game.pileSize(1)>= WAR && game.pileSize(2) >= WAR)
               {
                  Card rCard1, rCard2;
                  
                  for (int i=0; i<=WAR; i++)
                  {
                     rCard1 = game.draw(1);
                     temp.add(0,rCard1);
                     rCard2 = game.draw(2);
                     temp.add(1,rCard2);
                     
                  }
                 rCard1 = (Card)(temp.get(2));
                 rCard2 = (Card)(temp.get(1));
                 
                 if(rCard1.compareTo(rCard2) == true)
                 {
                     f1 = new ImageIcon("cardPics/"+rCard1+".jpg");
                     f2 = new ImageIcon("cardPics/"+rCard2+".jpg");
                     
                     p1.setIcon(f1);
                     p2.setIcon(f2);
                     
                     Card tempCard;
                     
                     for(int i=1; i<=temp.size(); i++)
                     {
                        tempCard = (Card)(temp.get(i));
                        game.add(1, tempCard);
                     }
                     
                     temp.removeAll();
                     
                     statusWhile = 1;
                     
                     status1.setText(game.toString());
                     status2.setText(rCard1.getString() + " is greater than "+
                                       rCard2.getString()+ ". You won the WAR!!");
                    
                 }
                 
                 if(rCard1.compareTo(rCard2) == false)
                 {
                     f1 = new ImageIcon("cardPics/"+rCard1+".jpg");
                     f2 = new ImageIcon("cardPics/"+rCard2+".jpg");
                     
                     p1.setIcon(f1);
                     p2.setIcon(f2);
                     
                     Card tempCard;
                     
                     for(int i=1; i<=temp.size(); i++)
                     {
                        tempCard = (Card)(temp.get(i));
                        game.add(2, tempCard);
                     }
                     
                     temp.removeAll();
                     
                     statusWhile = 1;
                     
                     status1.setText(game.toString());
                     status2.setText(rCard1.getString() + " is less than "+
                                       rCard2.getString()+ ". You lost the War :(");
                    
                 }
                 
                 else
                 {
                    f1 = new ImageIcon("cardPics/"+rCard1+".jpg");
                    f2 = new ImageIcon("cardPics/"+rCard2+".jpg");
                     
                     p1.setIcon(f1);
                     p2.setIcon(f2);
                     
                     statusWhile = 0;
                     
                     status1.setText(game.toString());
                     status2.setText(rCard1.getString() + " equal to "+
                                       rCard2.getString()+ "....WAR!");
                     
                 }
                 
                  
               }
               
               else if (game.pileSize(1) > game.pileSize(2))
               {
                  button1.setEnabled(false);
                  button2.setEnabled(false);
                  
                  status2.setText("Computer ran out of cards. You win!!");
               }
               else if (game.pileSize(2) > game.pileSize(1))
               {
                  button1.setEnabled(false);
                  button2.setEnabled(false);
                  
                  status2.setText("You ran out of cards. Computer Wins.");
               }  
         }while (statusWhile < 1);
      }
   }
  }
}
