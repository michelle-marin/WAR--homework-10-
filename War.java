/**
Michelle Marin
CS 110
Final Project (War class)
*/
public class War
{
   //variables
   private Deck deck;
   private Pile player1, player2;
   
   /**
      War constructor
   */
   public War()
   {
      deck = new Deck();
      player1 = new Pile(deck);
      player2 = new Pile(deck);
   
   }
   /**
      Method that draws a card from deck
      @param int i to know which pile to draw card from
      @return card drawn
   */
   public Card draw(int i)
   {
     if (i==1)
       return (Card)(player1.draw());
   
     else
    
      return (Card)(player2.draw()); 
   }
   
   /**
      Method that adds card to a pile
      @param int i to know which pile to add cards to
      @param Card card to add card object to pile
   */
   public void add(int i, Card card)
   {
      if(i==1)
      {
         player1.add(player1.size()+1,card);
      }
      else
      {
         player2.add(player2.size()+1,card);
      } 
   }
   /**
      Method that adds cards to a pile (after War)
      @param int i to know which pile to add cards to
      @param Card card to add card objects to pile
   */
   public void add(int i, Card card1, Card card2)
   {
      if(i==1)
      {
         player1.add(player1.size()+1,card1);
         player1.add(player1.size()+1,card2);
      }
      else
      {
         player2.add(player2.size()+1,card1);
         player2.add(player2.size()+1,card2);
      }
   }
   /**
      Method returns the pile size
      @param int i to know which pile
      @return pile size
   */
   public int pileSize(int i)
   {
      if (i==1)
         return player1.size();
      else
         return player2.size();
   }
   /**
      Moethod returns a string
      @return string
   */
   public String toString()
   {
      String s1, s2;
      
      s1 = "User: " + player1.size();
      s2 = "Computer: " + player2.size();
      
      return s1 + "\n" + s2;
   }
   /**
      Method displays total amount of cards
      @param takes in a list
   */
   public void numberCards(ListArrayListBased list)
   {
      System.out.println("Cards won: ");
      for(int i=1; i<=list.size();i++)
      {
         System.out.println(list.get(i));
      }
   }
   /**
      Method returns true if pile is empty
      @param takes in an int to know which pile to check
      @return true if empty
      @return false if not empty
   */
   public boolean outOfCards(int i)
   {
      if (i==1)
         return player1.isEmpty();
      else
         return player2.isEmpty();
   }
   
}
