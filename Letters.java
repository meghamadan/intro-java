//Megha Madan
//September 15, 2014
//Program that determines whether single character input is a vowel, consonant, or not a letter.

import java.util.Scanner;

public class Letters {
	public static void main (String args []){
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Please enter a single character: ");
		//Read character from first letter of string.
		String s = input.nextLine();
		char ch = s.charAt(0);
		{
			//page 128 from textbook- helps check if input is between "A" and "Z" OR "a" and "z"
			if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
			{
				//if else statement (between vowels and consonants) nested inside
				//another if else statement (between letters and everything else)
				if (ch == 'a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
				{
					System.out.println("This is a vowel.");
				}
				else
				{
					System.out.println("This is a consonant.");
				}
			}
			else
			{
				System.out.println("This is not a letter.");
			}
		}
		
			
		
	}
}
