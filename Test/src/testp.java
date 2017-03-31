import java.util.Scanner;

public class testp {

	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Number: ");
		int number = in.nextInt();
		
		boolean result = isPrime(number);
		if(result){
			System.out.println("Numebr "+ number +" is prime. ");
		}
		else{
			System.out.println("Numebr "+ number +" is not prime. ");
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
