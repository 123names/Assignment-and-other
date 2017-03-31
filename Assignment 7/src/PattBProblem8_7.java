import java.util.Scanner;
public class PattBProblem8_7 {

	public static void main(String[]args){
		
		Scanner input = new Scanner(System.in);
		Account account1 = new Account();
		System.out.print("Please set Id, balance, and annual interest rate: ");
		account1.setId(input.nextInt());
		account1.setBalance(input.nextDouble());
		account1.setRate(input.nextDouble());
		account1.setDatecreated();
		System.out.println();
		System.out.println("The mounthly interest rate is " + account1.getMonthlyInterestRate());
		System.out.println("The monthly interest is " + account1.getMonthlyInterest());
		System.out.print("How much money you want to withdraw: ");
		System.out.println("You have " + account1.withdraw(input.nextInt()) + " left on you balance. ")  ;
		System.out.print("How much money you want to deposit: " );
		System.out.println("You have " + account1.deposit(input.nextInt()) + " left on you balance. ");
		}
}
