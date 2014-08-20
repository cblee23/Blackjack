public class BlackjackTest
{
	public int cardValue()
	{
		 Card c = new Card();
		 
		 Card[] deck = c.buildDeck();
        
         int chosen = (int)(Math.random()*deck.length);
         Card picked = deck[chosen];
         
         return picked.value;
		
	}
}