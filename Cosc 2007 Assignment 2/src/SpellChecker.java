import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellChecker {

	public static void main(String []args) throws FileNotFoundException{
		
		int countTotal = 0;
		int countMist = 0;
		int countElement = 0;
		BinarySearchTree DirTree = new BinarySearchTree();
		
		Scanner input = new Scanner (System.in);
		System.out.println("What is the dictionary file? ");// ask for file dir
		String DataBaseFileName = input.nextLine();
		
		File DirDataBase = new File(DataBaseFileName);
		Scanner Read = new Scanner(DirDataBase);   //scanner for the file
		while(Read.hasNextLine()){
			Read.nextLine();
			countElement++;
		}
		DirTree.getBalance(DirDataBase, countElement);//insert the item to dictionary tree and balance them
	//	while(Read.hasNextLine()){
		//	DirTree.insert(new KeyedItem(Read.nextLine().toLowerCase()));
		//}
		System.out.println("What is the input file for spelling check? ");//scanner for input the check file
		String SubjectName = input.nextLine();
		File Subject = new File(SubjectName);
		Scanner in = new Scanner(Subject);
		System.out.println("The height of tree is " + DirTree.height());// output the height of tree
		System.out.println("Possible misspelled words in the file: ");
	    while(in.hasNextLine()){
	    	KeyedItem Sub = new KeyedItem(in.next().toLowerCase());
			if(DirTree.retrieve(Sub) == null){
				System.out.println(Sub.getKey());
				countMist++;
			}
	    	countTotal ++;
		}
	    System.out.println("Total number of words is " + countTotal + ", possible number of misspelled words is " + countMist + " .");
	 // check if we retireve anything to see if it is in the dirtionary
	}
}
