/**
Michelle Marin
CS 110
Final Project (Pile class)
*/
public class Pile extends Deck
{
   //variables
   private final int TOTAL = 26;
   private ListArrayListBased pile;
   /**
      Constructor that adds card to a pile
      @param takes in a Deck
   */
   public Pile(Deck deck)
   {
      pile = new ListArrayListBased();
      
      for (int i=1; i<= TOTAL; i++)
      {
         Card card = deck.draw();
         pile.add(i,card);
         
      } 
   }
   /**
      Method that returns the pile size
      @return pile size
   */
   public int size()
   {
      return pile.size();
   }
   /**
      Method that adds a card to pile
      @param int to know index in list 
      @param Card that will be added to pile
   */
   public void add(int index, Card card)
   {
      pile.add(pile.size()+1,card);
   }
   /**
      Method that draws a card from the pile
      @returns card drawn
   */
   public Card draw()
   {
      Card card;
      card = (Card)(pile.get(1));
      pile.remove(1);
      return card;
   }
   /**
      Method that determines if pile is empty
      @return true if empty
      @return false if not empty
   */
   public boolean isEmpty()
   {
      if (pile.isEmpty())
      {
         return true;
      }
      else
      {
         return false;
      }
   }
} 