/**
 * @author Megha Madan
 * November 5, 2014
 * Program that uses a class to create an array of 10 courses and sorts them by the last name of the instructor and by the capacity.
*/

public class OrderedCourses {
	public static void main (String[]args) {
		
	//Create array of Course objects
	Course [] listOfCourses = new Course [10];
	//Fill in listOfCourses array with course info (class name, instructor name, capacity, and course code)
	listOfCourses [0] = new Course("Biology", "Auld", 50, "B677");
	listOfCourses [1] = new Course("Theatre", "Zalis", 25, "T239");
	listOfCourses [2] = new Course("Spanish", "De Cruz", 32, "S332" );
	listOfCourses [3] = new Course("History", "Colonna", 44, "H061");
	listOfCourses [4] = new Course("Calculus", "Tewksbury", 38, "C587");
	listOfCourses [5] = new Course("Politics", "Maloney", 64, "P468");
	listOfCourses [6] = new Course("Economics", "Bowers", 48, "E990");
	listOfCourses [7] = new Course("Computer Science", "Whilton", 34, "C076");
	listOfCourses [8] = new Course("Writing", "Panizon", 24, "W328");
	listOfCourses [9] = new Course("Chemistry", "Maloney", 54 , "C923");
	
	
	System.out.println("List of courses sorted by Instructor's Last name: \n");
	//print the list of courses modified by the sortInstructor method using a for loop
	sortInstructor(listOfCourses);
		for(int k = 0; k < listOfCourses.length; k++){
			System.out.println(listOfCourses[k].toString());
		}
	
	System.out.println("\n\nList of courses sorted by capacity\n");
	//print the list of courses modified by the sortCapacity method using a for loop
	sortCapacity(listOfCourses);
		for(int k = 0; k < listOfCourses.length; k++){
			System.out.println(listOfCourses[k].toString());
		}
		
	System.out.println("\n\nList of courses sorted by instructor and capacity: \n");
	//same as above except I use the third method which sorts by instructor and capacity
	thirdSort(listOfCourses);
		for(int k = 0; k < listOfCourses.length; k++){
			System.out.println(listOfCourses[k].toString());
		}
	}
	

	/**
	 * @param listSortInstructor list (array) of course name, instructor last name, capacity, and course code
	 * @return the array of course info sorted by instructor's last name
	 */
	public static Course[] sortInstructor(Course [] list){
	
		//using the selection sort algorithm
		for(int i = 0; i < list.length-1; i++){
			//find the minimum in list
			Course minInstructor = list[i];
			int minInstructorIndex = i;
			
			for(int j = i+1; j < list.length; j++){
				if((minInstructor.getInstructor()).compareTo(list[j].getInstructor()) > 0){
					//using compareTo to compare lexographically to sort the course instructors alphabetically
					minInstructor = list[j];
					minInstructorIndex = j;
				}
			}
			
			//swap list[i] with list[minInstructorIndex] when necessary - when the if statement is true for each iteration
			if(minInstructorIndex != i){
				//made sure to switch entire course info and not just the Instructor name
				list[minInstructorIndex] = list[i];
				list[i] = minInstructor;
			}
		}
	return list;
	}


	/**
	 * @param list (array) of course name, instructor last name, capacity, and course code
	 * @return the array of course info sorted by capacity in ascending order
	 */
	public static Course[] sortCapacity(Course [] list){
		
		//everything similar to sortInstructor method except we compare list[x].getCapacity instead of .getInstructor
		for(int i = 0; i < list.length-1; i++){
			
			Course minInstructor = list[i];
			int minCapacityIndex = i;
			
			for(int j = i+1; j < list.length; j++){
				if(minInstructor.getCapacity() > list[j].getCapacity()){
					minInstructor = list[j];
					minCapacityIndex = j;
				}
			}
				
			if(minCapacityIndex != i){
				list[minCapacityIndex] = list[i];
				list[i] = minInstructor;
			}
		
	}

	return list;
	}
	

	/**
	 * @param list (array) of course name, instructor last name, capacity, and course code
	 * @return the array of course info sorted alphabetically by instructor and then by capacity
	 * Extra Credit
	 */
	public static Course[] thirdSort(Course[] list){
		
		//beginning is same as sortInstructor method because first we want to sort the courses by instructor
		for(int i = 0; i < list.length-1; i++){
			Course minInstructor = list[i];
			int minInstructorIndex = i;
			
			for(int j = i+1; j < list.length; j++){
				if((minInstructor.getInstructor()).compareTo(list[j].getInstructor()) > 0){
					minInstructor = list[j];
					minInstructorIndex = j;
				}
			}
				
			if(minInstructorIndex != i){
				list[minInstructorIndex] = list[i];
				list[i] = minInstructor;
			}
		}
		
		//after we sort by instructor, we check to see if any of the course instructors have the same name
		for(int i = 0; i < list.length-1; i++){
			Course smaller = list[i];
			for(int j = i+1; j < list.length; j++){
				if(list[i].getInstructor().compareTo(list[j].getInstructor()) == 0){
				//if they do have the same name (compareTo ==0) then we check which if the second is smaller and if it is we swap the courses
					if(list[i].getCapacity() > list[j].getCapacity()){
						smaller = list[j];
						list[j] = list[i];
						list[i] = smaller;
					}
				}
			}
		}
		return list;
	}
		
	
	
}
	