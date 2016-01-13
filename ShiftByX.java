/**
 * Megha Madan
 * October 14, 2014
 * Program that shifts an entered string to the right by an amount X.
 */

package assignment5;

import java.util.Scanner;
public class ShiftByX {

	//program that uses the shift method created earlier but instead implements the method various times according to user input
	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Enter the string you want to be shifted");
		String enteredString = input.nextLine();
		
		//new part of the program that asks user how many characters it wants the string shifted over
		System.out.println("By how many characters do you want it shifted?");
		int shiftBy = input.nextInt();
		
		//for loop helps shift the string as many times as indicated by the user (shiftBy)
		for (int i = 0; i < shiftBy; i++){
			enteredString = shift(enteredString);
		}
		
		System.out.println("Your shifted text is: " + enteredString);
	}

	
	/**
	 * shift method 
	 * Converts a string to an array of characters and then shifts it to the right by one character
	 * Same method used in program ShiftByOne
	 * @param word is the string that will be shifted
	 * @return is the shifted array of letters converted back to a string
	 */
	public static String shift ( String word){
		
		char [] enteredLetters = word.toCharArray();
		char [] shiftedLetters = new char [enteredLetters.length];
		
		shiftedLetters[0] = enteredLetters[enteredLetters.length -1];
		
		for(int i = 1; i < enteredLetters.length; i++){
				shiftedLetters[i] = enteredLetters[i-1];
			}
	
	String shiftedWords = new String (shiftedLetters);
	
	return shiftedWords;
	}
}
