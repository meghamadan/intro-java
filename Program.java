/**
 * @author Megha Madan
 * November 8, 2014
 * Program that reads in a file of a list of movies and performs different functions
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Program {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//create a new Inventory object that represents an inventory of movies on netflix
		Inventory movieList = new Inventory();
		
		//create new file object using the 1st command line argument
		File fileMovies = new File (args[0]);
		
		//first make sure the file exists and can be read
		if (!fileMovies.exists() || !fileMovies.canRead() ) {
			System.err.printf("ERROR: cannot read file %s.\n\n", args[0]);
			System.exit(1);
		}
		//if so, we create a scanner object to read the file
		Scanner inMovies = new Scanner ( fileMovies );
		
		//create three new String arrayLists to read the input text file
		ArrayList<String> titles = new ArrayList<String> ();
		ArrayList<String> yearsReleased = new ArrayList<String> ();
		ArrayList<String> ratings = new ArrayList<String> ();
		
		//continue reading the file as long as there is text
		while (inMovies.hasNext()) {
			//create a string that represents each line of text which represents one movie
			String line = inMovies.nextLine();
			//split this string into equal parts according to the hyphens and place it in an array
			String [] info  = line.split("-");
			
			//trim each portion of the array we will use (the 2nd index represents the duration which we ignore)
			info[0] = info[0].trim();
			info[1] = info[1].trim();
			info[3] = info[3].trim();
			
			//add the string representations of the movie data into its appropriate string arrayList
			titles.add(info[0]);
			yearsReleased.add(info[1]);
			ratings.add(info[3]);
		}
		//close the input file
		inMovies.close();
		
		//for loop to run through each movie data representation of each ArrayList
		//parse the integer and double string representations of yearReleased and rating
		//finally, add these to the inventory using add method(which will also create the Movie object if it is not present in the list
		for(int i = 0; i< titles.size(); i++){
			int yearReleased = Integer.parseInt(yearsReleased.get(i));
			double rating = Double.parseDouble(ratings.get(i));
			movieList.add(titles.get(i), yearReleased, rating);
		}
		
		//following copied from the assignment...
		movieList.add("Bears", 2014, 3.5);
		movieList.add("Star Wars - A New Hope", 1977, 3.8);
		movieList.add("Casablanca", 1942, 3.9);
		movieList.add("Duck Soup", 1933, 3.75);
		
		System.out.println(movieList.toString());
		
		movieList.add("Casablanca", 1942, 3.9);
		
		System.out.println(movieList.toString());
		
		movieList.add("Bears", 2050, 3.5);
		
		System.out.println(movieList.toString());
		
		movieList.remove("The Nightmare Before Christmas", 1993);
		
		System.out.println(movieList.toString());
		
		movieList.remove("Duck Soup", 1933);
		
		System.out.println(movieList.toString());
	}
}
