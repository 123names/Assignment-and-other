
public class LinkedListNode{
	
	private int studentNum;                                         //variable to store data
	private double studentMark;
	private LinkedListNode nextStudent;
	
	public LinkedListNode(){                                        // Constructor
		studentNum = 0;
		studentMark = 0;
		nextStudent = null;
	}
	
	public LinkedListNode(int stN, double stM, LinkedListNode next){ //other constructor
		studentNum = stN;
		studentMark = stM;
		nextStudent = next;
	}
	public void setNum(int stN){                                     //getter setter for data and next node
		studentNum = stN;
	}
	public int getNum(){
		return studentNum;
	}
	public void setMark(double stM){
		studentMark = stM;
	}
	public double getMark(){
		return studentMark;
	}
	public void setNext(LinkedListNode next){                       
		nextStudent = next;
	}
	public LinkedListNode getNext(){
		return nextStudent;
	}
}