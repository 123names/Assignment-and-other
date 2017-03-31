import java.io.*;
import java.util.Scanner;


public class Exercise19_19 {

		  public static void main(String[] args) throws IOException {
			  //create scanner for input file location
		    Scanner in = new Scanner(System.in);
		    System.out.print("Enter a file name: ");
		    String filename = in.nextLine();
		    FileInputStream input = new FileInputStream(filename);
		    
		    while(input.available()!=0){
		    	//read data in byte
		    	int oneByte = input.read();
		    	int count = 0;
		    	//cast to hex
		    	System.out.print((Integer.toHexString(oneByte)));
		    	if(count%2 == 0){
		    		System.out.print(" ");
		    	}
		    	if((count+1)%10 == 0){
		    		System.out.println();
		    	}
		    	count++;
		    	
		    }
		    input.close();
		    //close input
	}
}
