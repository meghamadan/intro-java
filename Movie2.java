/** @author Megha Madan
 * November 6, 2014
 * This class represents a movie object with title, duration, release date, and rating properties
 */

public class Movie {
	
	private String title;
	private int yearReleased;
	private double rating;
	private int quantity;
	
	//only one constructor with three parameters that throws exceptions if there are invalid inputs
	public Movie(String title, int yearReleased, double rating) throws IllegalArgumentException{
		
		this.title = title;
		this.yearReleased = yearReleased;
		
		
		if (yearReleased >=1870 && yearReleased <= 2014)
			this.yearReleased = yearReleased;
		else
			throw new IllegalArgumentException("Invalid Year");
		
		
		if (rating >= 0.0 && rating <= 4.0)
			this.rating = rating;
		else
			throw new IllegalArgumentException("Invalid Rating");
		
		//sets quantity to 1 when creating a new Movie object
		quantity = 1;
	}
	
	//getQuantity method to use in the add method of the inventory class
	public int getQuantity(){
		return quantity;
	}
	
	//also used for the inventory class add method
	public void setQuantity(int quantity){
		
		if(quantity >= 0)
			this.quantity = quantity;
		else
			throw new IllegalArgumentException("Invalid Quantity");
	}
	
	//following two methods used to compare titles and years released of movies to check if the movie exists in the list
	public String getTitle(){
		return title;
	}
	public int getYearReleased(){
		return yearReleased;
	}
	
	//to override rating when adding a movie
	public void setRating(double x){
		this.rating = x;
	}

	//to string method which prints out each Movie string with 40 characters for title, 10 for minutes and release date, and 2 for rating
	public String toString() {
		return String.format( "Movie Title %-50s (Release Date: %-1d), Rating: %2.1f, # in stock: %-1d ", 
				title, yearReleased, rating, quantity);
		
	}
}
