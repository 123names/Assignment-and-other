import java.util.ArrayList;
import java.util.Scanner;

/**
 * Abstract class that models a mathematical expression using the operators "+", "-",
 * "*", and "/".  Abstract methods <code>verify</code> and <code>evaluate</code> must be implemented in any
 * derived class, following the rules for the corresponding type of expression.
 *   @author
 *   @version
 */

public abstract class Expression{
	protected ArrayList<String> tokens;

	/**
	 * Constructs an expression given its string representation.
	 *   @param expr the expression string, with tokens separated by whitespace
	 */
	public Expression(String expr){
	    tokens = new ArrayList<String>();
	    Scanner exprScan = new Scanner(expr);
	    while (exprScan.hasNext()) {
	        tokens.add(exprScan.next());
	    }
	}

	/**
	 * Abstract method to verify that the expression is valid in form.
	 *   @return true if the expression is valid, else false
	 */
	public abstract boolean verify();

	/**
	 * Abstract method to evaluate the expression and return its value.
	 *   @return the integer value represented by the expression
	 */
	public abstract int evaluate();

	/**
	 * Converts an expression into its string representation.
	 *   @return a string containing the expression tokens, separated by spaces
	 */
	public String toString(){
	    if (tokens.size() == 0) {
	        return "";
	    }
	    else {
	        String outStr = tokens.get(0);
	        for (int i = 1; i < tokens.size(); i++) {
	            outStr += " " + tokens.get(i);
	        }
	        return outStr;
	    }
	}

	/**
	 * Determines whether a string represents an arithmetic operator
	 *   @param str the string to be tested
	 *   @return true if either "+", "-", "*", or "/"
	 */
	protected boolean isOperator(String str){
	    final String operators = "+-*/";
	    return (operators.indexOf(str) >= 0);
	}

	/**
	 * Determines whether a string represents and integer value
	 *   @param str the string to be tested
	 *   @return true if str is a sequence of digits, else false
	 */
	protected boolean isInteger(String str){
	    try {
	        int num = Integer.parseInt(str);
	        return true;
	    }
	    catch (NumberFormatException exception) {
	        return false;
	    }
	}

	/**
	 * Applies an operator to two integer values and returns the result.
	 *   @param operator either "+", "-", "*", or "/"
	 *   @param op1 the first integer operand (left-hand side)
	 *   @param op2 the second integer operand (right-hand side)
	 *   @return the result of applying the operator to the two integers-
	 */
	protected int apply(String operator, int op1, int op2){
	    if (operator.equals("+")) {
	        return (op1 + op2);
	    }
	    else if (operator.equals("-")) {
	        return (op1 - op2);
	    }
	    else if (operator.equals("*")) {
	        return (op1 * op2);
	    }
	    else {
	        return (op1 / op2);
	    }
	}
}
