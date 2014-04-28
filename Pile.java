public class Pile extends Deck
{
   private final int TOTAL = 52;
   private ListArrayListBased pile;
   
   public Pile(Deck deck)
   {
      pile = new ListArrayListBased();
      
      for (int i=0; i<= TOTAL; i++)
      {
         Card card = deck.draw();
         pile.add(i,card);
         
      } 
   }
   
   public int size()
   {
      return pile.size();
   }
   
   public void add(int index, Card card)
   {
      pile.add(pile.size()+1,card);
   }
   
   public Card draw()
   {
      Card card;
      card = (Card)(pile.get(1));
      pile.remove(1);
      return card;
   }
   
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