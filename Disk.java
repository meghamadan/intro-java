
/**
 * @author Megha
 * Disk class that represents ellipses of various sizes and point values. They also move at certain speeds and in certain directions
 * It also tracks the distance the disk travels
 */

import processing.core.PApplet;
import java.util.Random;

class Disk {
	
	//represents the position on the canvas the ellipse is located
	private float x;
	private float y;
	
	//represents the size of the ellipse
	private float rx;
	private float ry;
	
	//this is the amount the ellipse moves in the x and y direction each time it is drawn to simulate continuous motion
	private float xSpeed;
	private float ySpeed;
	
	PApplet canvas;

	int col;
	
	//used for the get distance method
	private int iterationCounter = 0;
	
	//this keeps track of the total distance the ellipse travels (needed for Game class to decide when to make the disk disappear)
	private float totalDistance;
	
	//according to the size of the disk, different point values are assigned to the disk
	private int points;
	
	//create a random object to give ellipses random speeds
	Random rand = new Random();
	int randomInt = rand.nextInt(4) + 1;
	
	/**
	 * @param canvas 
	 * Method that represents a disk (ellipse) drawn to the canvas
	 */
	public Disk ( PApplet canvas )
	{
		//start ellipses at random values within the canvas size
		this.canvas = canvas;
		x = canvas.random(0,  canvas.width); 
		y = canvas.random(0, canvas.height);
		//make the ellipses of various x and y sizes between 10 and 100
		rx = canvas.random(10 , 100);
		ry = canvas.random(10 , 100);
		
		xSpeed = randomInt;
		ySpeed = randomInt;
		
		//randomly color the ellipses but wanted to avoid having a very dark color because you would not be able to see the points
		col = canvas.color(canvas.random(50,255), canvas.random(50,255), canvas.random(50,255));
	}

	/**
	 * Method that simulates movement of the disk
	 */
	public void move() {
		
		//will later help keep track of the distance a disk travels
		iterationCounter++;
		
		//random numbers added to the x and y coordinates of the ellipse to change its location and to simulate continuous motion
		x += xSpeed;
		y += ySpeed;
		
		//check to see if the ball hits any of the edges (4 sides, 4 if statements). If it does, we change the direction to simulate bouncing
		if (x > canvas.width) {
			x = canvas.width;
			xSpeed *= -1;
		}
		if (x < 0) {
			x = 0;
			xSpeed *= -1;
		}
		if (y > canvas.height) {
			y = canvas.height;
			ySpeed *= -1;
		}
		if (y < 0) {
			y = 0;
			ySpeed *= -1;
		}
		
		// call the ellipse method on the PApplet object to draw this object to the canvas
		canvas.fill(col);
		this.canvas.ellipse(x, y, rx, ry);
	}

	/**
	 * @return points - the value of each ellipse/disk
	 */
	public int getPoints(){
			
		//according to the size of rx and ry, the ellipse/disk is given a point value
			if((rx > 10 && rx <= 20)|| (ry > 10 && ry <= 20)){
				points = 100;
			}
			else if((rx > 20 && rx <= 30) || (ry > 20 && ry <= 30)){
				points = 50;
			}
			else if((rx > 30 && rx <= 50) || (ry > 30 && ry <= 50)){
				points = 20;
			}
			else if((rx > 50 && rx <= 100) || (ry > 50 && ry <= 100)){
				points = 10;
			}
			
		
		return points;
	}
	
	
	/**
	 * @param mx the x coordinate of a point we are comparing to
	 * @param my the y coordinate of a point we are comparing to
	 * @return true if the point we are interested in is within an ellipse, otherwise, return false
	 */
	public boolean insideEllipse(int mx, int my){
		
		//used an equation of the distance between a point and an ellipse 
		//used trial and error to use .26 instead of 1
		if(((((x-mx)*(x-mx))/(rx * rx)) + (((y-my)*(y-my))/(ry * ry)) <= .26))
		
			return true;
		
		else
			return false;
		
	}
	
	/**
	 * @return the distance a disk has traveled since it was created
	 */
	public float getTotalDistance(){
		//because both xSpeed and ySpeed are the same, I do not have to measure both
		//in addition, if they are different, I would just have to add ySpeed*iterationCounter to totalDistance
		totalDistance = Math.abs(xSpeed*iterationCounter);
	
		return totalDistance;
		
	}
	
	
	/**
	 * @return the x coordinate of the disk
	 */
	public float getX(){
		return x;
	}
	
	/**
	 * @return the y coordinate of the disk
	 */
	public float getY(){
		return y;
	}
	
	/**
	 * @return the radius on the x axis
	 */
	public float getRX(){
		return rx;
	}
	
	/**
	 * @return the radius on the y axis
	 */
	public float getRY(){
		return ry;
	}
	

	
	/**
	 * This simulates the disappearance of a disk by making the size of the ellipse 0
	 */
	public void disappear () {
		
		rx = 0;
		ry = 0;
	}
	
}