import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class test {
	public static void main(String []args)throws IOException{
		Scanner input = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		File file = new File("Exercise14_15.txt");
		Scanner in = new Scanner(file);
		if(file.exists()){
			System.out.print("Exist");
		}
		int numberOfChar = 0;
		int numberOfWords = 0;
		int numberOfLine = 0;
		while(in.hasNextLine()){
			String line = in.nextLine();
			char [] charNum = line.toCharArray();
			int numCharOfLine = 0;
			numberOfLine++;
		}
		numberOfWords = list.size();
		System.out.println(numberOfChar + " Character");
		System.out.println(numberOfWords + " Words");
		System.out.println(numberOfLine + " Line");
	}
}


