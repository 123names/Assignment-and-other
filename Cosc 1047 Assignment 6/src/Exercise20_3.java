import java.util.Scanner;


public class Exercise20_3 {
	
		  public static void main(String[] args) {
		    Scanner input = new Scanner(System.in);
		    System.out.print("Enter first number: ");
		    int firstN = input.nextInt();
		    System.out.print("Enter second number: ");
		    int secondN = input.nextInt();
		    System.out.println("The gcd of " + firstN + " and "+ secondN + " is " + gcd(firstN,secondN));
		  }  
		  public static int gcd (int n, int m){
			  if(m==0){
				  return n;
			  }
			return gcd(m,n%m);
		  }
}
