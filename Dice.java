//Megha Madan
//September 14, 2014
//Program that rolls a dice 100,000 times and lists the percentage of times each number (1-6) was rolled.

public class Dice {
	public static void main (String args []){
		int i;
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;
		
		//for loop to run random number generator 100,000 times - named this diceRoll
		for(i=0;i<100000;i++){
			int diceRoll = ((int)(1+Math.random()*6));
			//if else statement to add up how many times each number is rolled.	
			if (diceRoll == 1)
			{
				one = one + 1;
			}
			else if (diceRoll == 2)
			{
				two = two + 1;
			}
			else if (diceRoll == 3)
			{
				three = three + 1;
			}
			else if (diceRoll == 4)
			{
				four = four + 1;
			}
			else if (diceRoll == 5)
			{
				five = five + 1;
			}
			else
			{
				six = six +1;
			}
			}
		//%.4f formats the output to show 4 decimal places.
		//%% formats the output to show a percent sign because the percent sign alone has its own meaning.
		System.out.printf("1 was rolled %.4f%% of the times \n", one/1000.0);
		System.out.printf("2 was rolled %.4f%% of the times \n", two/1000.0);
		System.out.printf("3 was rolled %.4f%% of the times \n", three/1000.0);
		System.out.printf("4 was rolled %.4f%% of the times \n", four/1000.0);
		System.out.printf("5 was rolled %.4f%% of the times \n", five/1000.0);
		System.out.printf("6 was rolled %.4f%% of the times \n", six/1000.0);
		}

	}
