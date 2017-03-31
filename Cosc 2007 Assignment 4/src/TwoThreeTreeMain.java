import java.util.Scanner;
import java.io.*;

public class TwoThreeTreeMain {

	public static void main(String []args) throws IOException{          // main to test ttTree
		
		TTTree tree = new TTTree();
		Scanner input = new Scanner(System.in);                                   // ask file name to build the tree first time
		System.out.println("Please input the file name: ");
		String in = input.nextLine();
		File inputF = new File(in);
		Scanner inNum = new Scanner(inputF);
		System.out.println("Loading the file and insert into a 2-3 tree......");
		while(inNum.hasNextLine()){                                               // bulid the first tree
			tree.InsertItem(inNum.nextInt());
		}
		int choice = 0;
		while(choice!=4){                                                         // ask user to insert new item to tree or print or exit
			System.out.println("1. insert 2. print ascending 3. print descending 4. save and exit ");
			System.out.println("Enter your choice: ");
			choice = input.nextInt();
			switch(choice){
			case 1:                                                               // choice 1, insert a new item to it
				System.out.println("Enter a number: ");
				int insertNum = input.nextInt();
				tree.InsertItem(insertNum);
				break;
			case 2:                                                               // choice 2, print in ascending order
				tree.printAscending(tree.getR());
				System.out.println();
				tree.output.close();
				break;
			case 3:                                                               // choice 3, print in descending order
				tree.printDescending(tree.getR());
				System.out.println();
				break;
			case 4:                                                               // case 4, exit
				System.out.println("File saved. exiting... ");
				break;
			}
		}
	}
}
