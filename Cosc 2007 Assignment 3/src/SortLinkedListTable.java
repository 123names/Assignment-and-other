import java.io.FileWriter;
import java.io.IOException;


public class SortLinkedListTable {

	private LinkedListNode head = null;                      // header for linkedlist, other are same
	private int count = 0;
	public FileWriter output;
	
	public SortLinkedListTable() throws IOException{
		output = new FileWriter("F:/output.txt");
	}
	
	public boolean isEmpty(){                                 //do not need to check full condition, just need check empty
		if(head == null){
			return true;
		}
		return false;
	}
	public void insert(int item) throws IOException{
		boolean dup = false;
		boolean isHead = false;                               // check it is head or not, special condition 1
		if(head==null){                                       // if not element in it, create a new node to store data and head point to it
			head = new LinkedListNode(item,null);
			output.write("Inserted Element " + item);
			output.append(System.lineSeparator());
			isHead = true;
		}
		LinkedListNode curr = head;                           // curr pointer
		while(curr.getNext()!=null&&curr!=null){              // check dup, special condition 2
			if(curr.getNum()==item){
				dup = true;
				output.write("Duplicate_Element_Found.");
				output.append(System.lineSeparator());
			}
			curr = curr.getNext();
		}
		if(!dup&&!isHead){                                     //check is not dup and is not head, create new node and put data in it
			curr.setNext(new LinkedListNode(item,null));
			output.write("Inserted Element " + item);
			output.append(System.lineSeparator());
		}
	}
	
	public boolean delete(int item) throws IOException{         //delte 
		boolean success = false;
		LinkedListNode curr = head;                             // pointer curr and prv
		LinkedListNode prv = null;                                
		if(isEmpty()){                                          //check empty
			output.write("Dictionary Empty.");
			output.append(System.lineSeparator());
		}
		if(!find(item)){                                        //check if item is exist
			output.write("Element_not_Found");
			output.append(System.lineSeparator());
		}
		else{
			while(curr.getNext()!=null){                        // go thought linked list
				if(curr.getNum()==item&&curr==head){            // if find item and it is in head
					head = curr.getNext();                      // move head to new item
				}
				else if(curr.getNum()==item){                   // normal case, set prv pointer point to the next one node that curr point to
					prv.setNext(curr.getNext());
				}
				prv = curr;                                     // prv point to curr curr point to next node
				curr = curr.getNext();
			}
			output.write("Element " + item + " Deleted");       //write in to file
			output.append(System.lineSeparator());
			success = true;
		}
		return success;                                         //return success or not
	}
	
	public boolean find(int item){                              // go thought all node to find the item that i looking for
		LinkedListNode curr = head;
		while(curr!=null){
			if(curr.getNum()==item){
				return true;
			}
			curr = curr.getNext();
		}
		return false;
	}
	
	public void print() throws IOException{                     // print item in to outputfile
		LinkedListNode curr = head;
		while(curr.getNext()!=null){
			output.write(curr.getNum() + " ");
			output.append(System.lineSeparator());
			curr = curr.getNext();
		}
	}
}
