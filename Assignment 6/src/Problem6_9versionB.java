import java.util.Scanner;


public class Problem6_9versionB {
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter ten numbers: ");
		double[] numbers = new double[10];
		for(int i = 0; i <numbers.length; i ++ ){
			numbers[i] = input.nextDouble();
		}
		System.out.println("The minimum number is " + min(numbers));
	}
	public static double min(double [] numbers ){
		double min = numbers[0];
		for(int i =0; i <numbers.length; i++){
			if (min>numbers[i]){
				min = numbers[i];
			}
		}return min;
	}
}


