/**Megha Madan
 * September 25, 2014
 * Program of a simple Blackjack game where Ace = 11 and dealer always draws two new cards when the player asks for a new card.
 */

import java.util.Scanner;

public class Blackjack {
	
	//Method that determines whether a random number between 1 and 52 is Spades, Hearts, Diamonds, or Clubs.
	//and then determines whether the card is Ace, 1, 2, 3, etc.
	public static String GetCard(int Cardpick) {
		
			String suit; 
			//Assign to the string suit using an if-else statement.
			
			if (Cardpick >= 1 && Cardpick <= 13)
			{
				suit = "Spades";
			}
			else if (Cardpick >=14 && Cardpick <= 26)
			{
				suit = "Hearts";
			}
			else if (Cardpick >=27 && Cardpick <= 39)
			{
				suit = "Diamonds";
			}
			else
			{
				suit = "Clubs";
			}
		
			//Use the % operator to match the remainder of each set of suits when divided by 13. 
			//So if the remainder is 1, it is Ace. If the remainder is 2 it is 2. Etc.
			String card;
			int sum = 0;
			
			if (Cardpick % 13 == 1)
			{
				card = "Ace";
			}
			else if (Cardpick % 13 == 2)
			{
				card = "2";
			}
			else if (Cardpick % 13 == 3)
			{
				card = "3";
			}
			else if (Cardpick % 13 == 4)
			{
				card = "4";;
			}
			else if (Cardpick % 13 == 5)
			{
				card = "5";
			}
			else if (Cardpick % 13 == 6)
			{
				card = "6";
			}
			else if (Cardpick % 13 == 7)
			{
				card = "7";
			}
			else if (Cardpick % 13 == 8)
			{
				card = "8";
			}
			else if (Cardpick % 13 == 9)
			{
				card = "9";
			}
			else if (Cardpick % 13 == 10)
			{
				card = "10";
			}
			else if (Cardpick % 13 == 11)
			{
				card = "Jack";
			}
			else if (Cardpick % 13 == 12)
			{
				card = "Queen";
			}
			else
			{
				card = "King";
			}
			
			//Finally print the suit and card string to show which card was picked.
			String CardPicked = card + " of " + suit;
			return CardPicked;
		}
	
	//Method that finds the sum of the value of the cards that were picked in previous method.
	public static int GetCardValue(int Cardpick) {
		
		String card;
		int Score = 0;
		
		if (Cardpick % 13 == 1)
		{
			Score = Score + 11;
		}
		else if (Cardpick % 13 == 2)
		{
			Score = Score + 2;
		}
		else if (Cardpick % 13 == 3)
		{
			Score = Score + 3;
		}
		else if (Cardpick % 13 == 4)
		{
			Score = Score + 4;
		}
		else if (Cardpick % 13 == 5)
		{
			Score = Score + 5;
		}
		else if (Cardpick % 13 == 6)
		{
			Score = Score + 6;
		}
		else if (Cardpick % 13 == 7)
		{
			Score = Score + 7;
		}
		else if (Cardpick % 13 == 8)
		{
			Score = Score + 8;
		}
		else if (Cardpick % 13 == 9)
		{
			Score = Score + 9;
		}
		else if (Cardpick % 13 == 10)
		{
			Score = Score + 10;
		}
		else if (Cardpick % 13 == 11)
		{
			Score = Score + 10;
		}
		else if (Cardpick % 13 == 12)
		{
			Score = Score + 10;
		}
		else
		{
			Score = Score + 10;
		}
		
		return Score;
	}
	
	public static void main (String args []){
		Scanner input = new Scanner (System.in);
		
		//Random number generator that picks from 1 to 52.
		//Simulating two random cards for the user.
		int Cardpick = ((int) (1+Math.random()*52));
		int Cardpick2 = ((int) (1+Math.random()*52)); 
		
		//Calculating Player's score using the GetCardValue method to find the player's score.
		int Score = GetCardValue(Cardpick);
		Score = Score + GetCardValue(Cardpick2);
		
		//Finding and printing the Player's first two cards according to the random numbers using the GetCard method
		System.out.println("Your two cards are: " );
		System.out.println(GetCard(Cardpick));
		System.out.println(GetCard(Cardpick2));
		
		//Same procedure as above applied to the Dealer
		int DealerCardpick = ((int) (1+Math.random()*52));
		int DealerCardpick2 = ((int) (1+Math.random()*52)); 
		
		int DealerScore = GetCardValue(DealerCardpick);
		DealerScore = DealerScore + GetCardValue(DealerCardpick2);
		
		/** Prints the card and score of the dealer to check the program.
		System.out.println("Dealer Cards: " + GetCard(DealerCardpick));
		System.out.println(GetCard(DealerCardpick2));
		System.out.println(DealerScore + "\n");
		*/
		
		//while loop with the condition that as long as neither player busts, the loop body continues.
		while ((Score <= 21) && (DealerScore <= 21)) {
			
			//First we check if the player want another card or wants to "stop"
			System.out.println("Would you like another card?");
			String FirstAnswer = input.nextLine();
			
			//If the player does not want to stop, we pick another card (NextCardpick) and then make sure neither player has bust
			//If neither player bust, we continue the loop.
			if(!FirstAnswer.equalsIgnoreCase("stop")){
				int NextCardpick = ((int) (1+Math.random()*52));
				int NextDealerCardpick = ((int) (1+Math.random()*52));
				
				System.out.println("\nYour card: \n" + GetCard(NextCardpick));
				Score = Score + GetCardValue(NextCardpick);
				System.out.println(Score);
				
				System.out.println("\nDealer\'s Card: \n" + GetCard(NextDealerCardpick));
				DealerScore = DealerScore + GetCardValue(NextDealerCardpick);
				System.out.println(DealerScore);
				
				if ((Score > 21) && (DealerScore > 21)){
					System.out.println("You and the dealer bust! Draw!");
				}
				else if (DealerScore > 21){
						System.out.println("Dealer bust! You win!");
						}
				else if (Score >21){
						System.out.println("Bust! You lose!");;
							}
				}
			
			//If the player does want to stop, we check to see if either player has busted.
			//If one busts the other winse and vice versa.
			else{
				if ((Score == DealerScore) || ((Score > 21) && (DealerScore > 21))){
					System.out.println("Draw!...Play again!");
					break;
				}
				else if (DealerScore > 21){
					System.out.println("You win!");
					break;
				}
				else if (Score >21){
					System.out.println("Dealer wins!");
					break;
				}
				
				//If neither has busted we check to see who's score is higher and the winner is declared.
				else {

					if (Score > DealerScore){
						System.out.println("You win!");
						break;
					}
					else{
						System.out.println("You lose!");
						break;
					}
				}
			}
		}
	}
}
