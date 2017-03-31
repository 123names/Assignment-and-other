import java.util.Scanner;

public class Question2 {

	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		int number = 0;
		try{
		System.out.print("Please input an integer(Power of 2): ");
		number = input.nextInt();
		if(number%2!=0){
			System.out.print("The integer you input is not a power of 2!!!");
		}
		else{
			Log2(number);
			Log1(number/2);
		}
	}
		catch(Exception e){
			System.out.println("You are not input an integer!!!");
		}
	}
	
	public static void Log1(int L){
		
		int n = (int) (Math.log(L)/Math.log(2));
		if(L>2){
			System.out.print(n);
			System.out.print(1);
			if(n>=4){
				System.out.print(1);
				System.out.print(Math.round(n/2));
			}
			Log1(L/2);
		}
		if(L<=2){
			System.out.print(0);
		}
	}
	
	public static void Log2(int L){
		
		int n = (int) (Math.log(L)/Math.log(2));

		if(L>2){
			Log2(L/2);
			if(n>=4){
				System.out.print(1);
				System.out.print(Math.round(n/2));
			}
			System.out.print(1);
			System.out.print(n);
		}
		if(n>=4){
			System.out.print(1);
			System.out.print(n/2);
			System.out.print(1);
		}
		if(L<=2){
			System.out.print(0);
		}
	}
}
