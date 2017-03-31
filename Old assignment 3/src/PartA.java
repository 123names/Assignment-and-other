import java.util.Scanner;

public class PartA {

	public static void main(String[] args) {
		
		System.out.print("Please input an interger: ");
		Scanner input = new Scanner(System.in);
		int number1 = input.nextInt();
		
		boolean result1 = number1 % 3 == 0 && number1 % 11 ==0 ;		
		System.out.println("Is " + number1 + " divisible by 3 and 11? " + result1 );  
		
		boolean result2 = number1 % 3 == 0 || number1 %11 ==0 ;
		System.out.println("Is " + number1 + " divisible by 3 or 11? " + result2 );
		
		boolean whatever = number1 % 3 == 0 ^ number1 %11 ==0;
		System.out.println("Is " + number1 + " divisible by 3 or 11 but not both ? " + whatever );
		}
		
	}

