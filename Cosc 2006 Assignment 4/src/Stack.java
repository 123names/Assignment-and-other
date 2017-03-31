
public class Stack {
	
	private LinkedListNode top = new LinkedListNode();
	
	public Stack(){
		top = null;
	}
	public boolean isEmpty(){
		
		if(top == null){
			return true;
		}
		return false;
	}
	public void push(int num){
		top = new LinkedListNode(num, top);
	}
	public int pop()throws RuntimeException{
		LinkedListNode temp = top;
		if(!isEmpty()){
			top = top.getNext();
			return temp.getNum();
		}
		else{
			throw new RuntimeException("No data on stack.");
		}
	}
	public int peek()throws RuntimeException{
		if(!isEmpty()){
			return top.getNum();
		}
		else{
			throw new RuntimeException("No data on stack.");
		}
		
	}
	public void popAll(){
		top = null;
	}
	
}
