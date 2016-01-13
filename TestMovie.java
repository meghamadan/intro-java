/**
 * @author Megha
 * November 6, 2014
 * This program tests the methods of the Movie class created.
 *
 */
public class TestMovie {

	public static void main(String[] args) {
		
		//create list of 9 movies. Any title is accepted. If ratings are missing or they are not between 0.0 and 4.0  the default rating is 0.0
		//The year and duration are also accepted as any number
		Movie [] listOfMovies = new Movie [9];
		
		listOfMovies [0] = new Movie ("Ratatoullie", 111, 2007, 3.8);
		listOfMovies [1] = new Movie ("Toy Story", 81, 1995, 3.9);
		listOfMovies [2] = new Movie("", 200, 1923);
		listOfMovies [3] = new Movie("The Incredibles", 115, 2004, 3.8);
		listOfMovies [4] = new Movie("Up", 96, 2009, 3.4);
		listOfMovies [5] = new Movie("Brave", 93, 2012, 3.7);
		listOfMovies [6] = new Movie("Spirited Away", 124, 2001, 4.0);
		listOfMovies [7] = new Movie("Despicable Me", 95, 2010, 3.6);
		listOfMovies [8] = new Movie("Harry Potter and the Prisoner of Azkaban", -1, 1000, 5.0);
		
		for(int i = 0; i < listOfMovies.length; i++){
			System.out.println(listOfMovies[i]);
		}
		
		//Print out only the years using the getYear method
		System.out.println("\nOnly list years: ");
		for(int i = 0; i < listOfMovies.length; i++){
			System.out.println(listOfMovies[i].getYear());
		}
		
		//Sort by rating and print using the getRating method
		System.out.println("\nSorted by Rating: ");
		for (int i = 0; i < listOfMovies.length - 1; i++) {
			Movie currentMin = listOfMovies[i];
			int currentMinIndex = i;
			for (int j = i + 1; j < listOfMovies.length; j++) {
				if (currentMin.getRating() < listOfMovies[j].getRating()) {
					currentMin = listOfMovies[j];
					currentMinIndex = j;
				}
			}
			if (currentMinIndex != i) {
				listOfMovies[currentMinIndex] = listOfMovies[i];
				listOfMovies[i] = currentMin ;
			}
		}
		for(int i = 0; i < listOfMovies.length; i++){
			System.out.println(listOfMovies[i]);
		}
		
		//Set all of the ratings to random numbers between 0.0 and 4.0 using the setRating method and print
		System.out.println("\nRandom ratings: ");
		for(int i = 0; i < listOfMovies.length; i++){
			double randomRating = 0.0 + (double)(Math.random()*4.0);
			listOfMovies[i].setRating(randomRating);
			System.out.println(listOfMovies[i]);
		}
		
		//set all of the release dates to 2000 using the setYear method
		System.out.println("\nEverything released in 2000: ");
		for(int i = 0; i < listOfMovies.length; i++){
			int year2000 = 2000;
			listOfMovies[i].setYear(year2000);
			System.out.println(listOfMovies[i]);
		}
		
		
		//set all of the titles to "Random Movie: using the setTitle method
		System.out.println("\nRandom Movies: ");
		for(int i = 0; i < listOfMovies.length; i++){
			String random = "Random Movie";
			listOfMovies[i].setTitle(random);
			System.out.println(listOfMovies[i]);
		}
		
		//check to see if all the titles were changed to Random Title using getTitle method
		System.out.println("\nCheck to see if all titles are 'Random Movie': ");
		for(int i = 0; i < listOfMovies.length; i++){
			String title = listOfMovies[i].getTitle();
			if(title == "Random Movie"){
				System.out.println("success");
			}
			else{
				System.out.println("fail");
			}
		}
		
		//setDuration and getDuration to print 200 9 times
		System.out.println("\n200 printed 9 times");
		for(int i = 0; i < listOfMovies.length; i++){
			int duration = 200;
			listOfMovies[i].setDuration(duration);
			System.out.println(listOfMovies[i].getDuration());
		}
	}
}
