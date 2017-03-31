import java.util.Scanner;

/**
 * Simple calculator that reads infix expressions and evaluates them.
 *   @author
 *   @version
 */

public class Calculator{
	public static void main(String[] args){
	    Scanner input = new Scanner(System.in);
	    int choice = 1;
	    while(choice!=0){
	    System.out.print("Please enter a choice that you want to input a infix(1) or postfix(2) expression(other char will exit): ");
	    try{
	    	choice = input.nextInt();
	    }
	    catch(RuntimeException exception){
	    	System.out.println("Exit.");
	    	break;
	    }
	    
	    switch(choice){
	    case 1:        
	    	System.out.print("Enter an infix expression (or hit RETURN to stop): ");
	    	input.nextLine();
	    	String line = input.nextLine();
	    	while (line.length() > 0) {
	    		Expression iexpr = new InfixExpression(line);
	    		if (iexpr.verify()) {
	    			System.out.println(iexpr.evaluate());
	    			break;
	            }
	            else {
	                System.out.println("INVALID EXPRESSION");
	                break;
	            }
	    	}
	    	break;
	    
	    case 2: 
	    	System.out.print("Enter an postfix expression (or hit RETURN to stop): ");
	    	input.nextLine();
	    	String line2 = input.nextLine();
	    	try{
	    	while (line2.length() > 0) {
	    		Expression pexpr = new PostfixExpression(line2);
	    		if (pexpr.verify()) {
	    			System.out.println(pexpr.evaluate());
	    			break;
	            }
	            else {
	                System.out.println("INVALID EXPRESSION");
	                break;
	            }
	    	}
	    	}
	    	catch(RuntimeException Exception){
	    		 System.out.println("INVALID EXPRESSION");
	    	}
	    	break;
	    	
	    default :
	    	input.nextLine();
	    	System.out.println("You have input a invalid choice.");
	    	break;
	        }
	    }
	}
}
