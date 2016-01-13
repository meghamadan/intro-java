/**
 * Megha Madan
 * October 10th, 2014
 * Program that shifts a string entered by the user by one letter. 
 * Takes the last letter of the string and reprints the string with that letter first.
 */

package assignment5;
import java.util.Scanner;

public class ShiftByOne {
	
	/**
	 * shift method 
	 * Converts a string to an array of characters and then shifts it to the right by one character
	 * @param word is the string that will be converted
	 * @return shiftedWords is the shifted array of letters converted back to a string
	 */
	
	public static String shift (String word){
		
		char [] enteredLetters = word.toCharArray();
		char [] shiftedLetters = new char [enteredLetters.length];
		
		//set the first letter of the shiftedLetters equal to the last letter of the enteredLetters array
		shiftedLetters[0] = enteredLetters[enteredLetters.length -1];
		
		//set the second letter of shifted letters(because the first letter has already been set to a value) to the value of entered letters (starting with the first letter) 
		//the for loop will also end before it reaches the last letter of enteredLetters (b/c it starts at i-1) to avoid printing the last letter twice (beginning and end)
		for(int i = 1; i < enteredLetters.length; i++){
				shiftedLetters[i] = enteredLetters[i-1];
			}
	
		String shiftedWords = new String (shiftedLetters);
	
	return shiftedWords;
	}
	
	//program that prompts the user for a string and then implements the shift method
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.println("Enter a string you want shifted");
		String enteredString = input.nextLine();
		
		System.out.println ("Your shifted string is: " + shift(enteredString));
		
		}
	
	}

