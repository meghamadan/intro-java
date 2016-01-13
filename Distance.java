//Megha Madan
//September 11,2014
//Distance of two points assignment
//Program that prompts user to input two points and displays the distance between them.

import java.util.Scanner;
//Used class Scanner that provides a way to read input from console.

public class Distance {
	public static void main (String args []){
		
	Scanner input = new Scanner (System.in);
	
	
	//Prompt the user to enter input of point 1 and point 2.
	System.out.println("What is the x of point 1?");
	double xPoint1 = input.nextDouble();
	
	System.out.println("What is the y of point 1?");
	double yPoint1 = input.nextDouble();
	
	System.out.println("What is the x of point 2?");
	double xPoint2 = input.nextDouble();
	
	System.out.println("What is the y of point 2?");
	double yPoint2 = input.nextDouble();
	
	//Compute distance between the two points using distance formula.
	double DistanceOfTwoPoints = Math.sqrt(((xPoint2 - xPoint1) * (xPoint2 - xPoint1)) + ((yPoint2 - yPoint1) * (yPoint2 - yPoint1)));
	//Used method to square by multiplying values by themselves.
	
	System.out.println("The distance between the two points is " + DistanceOfTwoPoints);
	
	}
}
