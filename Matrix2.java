/**
 * @author Megha
 *Class that encapsulates data of a 2 Dimensional Array (int [] [] matrix, int rows, int columns). Includes methods horizontal/vertical flip, transpose, add, and multiply.
 */
public class Matrix {
	
	private int [] [] matrix;
	private int rows;
	private int columns;


	
	public Matrix (int rows, int columns){
		
		//validate the amount of rows and columns the creator of the object chooses
		if(rows > 5){
			this.rows = 5;
		}
		else if(rows < 1){
			this.rows = 1;
		}
		else{
			this.rows = rows;
		}
		
		if(columns > 5){
			this.columns = 5;
		}
		else if(columns < 1){
			this.columns = 1;
		}
		else{
			this.columns = columns;
		}
		
		//create a new 2D Array with the verified amount of rows and columns
		matrix = new int [this.rows] [this.columns];
		
		for(int r = 0; r < this.rows; r++){
			
			for(int c = 0; c < this.columns; c++){ //this cycles through 0 to columnNumber for each row until it reaches the last row (rowNumber)
				
				matrix[r] [c] = ( -10 + (int)(Math.random()*21)); // fill with random numbers between -10 and 10 into each space of the array
			}
		}
	}
	
	/**
	 * @return get method that returns the amount of rows
	 */
	public int getNumOfRows(){
		return rows;
	}
	
	/**
	 * @return get method that returns the amount of columns
	 */
	public int getNumOfColumns(){
		return columns;
	}
	
	/**
	 * Method replaces original matrix with a horizontally flipped matrix.
	 */
	public void horizontalFlip(){
		
		//create new array that will hold the horizontally flipped matrix
		int [] [] hFlippedMatrix = new int [rows] [columns];
		
		for(int r = 0; r < rows; r++){
			
			for(int c = 0; c < columns; c++){
				
				hFlippedMatrix [r] [columns - c -1] = matrix [r] [c];//this algorithm flips each row
			}
		}
		
		//this changes the reference of matrix to hFlippedMatrix which changes the data of matrix
		matrix = hFlippedMatrix;
	}
	
	/**
	 * Method that is exactly same as horizontalFlip aside from the index it changes
	 */
	public void verticalFlip(){
		
		int [] [] vFlippedMatrix = new int [rows] [columns];
		
		for(int r = 0; r < rows; r++){
			
			for(int c = 0; c < columns; c++){
				
				vFlippedMatrix [rows - r - 1] [c] = matrix [r] [c]; //instead of modifying the column index, we modify the row index of the 2D array which vertically flips each column
			}
		}
		
		matrix = vFlippedMatrix;
	}
	
	/**
	 * This method switches the rows and columns of the original matrix - transpose
	 */
	public void transpose(){
	
	//first switch the values of rows and columns
	int temp = rows;
	rows = columns;
	columns = temp;
	
	//this matrix will hold the new transposed matrix
	int [] [] tempMatrix = new int [rows] [columns];
	
	//take the [c] [r] of the original matrix for each normal slot ([r] [c]) of the original matrix
	for(int r = 0; r < rows; r++){
		for(int c = 0; c < columns; c++){
			tempMatrix [r] [c] = matrix [c] [r];
		}
	
	}
	
	//then because we need to replace the original matrix with the transposed one, we first must change the amount of rows and columns for matrix
	//this will erase the original data, but we can point matrix to tempMatrix which holds the original data which is now transposed
	matrix = new int [rows] [columns];
	matrix = tempMatrix;
	}
	
	
	/**
	 * This method first checks if the matrix and Matrix2 parameter are the same size. If they are not the method returns false.
	 * If they are the same size, we add the two together
	 * @param Matrix2 takes in Matrix object as a parameter
	 * @return the two matrix objects added together if they are the same shape
	 */
	public Boolean add(Matrix Matrix2){
		
		//this finds the size of the Matrix2 parameter - decided to use the getMethods created earlier
		int matrix2Rows = Matrix2.getNumOfRows();
		int matrix2Columns = Matrix2.getNumOfColumns();
		
		//for loop to run through each index of the 2D array and add the corresponding value of Matrix 2 to each value of matrix
		if (rows == matrix2Rows && columns == matrix2Columns){
			for(int r = 0; r < rows; r++){
				for(int c = 0; c < columns; c++){
					matrix [r] [c] = matrix [r] [c] + Matrix2.matrix [r] [c]; 
				}
			}
		return true;
		}
		
		else
			return false;
	}

	
	/**
	 * Method that multiplies each data value of the matrix by a certain integer
	 * @param x this is the integer by which we multiply the matrix
	 */
	public void multiply(int x){
		
		for(int r = 0; r < rows; r++){
			for(int c = 0; c < columns; c++){
				matrix [r] [c] = matrix [r] [c] * x;
			}
		}
	}

	public String toString (){
		
		//This toString method creates a string m and adds each value of the matrix to it. When it reaches the end of each row, it adds a new line to present the matrix in block format
		String m = "";
		
		for(int r = 0; r < rows; r++){
			
			for(int c=0; c < columns; c++){
				
				//%5s creates space in between each of the numbers to align each column
				m = m + String.format("%5s", matrix[r][c]);
			}
			m = m + "\n";
		}
		return m;//returns the final string
	}


}
