/**
 * Class that models an infix expression using the operators "+", "-",
 * "*", and "/".  Note that several utility methods are inherited from
 * the abstract <code>Expression</code> class.
 *   @author
 *   @version
 */

public class InfixExpression extends Expression{
	/**
	 * Constructs an infix expression given its string representation.
	 *   @param expr the expression string, with tokens separated by whitespace
	 */
    public InfixExpression(String expr){
        super(expr);
    }

    /**
	 * Verifies that the expression is a valid infix expression.
	 *   @return true if the expression is valid, else false
	 */
	public boolean verify(){
        for (int i = 0; i < tokens.size(); i++) {
            if ((i % 2 == 0 && !isInteger(tokens.get(i))) ||(i % 2 == 1 && !isOperator(tokens.get(i)))) {
                    return false;
            }
        }
        return (tokens.size() > 0 && tokens.size() % 2 == 1);
    }

	/**
	 * Evaluates the infix expression and return its value.
	 *   @return the integer value represented by the expression
	 */
	public int evaluate(){
	    int value = Integer.parseInt(tokens.get(0));
	    for (int i = 1; i < tokens.size()-1; i+=2) {
	        value = apply(tokens.get(i), value, Integer.parseInt(tokens.get(i+1)));
	    }
	    return value;
	}
}
