import java.util.Scanner;
public class test {

	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		System.out.print("Please input a number: ");
		int value = input.nextInt();
		if(value/2 %2 !=0){
			System.out.println("Is prime");
		}
		
	}
}
