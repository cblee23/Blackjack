import java.util.Random;

public class DealACard
{
		
	 int value;
     String suit;
     String name;

	public String toString()
	{
 		return name + " of " + suit;
    }

	public static Card[] buildDeck()
	{
		String[] suits = { "clubs", "diamonds", "hearts", "spades" };
		String[] names = { "ZERO", "ONE", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "Jack", "Queen", "King", "Ace" };
		
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
}
