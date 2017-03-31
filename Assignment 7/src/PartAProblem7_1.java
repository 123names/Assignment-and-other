import java.util.Scanner;
public class PartAProblem7_1 {

	public static void main(String []args){
		
		Scanner input = new Scanner(System.in);
		double[][] numbers = new double [3] [4];
		System.out.println("Please enter a 3-by-4 matrix row by row: ");
		for(int i = 0; i<numbers.length; i++){
			for(int j = 0; j<numbers[2].length;j++){
				numbers[i][j] = input.nextInt();
			}

		}
		for(int i = 0; i<numbers[0].length; i++){
		System.out.println("Sum of elements at column " + i + " is " + sumColumn(numbers, i));
		}
	}
	public static double sumColumn(double[][]m, int columnIndex){
		double sum = 0;
		for(int i =0; i<m.length; i++){
				sum += m[i][columnIndex];
		}
		return sum;
	}
}
