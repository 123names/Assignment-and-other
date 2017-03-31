
public class PostfixExpression extends Expression{

	private Stack stk = new Stack();
	private Stack vstk = new Stack();
	public PostfixExpression(String expr){
		super(expr);
	}

	@Override
	public boolean verify() {
		for(int i = 0; i < tokens.size();i ++){
			if(isInteger(tokens.get(i))){
				vstk.push(Integer.parseInt(tokens.get(i)));
			}
			if(isOperator(tokens.get(i))){
				int num1 = vstk.pop();
				int num2 = vstk.pop();
				int result =apply(tokens.get(i), num1, num2);
				vstk.push(result);
				vstk.pop();
			}
		}
		if(vstk.isEmpty()){
			 return (tokens.size() > 0 && tokens.size() % 2 == 1);
		}
		return false;
	}

	@Override
	public int evaluate() {
		if(verify()){
		for(int i = 0; i < tokens.size();i ++){
			if(isInteger(tokens.get(i))){
				stk.push(Integer.parseInt(tokens.get(i)));
			}
			if(isOperator(tokens.get(i))){
				int num1 = stk.pop();
				int num2 = stk.pop();
				int result =apply(tokens.get(i), num1, num2);
				stk.push(result);
			    }
	    	}
		}
		return stk.pop();
	}
}
