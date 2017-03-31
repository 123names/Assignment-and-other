import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPserver {

	public static void main(String []args) throws IOException{
		
		ServerSocket server = new ServerSocket(12000);
		
		while(true){
			Socket link = server.accept();
			System.out.println("This server is ready!");
			
			Scanner income =new Scanner(new InputStreamReader(link.getInputStream()));
			int number = Integer.valueOf(income.nextLine());
			//System.out.println(number);
			boolean result = isPrime(number);
			//System.out.println(result);
			PrintWriter write = new PrintWriter(link.getOutputStream(),true);
			write.println(result);
		}
	}
	public static boolean isPrime(int number){
		for(int i=2;i<number;i++) {
	        if(number%i==0)
	            return false;
	    }
	    return true;
	}
}
