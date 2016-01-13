/**
 * Megha Madan
 * October 7, 2014
 * Program that takes in a string and prints it backwards using a method called "reverse".
 */

import java.util.Scanner;

public class ReverseString {
	public static String reverse (String textToReverse){
		
		//initialize a string called that will hold the reversed string inside the method.
		String reverseListMethod = "";
		
		//used a for loop to pick out each character in the list given by the user (textToReverse) starting from the last letter
		for (int i = textToReverse.length() - 1; i>=0; --i){
			
				//concatenate the character (converted to string) picked out in the for loop to the string that holds the reversed input
				reverseListMethod = reverseListMethod + Character.toString(textToReverse.charAt(i));
		}
			//the method returns the reversed input
			return reverseListMethod;
		}
	
	
	public static void main(String[] args) {

		Scanner in = new Scanner (System.in);
		
		//in the program, ask the user to enter a string and name it enteredString
		System.out.println("Enter a string: ");
		
		String enteredString = in.nextLine();
		
		//then print out enteredString backwards using reverse method
		System.out.println("Your string in reverse is: " + reverse(enteredString));
		
		}
	}
