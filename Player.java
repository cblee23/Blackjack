import java.util.Scanner;

public class Player
{
	public int playerTurn(int p_total, int chips, int wager)
	{
		Scanner kb = new Scanner(System.in);
		
		//This function will focus on the player's turn.
		Card c = new Card();
		int p_hitcard;

		if ( p_total > 21 )
			System.out.println("Error!  You can't bust on the flop!");
		// This accounts for the rare 11/11 occurrence if 2 aces should arise. 
		
		else
		{
			System.out.println("Would you like to \"hit\" or \"stay\"?");
			String hit = kb.next();
			
			//The player can hit as long they haven't busted.  If they type in anything else, it will not play another card. 
			
			while ( p_total <= 21 && hit.equalsIgnoreCase("hit") )
			{
				p_hitcard = c.cardValue();
				String p_suithit = c.cardSuit(p_hitcard);
				System.out.println("You drew a(n) " + p_suithit);
				p_total = p_total + p_hitcard;
									
				if ( p_total <= 21 )
				{	
					System.out.println("Your total is " + p_total );
					System.out.println();
					System.out.println("Would you like to \"hit\" or \"stay\"?");
					hit = kb.next();
				}
	
				else 
				{	
					System.out.println("You have busted.");
					System.out.println();
					chips = removeChips(chips, wager);
				}
			}
		}
		return p_total;
	}		
		
	public void dealerTurn(int p_total, int d_total, int d_card1, int d_card2, int chips, int wager)
	{
				Card c = new Card();

				System.out.println();
				System.out.println("Okay, dealer's turn.");
				String d_suit2 = c.cardSuit(d_card2);
				System.out.println("His hidden card was a(n) " + d_suit2);
				System.out.println("His total was " + d_total);
				System.out.println();
	
				// If the dealer has between a 17 & 21, they will stay.
				
				if ( d_total >= 17 && d_total < 21 )
				{
					System.out.println("Dealer stays.");
					System.out.println("Dealer total is " + d_total);
					System.out.println("Your total is " + p_total);
						
					if ( p_total > d_total)
					{	
						chips = addChips(chips, wager);
						System.out.println("You win!");
						System.out.println();
						bet(chips);
					}	
					else if ( p_total < d_total )
					{
						chips = removeChips(chips, wager);
						System.out.println("You lose!");
						System.out.println();
						bet(chips);
					}
					else
					{
						System.out.println("It's a push!  Nobody wins.");
						System.out.println();
						bet(chips);
					}				
				}
			
				else
				{		
					int d_hitcard;
					
					//This loop makes sure that while the dealer is under 17, he will continue to hit.
					while ( d_total < 17 )
					{
						System.out.println("Dealer hits");
						d_hitcard = c.cardValue();
						String d_suithit = c.cardSuit(d_hitcard);
						System.out.println("Dealer drew a(n) " + d_suithit );
						d_total = d_total + d_hitcard;
				
						//Once the dealer is at 17 or higher, they will stop hitting.  Then it will compare the totals to determine who wins.
						if ( d_total <= 21 && d_total >= 17)
						{
							System.out.println("Dealer stays.");
							System.out.println();
							System.out.println("Dealer total is " + d_total);
							System.out.println("Your total is " + p_total);
						
							if ( p_total > d_total && d_total >= 17 )
							{
								System.out.println();
								chips = addChips(chips, wager);
								System.out.println("You win!");
								
							}
							else if ( d_total > p_total && d_total >=17 )
							{
								System.out.println();
								chips = removeChips(chips, wager);
								System.out.println("You lose!");
								
							}
							else if ( d_total == p_total && d_total >=17 )
							{
								System.out.println();
								System.out.println("It's a push!  Nobody wins.");
							}
						}
					
						//This determines that the dealer has busted, therefore the player wins.
						
						else if ( d_total > 21 )
						{
							System.out.println("Dealer's total is " + d_total);	
							chips = addChips(chips, wager);
							System.out.println("Dealer busts.  You win!" );
								
						}
					}
				System.out.println();
				} 
				  
		}
				  
	public int bet(int money)
	{
		// This will check to make sure that the bet is possible with the number of chips left.
		
		Scanner kb = new Scanner(System.in);
		System.out.println("You now have " + money + " chips.  How much would you like to wager?");
		int wager = kb.nextInt();
		
		if ( wager > money )
		{
			System.out.println("You can not bet " + wager + ".  You only have " + money + ".");
			return 0;
		}
		else
			return wager;
		
	}
	
	public int addChips(int money, int bet)
	{
		// Adds chips to the current amount when player wins
		return money + bet;
	}
	
	public int removeChips(int money, int bet)
	{
		// Removes chips from current amount when player wins
		return money - bet;
	}	
	
	
}	