import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Countcharacter {

	public static void main(String []args)throws IOException{
		
		Scanner input = new Scanner(System.in);
		File file = new File("Exercise14_15.txt");
		Scanner in = new Scanner(file);

		int numberOfChar = 0;
		int numberOfWords = 0;
		int numberOfLine = 0;
		
		while(in.hasNextLine()){
			String line = in.nextLine();
			numberOfChar += line.length();
			String words [] = line.split(" ");
			numberOfWords += words.length;
			numberOfLine++;
		}

		System.out.println(numberOfChar + " Character");
		System.out.println(numberOfWords + " Words");
		System.out.println(numberOfLine + " Line");
	}
}
