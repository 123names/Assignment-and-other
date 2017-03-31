
public class MyQueue extends IntegerQ{
	
	public MyQueue(){
		super();
	}

	public MyQueue(int i, LinkedListNode n) {
		super(i,n);
	}

	public void print(){
		if(isEmpty()){
			throw new EmptyStructureException("Queue is empty.");
		}
		else{
			System.out.print("Number in queue is:      ");
			LinkedListNode Curr = top;
			 while(Curr!=null){
				 System.out.print(Curr.getNum()+ " ");
				 Curr = Curr.getNext();
			 }
			 
			 System.out.println();
		}
	}
	 public void sort(){
		 if(isEmpty()){
				throw new EmptyStructureException("Queue is empty.");
			}
		 else{
			 LinkedListNode tempTop = top;
			 int tempN = 0;	 
			 for(int i = 0; i<size()-1;i++){
				 LinkedListNode curr = tempTop.getNext();
				 for(int j = 0; j<size()-i-1;j++){
					 LinkedListNode curr1 = tempTop;
					 if(curr1.getNum()>=curr.getNum()){
						 tempN = curr1.getNum();
						 curr1.setNum(curr.getNum());
						 curr.setNum(tempN);
					 }
					 curr = curr.getNext();
					 curr1 = curr1.getNext();
				 }
				 tempTop = tempTop.getNext();
			 }
				System.out.print("Sort Number in queue is: ");
				LinkedListNode next = null;
				 next = top;
				 while(next!=null){
					 System.out.print(next.getNum()+ " ");
					 next = next.getNext();
				 }
			 
		 }
	 }
}
