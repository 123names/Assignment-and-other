import java.util.Scanner;
public class Question2_5 {

	public static void main(String[]args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the subtotal and gratuity rate: ");
		double subtotal = input.nextDouble();
		double gratuity = input.nextDouble();
		double  gratuity1 = subtotal * (gratuity/100);
		double total = gratuity1 + subtotal;
		System.out.print("The gratuity is $" + gratuity1 + ", and the total is $" + total);
	}
}
