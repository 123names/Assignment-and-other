/*Ygao Cose2006
 * Linked list for assignment 3
 */

import java.util.Scanner;                                                           //import Scanner
import java.io.*;
public class test {
	                                                                                //main
	public static void main(String[] args) throws FileNotFoundException {
		
		StudentList list = new StudentList();
		LinkedListNode median;
		String command = "A";
		File stuff = new File("E:/JAVA/Workspace/text2.txt");                      // read data from txt file
		Scanner read = new Scanner(stuff);
		                                                                            //Scanner read read data from stuff
		Scanner input = new Scanner(System.in);
		                                                                            // read data until not line
		while(read.hasNextLine()){
				list.add(read.nextInt(), read.nextDouble());
		}
		
		                                                                            //do while loop to Enter command until Q(Quit)
		do{
			System.out.print("Please enter your command:  P (EveryBody Mark), M (Median Mark) or Q (quit): ");
		command = input.next();
		                                                                            //switch statement to make choice
		switch(command){
		case "P":                                                                   //case P, Print everyone's mark
			System.out.println("Student Number:                    Mark:  ");
			list.printList();
			break;
		case "M":                                                                      //out put Median Mark
			System.out.println("The median mark is "+ list.medianMark().getMark() +" , by student number " + list.medianMark().getNum() +" .");
			break;
		case "Q"://quit
			command ="Q";
			break;
		default: //condition that type wrong code
			System.out.println("Wrong code for command.");
			break;
	    	}
	    }while(command!="Q");
    }
}