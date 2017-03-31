import java.util.Scanner;
public class partA5_17 {

	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter n: ");
		int number = input.nextInt();
		
		printMatrix(number);
	}
	public static void printMatrix(int n){
		
		for (int i = 0; i <n; i++){
			System.out.println();
		for (int j = 0; j <n; j++){
			double a =Math.random()*2;
	     	System.out.printf("%3d", (int)a);
			}
		}
	}
}
