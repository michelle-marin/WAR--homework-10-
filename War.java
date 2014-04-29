public class War
{
   private Deck deck;
   private Pile player1, player2;
   
   public War()
   {
      deck = new Deck();
      player1 = new Pile(deck);
      player2 = new Pile(deck);
   
   }
   
   public Card draw(int i)
   {
     if (i==0)
       return (Card)(player1.draw());
   
     else
    
      return (Card)(player2.draw()); 
   }
   
   public void add(int i, Card card)
   {
      if(i==0)
      {
         player1.add(player1.size()+1,card);
      }
      else
      {
         player2.add(player2.size()+1,card);
      } 
   }
   
   public void add(int i, Card card1, Card card2)
   {
      if(i==0)
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
   
   public int pileSize(int i)
   {
      if (i==0)
         return player1.size();
      else
         return player2.size();
   }
   
   public String toString()
   {
      String s1, s2;
      
      s1 = "User: " + player1.size();
      s2 = "Computer: " + player2.size();
      
      return s1 + "\n" + s2;
   }
   
   public void numberCards(ListArrayListBased list)
   {
      System.out.println("Cards won: ");
      for(int i=1; i<=list.size();i++)
      {
         System.out.println(list.get(i));
      }
   }
   
   public boolean outOfCards(int i)
   {
      if (i==0)
         return player1.isEmpty();
      else
         return player2.isEmpty();
   }
   
}
