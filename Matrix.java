/**
 * @author Megha Madan
 * October 23, 2014
 * Program that asks user for the size of a multidimensional (2D) array called matrix that is then transformed in various ways as the user chooses.
 */
import java.util.*;
import java.math.*;
public class Matrix {
	public static void main(String [] args) {

		Scanner input = new Scanner (System.in);
		
		System.out.println("How many rows would you like in your matrix?"); //get amount of rows and columns from user and print an error if they are not between 1 and 5
			int rowNumber = input.nextInt();
		
		System.out.println("How many columns would you like in your matrix?");
			int columnNumber = input.nextInt();
		
		if((rowNumber < 1 || rowNumber > 5) || (columnNumber < 1 || columnNumber > 5)){
			System.out.println("Oh no! We currently only accept row and column numbers between 1 and 5. Please start over.");
			return;
		}
		
		int [] [] userMatrix = new int [rowNumber] [columnNumber]; //set up 2D array with user entered numbers as the length
		
		for(int r=0; r < rowNumber; r++){
			
			for(int c=0; c < columnNumber; c++){ //this cycles through 0 to columnNumber for each row until it reaches the last row (rowNumber)
				
				userMatrix[r] [c] = ( -10 + (int)(Math.random()*21)); // fill with random numbers between -10 and 10 into each space of the array
			}
		}
		System.out.println("\nThis is your random matrix:\n");
		printMatrix(userMatrix); //print the matrix and ask user which method they would like to use to implement on their matrix
		
		System.out.print("\nWhich of the following would you like to do?\n\n");
	
		//name the options as a String called menu
		String menu = "Press H to flip your matrix horizontally\nPress V to flip your matrix vertically\nPress T to transpose your matrix\nPress R to find the maximum value in each row\nPress C to find the sum of each column\nPress Q to quit this amazing program :(";
		System.out.println(menu);
		
		String userAnswer = input.next(); //Create string representing user input and name a character as the first index of the string
		char ch = userAnswer.charAt(0);
		
		while(ch != 'Q' && ch != 'q'){ // use && operator to make sure the user does not choose to quit the program (q and Q)
			
			if (ch == 'H' || ch == 'h'){ //use || operator to recognize both upper case and lower case input letters
				printMatrix(horizontalFlip(userMatrix));
			}
			else if(ch == 'V' || ch == 'v'){
				printMatrix(verticalFlip(userMatrix));
			}
			else if(ch == 'T' || ch == 't'){
				printMatrix(transpose(userMatrix));
			}
			else if(ch == 'R' || ch == 'r'){
				
				for(int i = 0; i < rowNumber; i++){ //use a for loop to print out a 1D array as the printMatrix method only prints out 2D arrays and use %7d format to match the matrix
					System.out.printf("%7d", rowMax(userMatrix)[i]);
				}
			}
			else if(ch == 'C' || ch == 'c'){
				for(int i = 0; i < columnNumber; i++){
					System.out.printf("%7d", columnSum(userMatrix)[i]);
				}
			}
			else{
				System.out.println("That was not one of the options."); //if none of the letters are entered, they are asked to try again
			}
			//after completing  transformation, the menu is shown again and it takes in another user input as the new 'ch' that will be tested in the if-else statement
			System.out.println("\nTry another option!\n\n" + menu);
			String nextUserAnswer = input.next();
			ch = nextUserAnswer.charAt(0);
		}
	}	// end main
	
	/**
	 * @param matrix takes in a matrix as a parameter and uses two for loops to run through each row separately meanwhile going through each column space of that row
	 * for each value in the matrix, it prints out using printf() which aligns the number using %7d creating a width of at least 7 for each integer output for a more spaced out matrix
	 */
	public static void printMatrix (int [] [] matrix){
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				System.out.printf("%7d", matrix[i][j] );
			}
			System.out.print("\n");
		}
		
	}

	/**
	 * @param matrix method takes in a 2D array
	 * @return the horizontally flipped matrix
	 * This method runs through the 2D array similar to the printMatrix method. 
	 * While focusing on each column, the method switches the current value of 'matrix' equal to the value at location 'matrix[0].length - c - 1'
	 * So if c = 1 and matrix[0].length = 4, when 'matrix is at r=0 and c=0, this value is switched with 4-0-1 = 3 which will flip the row (horizontal flip)
	 */
	public static int [] [] horizontalFlip (int [] [] matrix){
		
		int hFlippedMatrix [] [] = new int [matrix.length] [matrix[0].length];

		for(int r=0; r < matrix.length; r++){
				
				for(int c = 0; c < matrix[0].length; c++){
					
						hFlippedMatrix [r] [matrix[0].length - c - 1] = matrix[r] [c];
				}
			}
		return hFlippedMatrix;
	}
	
	/**
	 * @param matrix takes in a 2D array
	 * @return the vertically flipped matrix
	 * This method runs through 'matrix' using the two for loops, and for each value of 'matrix' the column value is switched to the value in the same column bet the last row
	 * this flips each value of each row to the opposite (matrix.length - r -1) value in the same column which vertically flips the matrix
	 */
	public static int [] [] verticalFlip (int [] [] matrix){
		
		int vFlippedMatrix [] [] = new int [matrix.length] [matrix[0].length];
		
		for (int r = 0; r < matrix.length; r++){
			for (int c = 0; c < matrix[0].length; c++){
				vFlippedMatrix [r][c] = matrix [matrix.length - r - 1] [c];
			}
		}
	return vFlippedMatrix;
	}

	/**
	 * @param matrix takes in a 2D array
	 * @return the transposed matrix
	 * This method switches the rows for columns, so now the length of rows then becomes the length of columns and vice versa
	 * However, when setting each value of 'transposedMatrix [r] [c]', the value of 'matrix' should be switched, so: 'matrix [c] [r]
	 * This is what switches the columns for rows
	 */
	public static int [] [] transpose (int [] [] matrix){
		
		int transposedMatrix [] [] = new int [matrix[0].length] [matrix.length];
		
		for(int r = 0; r < matrix[0].length; r++){
			for(int c = 0; c < matrix.length; c++){
				transposedMatrix [r] [c] = matrix [c] [r];
			}
		}
		return transposedMatrix;
	}
		
	/**
	 * @param matrix takes in a 2D array
	 * @return 1D array with the maximum number of each row
	 * This method first sets the max as index [0] [0] of 'matrix' and checks if any number in that row is larger (within the inner for loop, so it resets when moving to next row)
	 * If there is a larger number, the max is reset to that number. 
	 * This process also completely resets when moving to the next row (when moving out of inner loop) by setting max to 'matrix [r] [0]
	 */
	public static int[] rowMax (int [] [] matrix){
		
		int [] rowMaxArray = new int [matrix.length];
		int max = matrix [0] [0];
		
		for(int r = 0; r < matrix.length; r++){
		
			for(int c = 0; c < matrix[0].length; c++){
				
				if (matrix [r] [c] >= max){
					max = matrix [r] [c];
				}
				else
					continue;
			}
			rowMaxArray [r] = max;
			max = matrix [r] [0];
		}
		return rowMaxArray;
	}
		
	/**
	 * @param matrix takes in a 2D array
	 * @return the 1D array with the sum of each column
	 * This method works inside the for loop that runs through each column, so each column value is added to its subsequent row sum in the array
	 */
	public static int [] columnSum (int [] [] matrix){
		
		int [] columnSumArray = new int [matrix[0].length];
		
		for(int r = 0; r < matrix.length; r++){
			
			for(int c = 0; c < matrix[0].length; c++){
				columnSumArray [c] = columnSumArray [c] + matrix [r] [c];
			}
		}
		return columnSumArray;
	}
	
}
