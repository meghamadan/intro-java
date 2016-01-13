/**
 * Megha Madan
 * October 5, 2014
 *  Program that determines whether a list of 10 numbers entered by the user are sorted from smallest to largest.
 */

import java.util.Scanner;

public class IsSorted {
	public static void main(String[] args) {
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("Enter 10 values: ");
	
		//initialize an array, userListOfNumbers, and take the numbers from user input and put in the array.
		int [] userListOfNumbers = new int [10];
		for (int i = 0; i < 10; i++){
		userListOfNumbers[i] = input.nextInt();
		}
		
		//use another for loop to run through the sequence of numbers and determine if the number is greater than the one before.
		for (int i = 0; i < 9; i++){
			
			if ((userListOfNumbers[i+1] >= userListOfNumbers[i])){
	
				//if the number is smaller than the next, use if else statement to continue the loop until it reaches the end of the array.
				if(i < 8){
					continue;
				}
				
				// once it reaches the end of the array, if the number is still smaller than the next, it prints that it is sorted.
				if (i == 8){
				System.out.println("Your list is sorted");
				}
			}
			
				//if at any point the number is less than the next, it will break out of the for loop and print that it is NOT sorted.
			else if (userListOfNumbers[i+1] < userListOfNumbers[i]) {
				System.out.println("Your list is NOT sorted");
				break;
				}
			
			}
		}

	}
