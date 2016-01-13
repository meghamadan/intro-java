import java.util.ArrayList;

/**
 * @author Megha Madan
 * November 8, 2014
 * class that represents a Netflix inventory and uses add, remove, and toString method to adjust it
 */

public class Inventory {
	
	//data field that represents the inventory as an arrayList
	private ArrayList<Movie> list = new ArrayList<Movie>();
	
	//this method serves two purposes:
	// 1. adds movies to the list by increasing their quantity and updating rating if it exists
	// 2. creates movie object and adds it to the list if it does not exist
	public void add(String title, int yearReleased, double rating){
		//try/catch to catch and IllegalArgumentExceptions from the movie class
		try{
			//for loop which will go through all of the movies to see if the title (equals method) and year given match any of the existing movies 
			for(int i = 1; i < list.size(); i++){
				String s = list.get(i).getTitle();
				int y = list.get(i).getYearReleased();
				
				//if it does exist, it will update the quantity by 1 and override the existing rating with the new one
				if(s.equals(title) && y == yearReleased){
					int q = list.get(i).getQuantity();
					list.get(i).setQuantity(q+1);
					list.get(i).setRating(rating);
					//if the movie is found, return prevents from creating a new movie object of one that already exists
					return;
				}
			}
			//if no same movie is found, create one and add to the list
			Movie One = new Movie(title, yearReleased, rating);
			list.add(One);	
		}
		//do nothing if an IllegalArgumentException is found
		catch(IllegalArgumentException ex){}
	}
	
	//uses the same method as add method to remove a movie from the list
	public void remove(String title, int yearReleased){
		
		for(int i = 1; i < list.size(); i++){
			String s = list.get(i).getTitle();
			int y = list.get(i).getYearReleased();
		
			if(s.equals(title) && y == yearReleased){
				int q = list.get(i).getQuantity();
				//decreases quantity by one and if the quantity goes below 0, then it is removed completely
				list.get(i).setQuantity(q-1);
					if(list.get(i).getQuantity() <= 0)
						list.remove(i);
			}
		}
	}
	
	//uses the existing toString method from the Movie class
	public String toString(){
		for(int i = 0; i < list.size(); i++){
			//println to put each movie on a new line
			System.out.println(list.get(i).toString());
		}
		return "";
		
	}
		
		
	
	
}
