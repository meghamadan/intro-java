//Megha Madan
//September 11, 2014
//Future Interest Assignment

import java.util.Scanner;
//Scanner is a class that provides a way to read input from console.

public class Interest {
	public static void main (String args[]) {
	Scanner input = new Scanner (System.in);
	//Prompt the user to enter input of investment amount, annual interest rate, and number of years.
	
	System.out.println("Please enter an investment amount.");
	double investmentAmount = input.nextDouble();
	
	System.out.println("Please enter an annual interest rate.");
	double annualInterestRate = input.nextDouble();
	
	System.out.println("Please enter the number of years of the investment.");
	double numberOfYears = input.nextInt();
	
	double futureInvestmentValue = investmentAmount * Math.pow(1+annualInterestRate,numberOfYears);
	

	System.out.println("Your current invesment amount after " + numberOfYears + " years is " + futureInvestmentValue);
	}
}
