/**
 * @author Megha
 * Game class that uses PApplet (processing) to create a game that involves random shaped disks (ellipses) moving in random directions.
 * The object of the game is to click on the different point value disks and collect as many points possible within two minutes
 */

import processing.core.PApplet;

public class Game extends PApplet {

	//dimensions of the canvas
	private int xMax = 500;
	private int yMax = 500;
	
	//the array of Disk objects that will be drawn to the canvas
	private Disk [] myDisks = new Disk[250];
	
	//the total score of all of the points of disks that were clicked on
	private int totalScore = 0;
	
	//following used to periodically draw a disk to the screen
	private int iterationCounter = 0;
	private int diskCounter = 1;
	
	//following used to keep track of the amount of time 
	private int gameStartSecond = Game.second();
	private int gameStartMinute = Game.minute();
	
	
	public void setup(){
		//sets the boundaries of the game
		size(xMax,yMax);
		
		//creates disk objects for each slot of the Disk array
		for (int i = 0; i < myDisks.length; i++){
			myDisks[i] = new Disk(this);
		}
		
	}
	
	public void draw(){
		
			//use the amount of times draw loops through as a timer for when to draw the next disk
			iterationCounter++;

			//sets background color to gray
			background (188, 188, 188);
		
			//periodically draws a new disk after 30 iterations
			if (iterationCounter > 30 && diskCounter < myDisks.length ) {
				diskCounter++;
				iterationCounter = 0;
			}
		
			//use the move method from the disk class to  put the disks in random motion
			for (int i = 0; i < diskCounter; i++){
				myDisks[i].move();
			}
		
			//this for loop has two purposes all according to the point value of the disk 
			for (int i = 0; i < diskCounter; i++){
			
				//if the disk is worth 100 points, 100 is written on the disk
				if(myDisks[i].getPoints() == 100 && myDisks[i].getRX() != 0){
					
					textAlign(CENTER);
					textSize(10);
					fill(0, 0, 0);
					text("100", myDisks[i].getX(), myDisks[i].getY()+5);
					
						//additionally, if it is a higher point value, it disappears sooner (300 for 100 pt. disk vs. 1000 for 10 pt. disk)
						if(myDisks[i].getTotalDistance() > 300)
							myDisks[i].disappear();
				}
				//same test used for the rest of the disks
				else if(myDisks[i].getPoints() == 50 && myDisks[i].getRX() != 0){
					
					textAlign(CENTER);
					textSize(10);
					fill(0, 0, 0);
					text("50", myDisks[i].getX(), myDisks[i].getY()+5);
					
						if(myDisks[i].getTotalDistance() > 500)
							myDisks[i].disappear();
				}
				else if(myDisks[i].getPoints() == 20 && myDisks[i].getRX() != 0){
					
					textAlign(CENTER);
					textSize(10);
					fill(0, 0, 0);
					text("20", myDisks[i].getX(), myDisks[i].getY()+5);
					
						if(myDisks[i].getTotalDistance() > 700)
							myDisks[i].disappear();
				}
				else if(myDisks[i].getPoints() == 10 && myDisks[i].getRX() != 0){	
					
					textAlign(CENTER);
					textSize(10);
					fill(0, 0, 0);
					text("10", myDisks[i].getX(), myDisks[i].getY()+5);
					
						if(myDisks[i].getTotalDistance() > 1000)
							myDisks[i].disappear();
				}
			}
			
			//this if statement determines when to end the game using the second and minute method from processing	
			if(Game.second() == gameStartSecond && Game.minute() == gameStartMinute + 2){
				
				//when the game ends, the screen is cleared and the total # of points is displayes
				background (188, 188, 188);
				textAlign(CENTER);
				textSize(50);
				fill(0,0,0);
				text("Total Score: " + totalScore, xMax/2, yMax/2);
				
				//stops the game from continuing after displaying the score
				stop();
			}
		
	}
	
	
	//this uses the mousePressed method from processing core file to determine if the user successfully clicks on a disk
	public void mousePressed(){
		
		//loop through all of the disks
		for(int i = 0; i < myDisks.length; i++){
			
			//use the insideEllipse method from the Disk class
			if(myDisks[i].insideEllipse(pmouseX, pmouseY) == true){
				
				//if it is successfully clicked on, the disk disappears
				myDisks[i].disappear();
				
				//in addition, the total score is updated with the addition of the point value of the disk clicked on
				totalScore += myDisks[i].getPoints();
			}
		}
	}
	
	
	
	
}
	
	
	

