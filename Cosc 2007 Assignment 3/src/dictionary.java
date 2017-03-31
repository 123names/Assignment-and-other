import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class dictionary {
	
	public static void main(String []args) throws IOException{
		ArrayList<String> temp = new ArrayList();                          // ArrayList temp to receive the date read from file
		SortedArrayTable test = new SortedArrayTable(100);                // arraybase, need size
		int count = 0; 
		File input = new File("F:/input.txt");                           //Scanner the file and put it in arraylist
		Scanner in = new Scanner(input);
		while(in.hasNextLine()){
			temp.add(in.nextLine());
		}
		while(temp.size()>count){                                    //go through the array list until no item in it
			if(temp.get(count).contains("I")){                           //check the I for insert condition
				int InsertNum = Integer.parseInt(temp.get(count).substring(2, 3));
				test.insert(InsertNum);
			}
			else if(temp.get(count).contains("R")){      //check the D for delete condition
				int DeleteNum = Integer.parseInt(temp.get(count).substring(2, 3));
				test.delete(DeleteNum);
			}
			else if(temp.get(count).contains("F")){        //check the F for find condition
				int FindNum = Integer.parseInt(temp.get(count).substring(2, 3));	
				test.find(FindNum);
			}
			else{                                           //put exist data in file
				test.display();
			}
			count++;                                    //counter for loop
		}
		test.output.close();                             //close outputfile
	}
}
