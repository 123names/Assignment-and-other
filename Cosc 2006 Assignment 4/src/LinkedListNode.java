
public class LinkedListNode{
	
	private int Num;                                         //variable to store data
	private LinkedListNode nextStudent;
	
	public LinkedListNode(){                                        // Constructor
		Num = 0;
		nextStudent = null;
	}
	
	public LinkedListNode(int n, LinkedListNode next){ //other constructor
		Num = n;
		nextStudent = next;
	}
	public void setNum(int n){                                     //getter setter for data and next node
		Num = n;
	}
	public int getNum(){
		return Num;
	}
	public void setNext(LinkedListNode next){                       
		nextStudent = next;
	}
	public LinkedListNode getNext(){
		return nextStudent;
	}
}