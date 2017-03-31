import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPclient {

	public static void main(String []args) throws IOException{
		
		Scanner input = new Scanner(System.in);
		String number;
		boolean result;
		System.out.println("Please input a positive number that greater than one: ");
		number = input.nextLine();
		int check =Integer.valueOf(number);
		
		if(check<=1){
			System.out.print("The number you are input is not positive number that greater than one, system exit!");
			System.exit(0);
		}
		else{
			Socket client = new Socket("127.0.0.1", 12000);
			//client.connect(null);
			PrintWriter write = new PrintWriter(client.getOutputStream(),true);
			write.println(number);
			
			Scanner income = new Scanner(new InputStreamReader(client.getInputStream()));
			result = income.nextBoolean();
			
			if(result){
				System.out.println("Number "+ number + " is prime. ");
			}
			else{
				System.out.println("Number "+ number + " is not prime. ");
			}
			client.close();
		}
	}
}
