import java.util.Scanner;
import java.util.Random;

public class Blackjack
{
	public static void main( String[] args )
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();
		
		int card1, card2, hitcard, total1=0, total2=0, wager, chips = 100;
		
		System.out.println("Welcome to Mitchell's blackjack program!");
		
		do
		{	
		
		
		card1 = 2 + r.nextInt(10);
		card2 = 2 + r.nextInt(10);
		hitcard = 2 + r.nextInt(10);
		total1 = card1 + card2;
		
		System.out.println();
		System.out.print("You have " + chips + " in chips.  How much would you like to wager? ");
		wager = kb.nextInt();
		System.out.println();
		System.out.println("You get a " + cardSuit(card1) + " and a " + cardSuit(card2) + ".");
		System.out.println("Your total is " + total1);
		System.out.println();
		
		card1 = 2 + r.nextInt(10);
		card2 = 2 + r.nextInt(10);
		
		System.out.println("The dealer has a " + cardSuit(card1) + " showing, and a hidden card.");
		System.out.println("His total is hidden, too");		
		System.out.println();
		
		System.out.println("Would you like to \"hit\" or \"stay\"?");
		String hit = kb.next();
		
		if ( chips < wager ) 
			{
			System.out.println("You don't have enough chips to play!  Come back later.");
			break;
			}
			
			else
			{
				if ( total1 > 21 )
					System.out.println("Error!  You can't bust on the flop!");
		
				else
				{
			
				while ( total1 <= 21 && hit.equals("hit") )
				{
					hitcard = 2 + r.nextInt(10);
					System.out.println("You drew a " + cardSuit(hitcard));
					total1 = total1 + hitcard;
					if ( total1 < 21 )
					{	
						System.out.println("Your total is " + total1 );
						System.out.println();
						System.out.println("Would you like to \"hit\" or \"stay\"?");
						hit = kb.next();
					}
					else 
					{	
						chips = chips - wager;
						System.out.println("You have busted.  You lose! You now have " + chips + " chips.");
					}
				}
		
				if ( total1 <= 21 )
				{
					total2 = card1 + card2;
					System.out.println();
					System.out.println("Okay, dealer's turn.");
					System.out.println("His hidden card was a " + cardSuit(card2));
					System.out.println("His total was " + total2);
					System.out.println();
			
					if ( total2 >= 17 && total2 < 21 )
					{
						System.out.println("Dealer stays.");
						System.out.println("Dealer total is " + total2);
						System.out.println("Your total is " + total1);
						
						if ( total1 > total2)
						{	
							chips = chips + wager;
							System.out.println("You win! You now have " + chips + " chips.");
						}	
						else if ( total2 > total1 )
						{
							chips = chips - wager;
							System.out.println("You lose!  You now have " + chips + "chips.");
						}
						else 
							System.out.println("It's a push!  Nobody wins.  You still have " + chips + " chips.");
					}
			
					else
					{		
			
						while ( total2 < 17 )
						{
							System.out.println("Dealer hits");
							hitcard = 2 + r.nextInt(10);
							System.out.println("Dealer drew a " + cardSuit(hitcard) );
							total2 = total2 + hitcard;
				
							if ( total2 <= 21 && total2 >= 17)
							{
								System.out.println("Dealer stays.");
								System.out.println();
								System.out.println("Dealer total is " + total2);
								System.out.println("Your total is " + total1);
							
								if ( total1 > total2 && total2 >= 17 )
								{
									System.out.println();
									chips = chips + wager;
									System.out.println("You win!  You now have " + chips + " chips.");
									
								}
								else if ( total2 > total1 && total2 >=17 )
								{
									System.out.println();
									chips = chips - wager;
									System.out.println("You lose! You now have " + chips + " chips.");
									
								}
								else if ( total2 == total1 && total2 >=17 )
								{
									System.out.println();
									System.out.println("It's a push!  Nobody wins.  You still have " + chips + " chips.");
								}
							}
					
							else if ( total2 > 21 )
							{
								System.out.println("Dealer's total is " + total2);	
								chips = chips + wager;
								System.out.println("Dealer busts.  You win! You now have " + chips + " chips." );
								
							}
						}
					  } 
					}
				}
				
			 } 
			} while ( chips > 0  );
				System.out.println();	
	}
	
	public static String cardSuit(int card1)
	{
		Random r = new Random();

		String suit1="";
		int suit;
		
		if ( card1 == 2 )
		{
			suit = 1 + r.nextInt(4);
				if ( suit == 1 )
					suit1 = "2 of hearts";
				else if ( suit == 2 )
					suit1 = "2 of spades";
				else if ( suit == 3 )
					suit1 = "2 of diamonds";
				else 
					suit1 = "2 of clubs";
		}
		
		else if ( card1 == 3)
		{
			suit = 1 + r.nextInt(4);
			if ( suit == 1 )
					suit1 = "3 of hearts";
				else if ( suit == 2 )
					suit1 = "3 of spades";
				else if ( suit == 3 )
					suit1 = "3 of diamonds";
				else 
					suit1 = "3 of clubs";
		}
		
		else if ( card1 == 4 )
		{
			suit = 1 + r.nextInt(4);
			if ( suit == 1 )
					suit1 = "4 of hearts";
				else if ( suit == 2 )
					suit1 = "4 of spades";
				else if ( suit == 3 )
					suit1 = "4 of diamonds";
				else 
					suit1 = "4 of clubs";
		}
	
		else if ( card1 == 5 )
		{
			suit = 1 + r.nextInt(4);
			if ( suit == 1 )
					suit1 = "5 of hearts";
				else if ( suit == 2 )
					suit1 = "5 of spades";
				else if ( suit == 3 )
					suit1 = "5 of diamonds";
				else 
					suit1 = "5 of clubs";
		}
		
		else if ( card1 == 6 )
		{
			suit = 1 + r.nextInt(4);
			if ( suit == 1 )
					suit1 = "6 of hearts";
				else if ( suit == 2 )
					suit1 = "6 of spades";
				else if ( suit == 3 )
					suit1 = "6 of diamonds";
				else 
					suit1 = "6 of clubs";
		}
		
		else if ( card1 == 7 )
		{
			suit = 1 + r.nextInt(4);
			if ( suit == 1 )
					suit1 = "7 of hearts";
				else if ( suit == 2 )
					suit1 = "7 of spades";
				else if ( suit == 3 )
					suit1 = "7 of diamonds";
				else 
					suit1 = "7 of clubs";
		}
		
		else if ( card1 == 8 )
		{
			suit = 1 + r.nextInt(4);
			if ( suit == 1 )
					suit1 = "8 of hearts";
				else if ( suit == 2 )
					suit1 = "8 of spades";
				else if ( suit == 3 )
					suit1 = "8 of diamonds";
				else 
					suit1 = "8 of clubs";
		}
		
		else if ( card1 == 9 )
		{
			suit = 1 + r.nextInt(4);
			if ( suit == 1 )
					suit1 = "9 of hearts";
				else if ( suit == 2 )
					suit1 = "9 of spades";
				else if ( suit == 3 )
					suit1 = "9 of diamonds";
				else 
					suit1 = "9 of clubs";
		}
		
		else if ( card1 == 10 )
		{
			suit = 1 + r.nextInt(16);
				if ( suit == 1 )
					suit1 = "10 of hearts";
				else if ( suit == 2 )
					suit1 = "10 of spades";
				else if ( suit == 3 )
					suit1 = "10 of diamonds";
				else if ( suit == 4 )
					suit1 = "10 of clubs";
				else if ( suit == 5 )
					suit1 = "Jack of clubs";
				else if ( suit == 6 )
					suit1 = "Jack of diamonds";
				else if ( suit == 7 )
					suit1 = "Jack of spades";
				else if ( suit == 8 )
					suit1 = "Jack of hearts";
				else if ( suit == 9 )
					suit1 = "Queen of clubs";
				else if ( suit == 10 )
					suit1 = "Queen of diamonds";
				else if ( suit == 11 )
					suit1 = "Queen of spades";
				else if ( suit == 12 )
					suit1 = "Queen of hearts";
				else if ( suit == 13 )
					suit1 = "King of clubs";
				else if ( suit == 14 )
					suit1 = "King of diamonds";
				else if ( suit == 15 )
					suit1 = "King of spades";
				else 
					suit1 = "King of hearts";
					
		}
		
		else if ( card1 == 11 )
		{
			suit = 1 + r.nextInt(4);
			if ( suit == 1 )
				suit1 = "Ace of hearts";
			else if ( suit == 2 )
				suit1 = "Ace of spades";
			else if ( suit == 3 )
				suit1 = "Ace of diamonds";
			else
				suit1 = "Ace of clubs";
		}
		return (suit1);
	}
	
}
				
			
						