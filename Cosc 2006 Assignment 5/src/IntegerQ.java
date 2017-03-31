
public class IntegerQ {
	
	protected LinkedListNode top = null;
	protected int countQ = 0;

	public IntegerQ(){
		
	}
	public IntegerQ(int a, LinkedListNode b){
		top = new LinkedListNode(a,b);
		countQ++;
	}
	
	public int size(){
		return countQ;
	}
	public boolean isEmpty(){
		return countQ==0;
	}
	public Integer first() throws EmptyStructureException{
		if(isEmpty()){
			throw new EmptyStructureException("Queue is empty.");
		}
		else{
		Integer a = new Integer(top.getNum());
		return a;
		}
	}
	public Integer dequeue() throws EmptyStructureException{
		if(isEmpty()){
			throw new EmptyStructureException("Queue is empty.");
		}
		else{
			Integer a = new Integer(top.getNum());
			top=top.getNext();
			countQ--;
			return a;
		}
	}
	 public void enqueue(Integer N){
		 if(isEmpty()){
			 top = new LinkedListNode(N.intValue(),null);
			 countQ++;
		 }
		 else{
			 LinkedListNode curr = null;
			 curr = top;
			 while(curr.getNext()!=null){
				 curr = curr.getNext();
			 }
			 curr.setNext(new LinkedListNode(N.intValue(),null));
			 countQ++;
		}
    }
}
