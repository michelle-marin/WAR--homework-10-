import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   
   //variables
   private War game;
   private static final int WAR = 2;

   private Card card1, card2;
   private ListArrayListBased temp;
   
   //labels and variables for images
   private JLabel player1, player2;
   private JLabel p1, p2, p3, p4;
   private ImageIcon f1, f2, b;
      
   private JPanel panel1, panel2, panel3, panel4, panel5, panel6;  // break up regions
   private JButton button1, button2;    // grid of buttons
   private JLabel title, status;  // game status
   

   /**
      WarGUI constructor
   */
   public WarGUI()
   {
      // temporary list
      temp = new ListArrayListBased();
      
      //layout of GUI
      setLayout(new GridLayout(2,3));
      game = new War();
      
      panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER,50,50));
      panel1.setBackground(Color.GRAY);
      panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,50));
      panel2.setBackground(Color.GRAY);
      panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER,50,50));
      panel3.setBackground(Color.GRAY);
      panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER,50,50));
      panel4.setBackground(Color.GRAY);
      panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER,50,10));
      panel5.setBackground(Color.GRAY);
      panel6 = new JPanel(new FlowLayout(FlowLayout.CENTER,50,50));
      panel6.setBackground(Color.GRAY);
      
      // what will go in the title  
      title = new JLabel(game.toString());
      status = new JLabel();
      
      //style 
      title.setFont(new Font("ARIAL",Font.BOLD,24));
      panel2.add(title);
      panel2.add(status);
      
      //first (play) button
      button1 = new JButton("Draw a card");
      button1.addActionListener(new ButtonListener());
      panel5.add(button1);
      //second button (go to war)
      button2 = new JButton("Go to War");
      button2.addActionListener(new ButtonListener2());
      panel5.add(button2);
      button2.setEnabled(false);
      
      //set the first images as all back
      b = new ImageIcon("cardPics/back.jpg");
      p1 = new JLabel(b);
      p2 = new JLabel(b);
      p3 = new JLabel(b);
      p4 = new JLabel(b);
      
      //put them in the GUI
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
   /**
      Method that flips the first card in each list
   */
   public void flip()
   {
      //cards
      card1 = game.draw(1);
      card2 = game.draw(2);
      
      //compares to see who won the battle
      //1 = user wins
      if(card1.compareTo(card2) == 1)
      {
         //adds cards user to pile
         game.add(1,card1,card2);
         
         // displays result
         title.setText(game.toString());
         status.setText("You won the batle! (+1 card)");
                         
      }
      
      // -1 computer wins
      else if(card1.compareTo(card2) == -1)
      {
        //adds card to computer pile
        game.add(2,card1,card2);
         //displays result
         title.setText(game.toString());
         status.setText("You lose the batle :( (-1 card)"); 
      }
      
      //  0 = both the same
      else if(card1.compareTo(card2) == 0)
      {
         // displays that they will go to war
         status.setText(".....WAR!");
         
         temp.add(1, card1);
         temp.add(2, card2);
         
         // anable war button
         button1.setEnabled(false);
         button2.setEnabled(true);
      }
   }// end of flip
   
   /**
      Method for play button
   */
   
   private class ButtonListener implements ActionListener
   {
      // when putton pressed to the following:
      public void actionPerformed(ActionEvent e)
      {
         // if not out of cards
         if(!game.outOfCards(1) && !game.outOfCards(2))
         {
            // go to flip method
            flip();
            //set images
            String s = "cardPics/"+card1+".jpg";
            f1 = new ImageIcon(s);
            f2 = new ImageIcon("cardPics/"+card2+".jpg");
            //display images
            p1.setIcon(f1);
            p2.setIcon(f2);

         }
         // if user is out of cards:
         else if (game.outOfCards(1))
         {
            //diplay message
            status.setText("Sorry you are out of cards. Computer wins");
            //disable both buttons
            button1.setEnabled(false);
            button2.setEnabled(false);
         }
         
         // if computer is out of cards
         else if (game.outOfCards(2))
         {
            //display message
            status.setText("Computer is out of cards. You win!!");
            
            //disable buttons
            button1.setEnabled(false);
            button2.setEnabled(false);
         }
         
         //title = amount of cards each player has
         title.setText(game.toString());
      }
      
   }
  /**
   Method for war button
   */
   private class ButtonListener2 implements ActionListener
   {
      //if pressed do the following
      public void actionPerformed(ActionEvent e)
      {
         
         button1.setEnabled(true);
         button2.setEnabled(false);
         
         // variable for do-while loop
         int statusWhile = 0;
         
         //if the pile has for both of the players is greater than 2 do the following:
         if(game.pileSize(1)>= WAR && game.pileSize(2) >= WAR)
         {
            do
            {
               
               if(game.pileSize(1)>= WAR && game.pileSize(2) >= WAR)
               {
                  //variables
                  Card rCard1, rCard2;
                  
                  // for loop for war
                  for (int i=1; i<=WAR; i++)
                  {
                     //add cards to temp list
                     rCard1 = game.draw(1);
                     temp.add(1,rCard1);
                     rCard2 = game.draw(2);
                     temp.add(2,rCard2);
                     
                  }
                  //get the last card out of the tamp list
                 rCard1 = (Card)(temp.get(2));
                 rCard2 = (Card)(temp.get(1));
                 
                 // 1 = user wins (user card > computer card)
                 if(rCard1.compareTo(rCard2) == 1)
                 {
                     //finds images
                     f1 = new ImageIcon("cardPics/"+rCard1+".jpg");
                     f2 = new ImageIcon("cardPics/"+rCard2+".jpg");
                     
                     //sets images
                     p1.setIcon(f1);
                     p2.setIcon(f2);
                     
                     //make a temp object
                     Card tempCard;
                     
                     for(int i=1; i<=temp.size(); i++)
                     {
                        //get value of card
                        tempCard = (Card)(temp.get(i));
                        game.add(1, tempCard);
                     }
                     
                     //erase everything inside the temp list
                     temp.removeAll();
                     
                     
                     //display result
                     title.setText(game.toString());
                     status.setText("You won the WAR!!");
                     
                     // end do-while loop
                     statusWhile = 1;
                    
                 }
                 
                 //same as before but in the scenario the computer wins
                 if(rCard1.compareTo(rCard2) == -1)
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
                     
                     title.setText(game.toString());
                     status.setText("You lost the War :(");
                    
                 }
                 //same in this scenario they both get the same card again
                 else
                 {
                    f1 = new ImageIcon("cardPics/"+rCard1+".jpg");
                    f2 = new ImageIcon("cardPics/"+rCard2+".jpg");
                     
                     p1.setIcon(f1);
                     p2.setIcon(f2);
                     
                     statusWhile = 0;
                     
                     title.setText(game.toString());
                     status.setText("WAR!..again");
                     
                 }
                 
                  
               }
               
               // if computer runs out of cards for war
               else if (game.pileSize(1) > game.pileSize(2))
               {
                  //disable both buttons
                  button1.setEnabled(false);
                  button2.setEnabled(false);
                  //display message
                  status.setText("Computer ran out of cards. You win!!");
               }
               // if user runs out of cards for war
               else if (game.pileSize(2) > game.pileSize(1))
               {
                  //disable buttons
                  button1.setEnabled(false);
                  button2.setEnabled(false);
                  //display message
                  status.setText("You ran out of cards. Computer Wins.");
               }  
         }while (statusWhile < 1); //constraint for do-while
      }
   }
  }
}
