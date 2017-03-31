/* Cosc 1046  
 * question 3.35
 * Yan Gao
 * decimal to hex
 * January 29, 2014
 */
import java.util.Scanner;

public class PartB35 {
	
	public static void main(String []args){
		
		System.out.print("Enter a decimal value (0 to 15): ");
		Scanner input = new Scanner(System.in);
		int decimal = input.nextInt();
		
		switch (decimal){	
		case 0 :
		case 1 :
		case 2 :
		case 3 :
		case 4 :
		case 5 :
		case 6 :
		case 7 :
		case 8 :
		case 9 :	
			System.out.println("The hex value is " + decimal);
			break;
			
		case 10: System.out.println("The hex value is  A");
		break;
		case 11: System.out.println("The hex value is  B");
		break;
		case 12: System.out.println("The hex value is  C");
		break;
		case 13: System.out.println("The hex value is  D");
		break;
		case 14: System.out.println("The hex value is  E");
		break;
		case 15: System.out.println("The hex value is  F");
		break;
		default : System.out.println("Invalid input");
		}
	}
}
