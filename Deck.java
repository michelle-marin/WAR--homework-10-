import java.util.Random;
/**
Michelle Marin
CS 110
Final Project (Deck class)
*/   
public class Deck 
{
   // variables
   private int suits = 4;
   private int ranks = 13;
   
   // stsrts list
   private ListArrayListBased deck = new ListArrayListBased();
   
   /**
      Constructor that creates a deck of cards
   */
   
   public Deck()
   {
      //for loop for assigning a suit
      for (int i=1; i <= ranks; i++)
      {
         //for loop for assigning a rank
         for (int j=1; j <= suits; j++)
         {
            // make card object with suit and rank
            Card card = new Card(i,j);
            
            //add card object to deck
            deck.add(i,card);
         }
      }
       
      shuffle();//shuffle cards
   }
   
   /**
      Method that shuffles cards in deck
    */
   public void shuffle()
   {
      //variables
      int randCard;
      int t = 51;
      Card temp, card2;
      Random r = new Random();
      //for loop to switch cards around
      for (int i = 1; i < deck.size(); i++)
      {
      
         randCard = r.nextInt(t)+1;
         
         //gets card
         temp = (Card)(deck.get(i));
         card2 = (Card)(deck.get(randCard));
         
         //removes card
         deck.remove(i);
         deck.remove(randCard);
         //adds card
         deck.add(i,card2);
         deck.add(randCard,temp);
         
      }      
   }
   /**
      Method that draws card from deck
      @return A card drawn from deck
   */
   public Card draw()
   {
      //variables
      Card card;
      int aCard = 1;
      //gets card
      card = (Card)(deck.get(aCard));
      //removes card
      deck.remove(aCard);
      //returns card
      return card;
   }
   /**
      Method that returns size of deck
      @return size of deck
   */
   public int size()
   {
      return deck.size();
   }
   
   
}
