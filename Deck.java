import java.util.Random;
public class Deck 
{
   private static final int aCard = 1;
   private int t = 52;
   private int suits = 4;
   private int ranks = 13;
   
   private ListArrayListBased deck = new ListArrayListBased();
   
   public Deck()
   {
      //for loop for assigning a suit
      for (int i=1; i <= suits; i++)
      {
         //for loop for assigning a rank
         for (int j=1; j <= 14; j++)
         {
            // make card object with suit and rank
            Card card = new Card(i,j);
            
            //add card object to deck
            deck.add(j,card);
         }
      }
       
      shuffle();
   }
   
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }
   
   public Card draw()
   {
      Card card;
      card = (Card)(deck.get(aCard));
      deck.remove(aCard);
      return card;
   }
   
   public int size()
   {
      return deck.size();
   }
   
   
}
