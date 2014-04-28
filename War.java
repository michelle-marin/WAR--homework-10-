public class War
{
   public War()
   {
      Deck deck = new Deck();
      Pile player1 = new Pile(deck);
      Pile player2 = new Pile(deck);
      
      if (player1.draw() > player2.draw())
      {
         
      }
      else if (player2.draw() > player1.draw())
      {
      
      }
      else if (player1.draw() == player2.draw())
      {
         toWar();
      }    
   }
   
   public String toWar()
   {
      
   }
}
