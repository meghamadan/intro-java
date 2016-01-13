/**
 * @author Megha
 * This program tests the Matrix class by creating various matrices and running different methods on them
 */
public class TestMatrix {

	public static void main(String[] args) {
		
		//created 5 different matrices to test the validation of # of rows/columns
		Matrix one = new Matrix(4, 2);//should be no change
		
		Matrix two = new Matrix(5, 6); //should change to (5, 5)
		
		Matrix three = new Matrix(7, 3);//should change to (5, 3)
		
		Matrix four = new Matrix(-1, 4);//should change to (1, 4)
		
		Matrix five = new Matrix(5, -4);//should change to (5, 1)
		
		System.out.println("(rows, columns) of matrix one: (" + one.getNumOfRows() + ", " + one.getNumOfColumns() + ")");
		
		System.out.println("(rows, columns) of matrix two: (" + two.getNumOfRows() + ", " + two.getNumOfColumns() + ")");
		
		System.out.println("(rows, columns) of matrix three: (" + three.getNumOfRows() + ", " + three.getNumOfColumns() + ")");
		
		System.out.println("(rows, columns) of matrix four: (" + four.getNumOfRows() + ", " + four.getNumOfColumns() + ")");
		
		System.out.println("(rows, columns) of matrix five: (" + five.getNumOfRows() + ", " + five.getNumOfColumns() + ")");
		
		//To visually verify if the transformations work...
		System.out.println("\nBelow I will apply the transformations to Matrix three:");
		
		System.out.println("\nMatrix three: \n" + three.toString());
		
		three.horizontalFlip();
		
		System.out.println("This is the horizontally flipped matrix: \n" + three.toString());
		
		three.verticalFlip();
		
		System.out.println("This is the vertically flipped matrix: \n" + three.toString());
		
		three.transpose();
		
		System.out.println("This is the transposed matrix: \n" + three.toString());
		
		
		//Using the add method
		System.out.println("\nAdding matrix of same size to matrix two : \n");
		
		System.out.println("Matrix two: \n" + two.toString());
		
		Matrix plus = new Matrix(5, 5);
		
		System.out.println("Matrix 'plus': \n" + plus.toString());
		
		//same size: (5,5)
		two.add(plus);
		
		System.out.println("\nMatrix two added with matrix 'plus' : \n" + two.toString());
		
		
		System.out.println("\nAdding matrix of different size to matrix two : \n");
		
		System.out.println("Matrix two: \n" + two.toString());
		
		Matrix noPlus = new Matrix(3,3);
		
		System.out.println("Matrix noPlus: \n" + noPlus.toString());
		
		//two is size (5, 5) whereas plus is (3, 3) so we see that matrix two does not change
		two.add(noPlus);
		
		System.out.println("Matrix two unchanged after running add method with different size matrix: \n" + two.toString());
		
		
		//To verify the multiply method works
		System.out.println("\nMultiplying matrix four by various numbers : \n");
		
		System.out.println("Matrix four: \n" + four.toString());
		
		four.multiply(2);
		
		System.out.println("Matrix four multiplied by 2: \n" + four.toString());
		
		four.multiply(-5);
		
		System.out.println("Matrix four multiplied by -5: \n" + four.toString());
		
		four.multiply(0);
		
		System.out.println("Matrix four multiplied by 0: \n" + four.toString());
		
		
	}
}

