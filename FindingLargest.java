/**
 * Megha Madan
 * October 5th, 2014
 * Program that takes in a sequence of numbers ending with 0 to signal the end of the sequence.
 * It then finds the maximum number in that sequence and prints the number of time it occurs.
 */

import java.util.Scanner;

public class FindingLargest {
	public static void main(String[] args) {
		
		//use Sentinel to control loop and stop at 0
		final int SENTINEL = 0;
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		//ask user to enter numbers ending with 0 to quit
		System.out.println("Enter your numbers ending with a 0");
		
		//initialize variable number to represent the input from the user
		int number;
		number = input.nextInt();
		//maxCount will be used to count how many times the max is entered
		int maxCount = 0;
		//the max and the second largest max will be initialized to the first number of the input
		int max = number;
		int secondMax = number;
		
		//created a do while loop to take in each number input and decide whether it is larger than the next
		do {
			//this if statement will also set secondMax to the previous input value max if it changes
			if (number > max){
				secondMax = max;
				max = number;
				maxCount = ((maxCount - maxCount) + 1);
			}
			//extra else if statement to set input value to secondMax if it is less than the max and also greater than the s
			else if (number < max && number > secondMax){
				secondMax = number;
			}
			
			//this else if statement is here to count the number of times the max occurs
			else if (number == max){
				maxCount = maxCount +1;
			}
			
			//after checking the number, continue the while loop with the next input number as long as it does not equal sentinel (0)
			number = input.nextInt();

		} while (number != SENTINEL);
		
		
		//print out the max, secondMax, and the maxCount
		System.out.println("The largest number is: " + max);
		
		//in case the max only occurs once it will print "time", anything other than once it will print "times"
		if (maxCount == 1){
			System.out.println("It occurs " + maxCount + " time");
		}
		else {
			System.out.println("It occurs " + maxCount + " times");
			
		}
		System.out.println("The second largest number is: " + secondMax);
	}

}
