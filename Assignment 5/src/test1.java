import java.util.Scanner;

public abstract class test1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please input an integer: ");
		int number = input.nextInt();
		System.out.println("The reverse number of " + number + " is : "  + reversal(number));

		
	}

	  public static boolean isPrime(int num) {
	    for (int i = 2; i <= num / 2; i++) {
	      if (num % i == 0) {
	        return false;
	      }
	    }

	    return true;
	  }

	  /** Return the reversal of number */
	public  static int reversal(int number) {
	    int result = 0;

	    while (number != 0) {
	      int lastDigit = number % 10;
	      result = result * 10 + lastDigit;
	      number = number / 10;
	    }

	    return result;
	  }

	  /** Return true if number is palindromic */
	  static boolean isPalindrome(int number) {
	    return number == reversal(number);
	  }
}

