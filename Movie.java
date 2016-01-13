/**
 * @author Megha
 * November 6, 2014
 * This class represents a movie's title, duration, release date, and rating
 */


public class Movie {
	
	private String title;
	private int duration;
	private int year;
	private double rating;
	
	//default constructor - 0 minutes long - year 1900 - 0.0 rating
	public Movie(){
		this(" ", 0, 1900, 0.0);
	}
	
	//constructor that has the three specified parameters of title, duration, and year
	public Movie(String title, int duration, int year){
		this(title, duration, year, 0.0);
	}
	
	//constructor with all four parameters
	public Movie(String title, int duration, int year, double rating){
		this.title = title;
		this.duration = duration;
		this.year = year;
		if (rating >= 0.0 && rating <= 4.0)
			this.rating = rating;
	}
	
	//title getter and setter
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	//duration getter and setter
	public int getDuration(){
		return duration;
	}
	
	public void setDuration(int duration){
		this.duration = duration;
	}
	
	//year getter and setter
	public int getYear(){
		return year;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	//rating getter and setter
	public double getRating(){
		return rating;
	}
	
	public void setRating(double rating){
		if (rating >= 0.0 && rating <= 4.0)
			this.rating = rating;
	}
	
	//to string method which prints out each Movie string with 40 characters for title, 10 for minutes and release date, and 2 for rating
	public String toString() {
		return String.format( "Movie Title: %-40s Running Time: %-10d Release Date: %-10d Rating: %2.1f", 
				title, duration, year, rating);
		
	}
}
