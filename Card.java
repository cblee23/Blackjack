import java.util.Random;

public class Card
{
	 // In this class, I am creating the cards that will be used for the game.
	 
	 int value;
     String suit;
     String name;

	public static Card[] buildDeck()
	{
		String[] suits = { "clubs", "diamonds", "hearts", "spades" };
		String[] names = { "ZERO", "ONE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		
		int i = 0;
		Card[] deck = new Card[52];
		
		for ( String s: suits )
		{
			for ( int v = 2; v <= 14; v++ )
			{
				Card c = new Card();
				c.suit = s;
				c.name = names[v];
				if ( v == 14 )
					c.value = 11;
				else if ( v > 10 )
					c.value = 10;
				else
					c.value = v;
				
				deck[i] = c;
				i++;
			}
		}
		return deck;
	}
	
	public int cardValue()
	{
		 // This will determine the value of the card. This will pick a random card each time the function is called, and assign it a value for the game.
		 
		 Card c = new Card();
		 
		 Card[] deck = c.buildDeck();
        
         int chosen = (int)(Math.random()*deck.length);
         Card picked = deck[chosen];
         
         return picked.value;
	}
	
	public String cardSuit(int p_card)
	{
		Random r = new Random();
		int suit = r.nextInt(4);
		String cardsuit="";
		String card = "";
		
		if ( suit == 0 )
			cardsuit = "diamonds";
		else if ( suit == 1 )
			cardsuit = "hearts";
		else if ( suit == 2 )
			cardsuit = "spades";
		else if ( suit == 3 )
			cardsuit = "clubs";
			
		int face = r.nextInt(4);
		if ( p_card == 10 )
		{
			if ( face == 0 )
				card = "10";
			else if ( face == 1 )
				card = "J";
			else if ( face == 2 )
				card = "Q";
			else if ( face == 3 )
				card = "K";
		}
			
		else if ( p_card == 11 )
			card = "A";
			
		else if ( p_card == 2 )
			card = "2";	
		else if ( p_card == 3 )
			card = "3";
		else if ( p_card == 4 )
			card = "4";
		else if ( p_card == 5 )
			card = "5";
		else if ( p_card == 6 )
			card = "6";
		else if ( p_card == 7 )
			card = "7";
		else if ( p_card == 8 )
			card = "8";
		else if ( p_card == 9 )
			card = "9";
		
		return (card + " of " + cardsuit);
		 
	}	
	
}
