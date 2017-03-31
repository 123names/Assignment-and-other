
public class LinkedListNode{
	
	private int Num;                                         //variable to store data
	private LinkedListNode next;
	
	public LinkedListNode(){                                        // Constructor
		Num = 0;
		next = null;
	}
	
	public LinkedListNode(int n, LinkedListNode next){ //other constructor
		Num = n;
		this.next = next;
	}
	public void setNum(int n){                                     //getter setter for data and next node
		Num = n;
	}
	public int getNum(){
		return Num;
	}
	public void setNext(LinkedListNode next){                       
		this.next = next;
	}
	public LinkedListNode getNext(){
		return next;
	}
}