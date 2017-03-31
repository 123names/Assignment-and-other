import java.util.Scanner;
public class test {

	    public static void main(String[] args) {
	    	Scanner input = new Scanner(System.in);
	    	System.out.println("1.Checking Account.\n2. Saving Account.");
	    	int choice = input.nextInt();
	    	CheckAccount c = null;
	    	SavingAccount s = null;
	    	if (choice == 1){
	    		   c = new CheckAccount(10);
	    	}
	    	if (choice == 2){
	    		   s = new SavingAccount(10);
	    	}
	        System.out.println("You have " + c.getBalance()+ "$ on your account, how much do you want to withdraw?");
	        double number = input.nextDouble();
	        c.withdraw(number);
	        
	        System.out.println("You have " + c.getBalance() + " left."
	        		+ "You can deposit now, how much do you want to deposit?");
	        double number1 = input.nextDouble();
	        c.deposit(number1);
	        
	        System.out.println("Your Balance is " + c.getBalance() + " after you deposit " + number1);
	    }
	}

