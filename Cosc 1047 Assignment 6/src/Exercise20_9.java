import java.util.Scanner;

public class Exercise20_9 {

	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		System.out.print("Please input a string: ");
		String in = input.nextLine();
		System.out.print("The reverse of string " + in + " is ");
		reverseDisplay(in);
	}
	public static void reverseDisplay(String in){
		
		if (in.length() != 0) {
				System.out.print(in.charAt(in.length()-1));
			
			reverseDisplay((in.substring(0, (in.length()-1))));
		}
		
	}
}
