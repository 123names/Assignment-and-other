import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class CreateNewText {

	public static void main(String []args) throws IOException{
		
		File file = new File("Exercise14_15.txt");
		
		if(file.exists()){
			System.out.println("File already exist.");
			System.exit(0);
		}
		
		PrintWriter write = new PrintWriter(file);
		Random random1 = new Random(123456);
		for(int i =0; i<100; i++){
			double number = (-10000 + (random1.nextDouble()*20000));
			write.printf("%16.3f" ,number);
			int a= i +1;
			if(a%10 ==0){
				write.println();;
			}
		}
		write.close();
	}
}
