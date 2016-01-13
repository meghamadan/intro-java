//Megha Madan
//September 11, 2014
//Approximating Pi Assignment
//Writing a program that computes the result of 4 x (1-(1/3)+(1/5)-(1/7)+(1/9)-(1/11)) and 4 x (1-(1/3)+(1/5)-(1/7)+(1/9)-(1/11)_(1/13))
public class Pi {
	public static void main (String args []){
		
//Approximation of pi using 6 terms.
		double pi;
		//Must use 1.0 otherwise the approximation will be rounded and both pi and pi2 will be the same value.
		pi=4*(1.0-(1.0/3)+(1.0/5)-(1.0/7)+(1.0/9)-(1.0/11));
		
		System.out.println("Approximation of pi with 6 terms: " + pi);
		
//Approximation of pi using 7 terms.
		double pi2;
		
		pi2=4*(1.0-(1.0/3)+(1.0/5)-(1.0/7)+(1.0/9)-(1.0/11)+(1.0/13));
		
		System.out.println("Approximation of pi with 7 terms: " + pi2);
	}

}
