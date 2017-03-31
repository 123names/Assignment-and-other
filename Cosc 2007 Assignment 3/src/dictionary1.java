import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class dictionary1 {
	
	public static void main(String []args) throws IOException{
		ArrayList<String> temp = new ArrayList();                            // Basically, same way with the other dictionary 
		SortLinkedListTable test = new SortLinkedListTable();
		int count = 0;
		File input = new File("F:/input.txt");
		Scanner in = new Scanner(input);
		while(in.hasNextLine()){
			temp.add(in.nextLine());
		}
		while(temp.size()>count){
			if(temp.get(count).contains("I")){
				int InsertNum = Integer.parseInt(temp.get(count).substring(2, 3));
				test.insert(InsertNum);
			}
			else if(temp.get(count).contains("R")){
				int DeleteNum = Integer.parseInt(temp.get(count).substring(2, 3));
				test.delete(DeleteNum);
			}
			else if(temp.get(count).contains("F")){
				int FindNum = Integer.parseInt(temp.get(count).substring(2, 3));	
				test.find(FindNum);
			}
			else{
				test.print();
			}
			count++;
		}
		test.output.close();
	}
}
