import java.util.Scanner;
public class Problem5_3 {

	public static void main(String []args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please input an integer: ");
		int number = input.nextInt();
		if(isPalindrome(number) == true){
			System.out.println("The number " + number + " is a palindrome number. ");
		}
		else{
			System.out.println("The number " + number + " is not a palindrome number. ");
		}
	}
	public static int reverse(int number){
		int reverseNum = 0;
		while(number!= 0){
			int digit = number%10;
			reverseNum = reverseNum * 10 + digit;
			number= number/10 ;
		}
		
		return reverseNum;
	}
	public static boolean isPalindrome(int number){
	    return number==reverse(number);
	}
}
