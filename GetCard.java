/**Megha Madan
 * September 24, 2014
 * Program that picks a card from a deck of 52 cards. First chooses between Spades, Hearts, Diamonds, and Clubs.
 * Then it chooses between Ace, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, and King.
 */

public class GetCard {

	public static void main(String[] args) {
		
		String suit;
		//Random number generator that picks from 1 to 52.
		int Cardpick = ((int) (1+Math.random()*52));
		
		//Split random number range into four equal parts to assign the random number picked as Spades, Hearts, Diamonds, and Clubs. 
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
		
		
		//After choosing between Spades, Hearts, Diamonds, and Clubs, use if-else statement to determine whether the card is Ace, 1, 2, 3, etc.
		//Use the % operator to match the remainder of each set of suits when divided by 13. So if the remainder is 1, it is Ace. If the remainder is 2 it is 2. Etc.
		String card;
		
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
			card = "4";
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
		System.out.println (card + " of " + suit);
	}

}
	