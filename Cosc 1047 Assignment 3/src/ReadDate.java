import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadDate {

	public static void main(String []args) throws IOException{
		
		File file1 = new File("Exercise14_15.txt");
		Scanner input = new Scanner(file1);
		int line =0;
			do{
				double numbers = input.nextDouble();
				System.out.print(numbers + " ");
				line++;
				if(line%10==0){
					System.out.println();
				}
			}while(input.hasNextDouble());
		
		input.close();
	}
}
