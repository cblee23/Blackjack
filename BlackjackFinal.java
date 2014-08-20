import java.util.Scanner;


public class BlackjackFinal
{
	public static void main( String[] args )
	{
		Scanner kb = new Scanner(System.in);
						
		System.out.println("Welcome to Chris's Blackjack Program!");
				
		System.out.println("Let's get started.  How many chips would you like to purchase?");
		int chips = kb.nextInt();
		Player p = new Player();
		int wager = p.bet(chips);
		
		
		do
		{	
			//This has the user select the number of chips they'd like to bet.  
						
			Card c = new Card();
			int p_card1 = c.cardValue();
			String p_suit1 = c.cardSuit(p_card1);
			int p_card2 = c.cardValue();
			String p_suit2 = c.cardSuit(p_card2);
			int p_total = p_card1 + p_card2;
			int p_hitcard;
			//The above expressions are creating the first 2 cards, and adding them together to give the total.
		
			System.out.println("You get a(n) " + p_suit1 + " and a(n) " + p_suit2 + ".");
			System.out.println("Your total is " + p_total);
			System.out.println();
		
			// Here we've determined the dealer's cards.  Only the first will show.
			int d_card1 = c.cardValue();
			String d_suit1 = c.cardSuit(d_card1);
			int d_card2 = c.cardValue();
			String d_suit2 = c.cardSuit(d_card2);
			int d_total = d_card1 + d_card2;
			
		
			System.out.println("The dealer has a(n) " + d_suit1 + " showing, and a hidden card.");
			System.out.println("His total is hidden, too");		
			System.out.println();
		
			// Checking for blackjacks
			if ( p_total == 21 )	
			{
				System.out.println("You got a Blackjack!  Now let's see what the dealer has...");
			
				if ( d_total == 21 )
				{
					System.out.println("It's a push!  At least you didn't lose your money.");
				}
				else
				{
					chips = p.addChips(chips, wager);
					System.out.println("You win!");
					System.out.println();
				}
			}
			
			else if ( d_total == 21 )
			{
				System.out.println("The dealer has blackjack.  You lose!");
				chips = p.removeChips(chips, wager);
				System.out.println();
			}
			
			else
			{
				//This is the main game if no players have a blackjack
				p_total = p.playerTurn(p_total, chips, wager);
				
				if ( p_total <= 21 )
					p.dealerTurn(p_total, d_total, d_card1, d_card2, chips, wager);
					
			}
			
			restart(chips);
			p.bet(chips);
			
		} while ( chips > 0 );
		
		System.out.println();
	}
	
	public static int restart(int chips)
	{
		//This just checks to make sure that the player is unable to bet if they are out of chips.
		if (chips <= 0)
		{
			System.out.println("You're all out of chips.  That's the end of the line.");
			return 0;
		}
		else
			return chips;
	}
	
}

	
	
	
	
	
	