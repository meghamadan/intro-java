
/**
 * @author Megha
 * This program uses a method called validateBracket to check if the brackets in a mathematical expression are valid (equal/balanced)
 */
public class BracketValidator {
	
	/**
	 * @param expression takes in a string of arrays that contains the mathematical expression
	 * use expression index 0 because we assume the expression does not have any spaces
	 * @return true or false according whether the brackets are valid
	 */
	public static Boolean validateBracket(String [] expression){
		
		//assign char variables to the various brackets
		char openParenthesis = '(';
		char closeParenthesis = ')';
		char openBrace = '{';
		char closeBrace = '}';
		char openBracket = '[';
		char closeBracket = ']';
		
		//creat new stackOfCharacters object
		StackOfCharacters Math = new StackOfCharacters();

			//for loop that runs through each character of the first string object of the expression array
			for(int i = 0; i < expression[0].length(); i++){
			
				//first check for open parenthesis/curly brace/square bracket
				if (expression[0].charAt(i) == openParenthesis){
					Math.push(expression[0].charAt(i));//if there is an opening bracket, we add it to the stack
				}
				else if(expression[0].charAt(i) == openBrace){
					Math.push(expression[0].charAt(i));
				}
				else if(expression[0].charAt(i) == openBracket){
					Math.push(expression[0].charAt(i));
				}
				
				//then check for close parenthesis/curly brace/square bracket
				else if(expression[0].charAt(i) == closeParenthesis){
					if(Math.empty() == true){
						System.out.println("INVALID");//this checks to see if there is a closing bracket when there is no opening bracket
						return false;
					}
					if(Math.peek() == openParenthesis){
						Math.pop();//if there is a corresponding opening bracket of the same type (parenthesis/brace/bracket) then we remove it and this ensures each set of brackets is canceled out
					}
				}
				else if(expression[0].charAt(i) == closeBrace){
					if(Math.empty() == true){
						System.out.println("INVALID");
						return false;
					}
					if(Math.peek() == openBrace){
						Math.pop();
					}
				}
				else if(expression[0].charAt(i) == closeBracket){
					if(Math.empty() == true){
						System.out.println("INVALID");
						return false;
					}
					if(Math.peek() == openBracket){
						Math.pop();
					}
				}
				
				
				
			}//end of for loop
			
			
			
			if(Math.empty() == true){
				System.out.println("VALID");//if the stack is empty this means each time an opening bracket was used there was a corresponding closing bracket
				return true;
			}
			else//any other situation would mean there were not a similar amount of brackets
				System.out.println("INVALID");
				return false;
				
	}
	
		public static void main (String [] args){
			
		//by using args we are using command line arguments
		//currently there is only one string argument in args (which is the only way this program works - no spaces in expression)
		System.out.println(validateBracket(args));
		
		}//end main
}
