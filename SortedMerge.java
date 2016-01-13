/**
 * Megha Madan
 * October 16, 2014
 * Program that first determines if two arrays from the user are sorted using a method.
 * Then it merges the two lists and puts them in a new array in order from smallest to largest.
 */

package assignment5;

public class SortedMerge {

	public static void main(String[] args) {
	java.util.Scanner input = new java.util.Scanner(System.in);
	
	//initialize two arrays, enteredList1 and enteredList2, and take the numbers from user input and put in the arrays.
	//also find the lengths of both of these lists from user input
	
	//List ONE
	System.out.println("How many numbers are in your 1st List?");
		int list1Length = input.nextInt();
	System.out.println("Enter your 1st List");
	double [] enteredList1 = new double [list1Length];
		for (int i = 0; i < list1Length; i++){
		enteredList1[i] = input.nextDouble();
		}
			//use an if statement to make sure the list is sorted from smallest to largest using the checkIfSorted method created
			//if it is not sorted, it will end the program so the user can start over
			if (checkIfSorted(enteredList1, list1Length) == false){
				System.out.println("Your 1st List is not sorted");
				return;
			}
	//List TWO
	System.out.println("How many numbers are in your 2nd List?");
		int list2Length = input.nextInt();
	System.out.println("Enter your 2nd List");
	double [] enteredList2 = new double [list2Length];
		for (int i = 0; i < list2Length; i++){
		enteredList2[i] = input.nextDouble();
		}	
			if (checkIfSorted(enteredList2, list2Length) == false){
				System.out.println("Your 2nd List is not sorted");
				return;
			}
			
	//finally create a new mergedList array to take in the merged and sorted array found with the merge method below
	double [] mergedList = new double [list1Length + list2Length];
	mergedList = merge(enteredList1, enteredList2);
	
	//print each value of the merged and sorted array using a for loop
	System.out.print("Your merged list is: ");
	for (int i = 0; i < mergedList.length; i++) {
		//adds a comma and a space to all of the numbers except for the last one
		if(i<mergedList.length-1){
			System.out.print(mergedList[i] + ", ");
		}
		else{
			System.out.print(mergedList[i]);
		}
		
	}
	
	}
	

	/**
	 * checkIfSorted method
	 * Method that checks if an array of doubles is sorted using the code from Assignment 4's IsSorted program.
	 * @param listToCheck is the array that is checked to see if it is sorted from smallest to largest 
	 * @param lengthOfList this is the length of the array
	 * @return a true or false where true is sorted and false is not sorted
	 */
	public static Boolean checkIfSorted (double [] listToCheck, int lengthOfList){
		
		Boolean answer = null;
		
		//use for loop to run through the sequence of numbers and determine if the number is greater than the one before.
		for (int i = 0; i < lengthOfList -1; i++){
			
			if ((listToCheck[i+1] >= listToCheck[i])){
		
				//if the number is smaller than the next, use if else statement to continue the loop until it reaches the end of the array.
				if(i < lengthOfList - 2){
					continue;
				}
					
				// once it reaches the end of the array, if the number is still smaller than the next, it prints that it is sorted.
				if (i == lengthOfList -2){
				answer = true;
				}
			}
				
					//if at any point the number is less than the next, it will break out of the for loop and print that it is NOT sorted.
			else if (listToCheck[i+1] < listToCheck[i]) {
				answer = false;
				break;
				}
			}
		return answer;
		}

	
	/**
	 * merge method
	 * This method takes two sorted arrays and merges them into one array making sure it is sorted for each number.
	 * the count (one, two, merged) for each list changes only when the number is put into the mergedSortedArray
	 * once the count reaches the length of either list1 or list2, use another while loop to finish putting the rest of the list into the mergedSortedArray
	 * @param list1 is the first entered list by the user
	 * @param list2 is the second entered list by the user
	 * @return is the final mergedSortedArray
	 */
	public static double [] merge (double [] list1, double [] list2){
		
		double [] mergedSortedArray = new double [list1.length + list2.length];
		
		int one= 0;
		int two = 0;
		int merged = 0;
		

		while (one < list1.length && two < list2.length){
			if(list1[one] < list2[two]){
				mergedSortedArray[merged]=list1[one];
				one++;
			}
			else{
				mergedSortedArray[merged]=list2[two];
				two++;
			}
		merged++;
		}
		while(one < list1.length && merged < mergedSortedArray.length){
			mergedSortedArray[merged] = list1[one];
			one++;
			merged++;
		}
		while(two < list2.length && merged < mergedSortedArray.length){
			mergedSortedArray[merged] = list2[two];
			two++;
			merged++;
		}
		
		return mergedSortedArray;
		}
	}


