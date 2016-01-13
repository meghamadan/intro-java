//Megha Madan
//September 16, 2014
//Program that takes input and, according to whether it is even or odd, performs different
//arithmetic functions and creates a sequence of numbers according to the previous number.

import java.util.Scanner;

public class Sequence {

	public static void main(String[] args) {
		int i;
		//Takes input n from the user.
		Scanner input = new Scanner (System.in);
		System.out.println("Please enter a single positive integer: ");
	
		int n = input.nextInt();
		//Used a for loop to create the sequence of numbers according to n.
		for (i=0;i<199;i++) {
			//Formatted print to include a comma and space.
			System.out.printf("%d, ",n);
			//Used an if else statement to differentiate between even and odd input.
			if (n % 2 == 0) 
			{
				n = n/2;
			}
			else
			{
				n = ((n * 3) + 1);
			}
		
		}
	}
}
//The sequence starts to form a pattern of 4,2,1. For larger numbers (< 300) I made the 
//program show the first 200 numbers in the sequence which also showed the pattern of 4,2,1.
