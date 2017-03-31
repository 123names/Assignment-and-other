import java.io.FileWriter;
import java.io.IOException;


public class SortedArrayTable {
	
	private int array [];                            // array to store data
	private int size = 0;                            // count number that data in array
	public FileWriter output;                        // file that output to
	
	public SortedArrayTable(int size) throws IOException{         // recieve int to create array with max size 
		output = new FileWriter("F:/output.txt");                 // create the file data write to
		array = new int [size];
	}
	
	public boolean isFull(){                                     // check the array is full or not
		if(size >=array.length){
			return true;
		}
		return false;
	}
	public boolean isEmpty(){                                   //check that array is empty or not
		if(size==0){
			return true;
		}
		return false;
	}
	public void insert(int item) throws IOException{             // insert
		if(isFull()){                                            // condition: array dictionary full
			output.write("Dictionary_Full."); 
			output.append(System.lineSeparator());               //write new line to file
		}
		else{
			boolean dup = false;                                 //boolean to see if value exist or not 
			if(find(item)){
				output.write("Duplicate_Element_Found.");        //if value already in array, write that duplicate element is found
				output.append(System.lineSeparator());
				dup = true;	                                     // set dup to true
			}
			if(!dup){                                            // only put value in array if not dup
				size++;
				int position = size-1;
				array[position] = item;
				output.write("Inserted Element " + item);
				output.append(System.lineSeparator());
			}
		}
	}
	public boolean delete(int item) throws IOException{           //delete
		boolean exist = false;
		boolean success = false;
		boolean beginshift = false;
		
		if(isEmpty()){                                            //check if it's empty
			output.write("Dictionary Empty.");
			output.append(System.lineSeparator());
		}
		if(find(item)){                                           // if found the item, array is deleteable, set exist to true
			exist = true;
		}
		if(!exist){                                               //condition: element not found
			output.write("Element_not_Found");
			output.append(System.lineSeparator());
		}
		else{
			for(int i = 0; i<size;i++){
				if(item == array[i]){                             // check each element in array, if find the one, mark it to begin the shift
					beginshift = true;
					success = true;
					output.write("Element " + array[i] + " Deleted");
					output.append(System.lineSeparator());
				}
				if(beginshift){                                   // shift the remove the item you want to delete
					array[i] = array[i+1];
				}
			}
		}
		return success;                                           // return if  the item is delete or not
	}
	public boolean find (int item){                               //binary search to find the item 
		int mid;
		int front=0;
		int back=size-1;
		while (front<=back){
			mid = (front+back)/2;
			if(array[mid]==item){
				return true;
			}
			if(array[mid]<item){
				front = mid+1;
			}
			else{
				back = mid-1;
			}
		}
		return false;
	}
	public void display() throws IOException{                      // print the item in file output
		for(int i = 0; i<size-1;i++){
			output.write(array[i] + "  ");
			output.append(System.lineSeparator());
		}
	}
}
