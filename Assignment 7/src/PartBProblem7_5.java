import java.util.Scanner;
public class PartBProblem7_5 {
	
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		double [][] array1 = new double [3][3];
		double [][] array2 = new double [3][3];
		double [][] add = new double [array1.length][array1[0].length];
		System.out.print("Please enter matrix1: ");
		for(int i =0; i<array1.length; i++){
			for(int j = 0; j<array1[i].length; j++){
				array1[i][j] = input.nextDouble();
			}
		}
		System.out.print("Please enter matrix2: ");
		for(int i =0; i<array2.length; i++){
			for(int j =0; j<array2[i].length; j++){
				array2[i][j] = input.nextDouble();
			}
		}
		add = addMatrix(array1, array2);
		System.out.println("The matrices are added as follows: ");
		for(int i = 0; i<array1.length; i++){
			for(int j =0; j<array1.length; j++){
				System.out.print(" " + array1[i][j]);
			}
			if(i == array1.length/2){
				System.out.print("  + ");
			}
			else{
				System.out.print("    ");
			}
			for(int j =0; j<array2.length; j++){
				System.out.print(" " + array2[i][j]);
			}
			if(i == array2.length/2){
				System.out.print("   = ");
			}
			else {
				System.out.print("     ");
			}
			for(int j = 0; j<add.length; j++){
				System.out.print(" " + add[i][j]);
			}
			System.out.println();
		}
		
	}
	public static double[][] addMatrix(double[][] a, double[][] b) {
		double [] [] add= new double [a.length] [a [0].length];
		for (int i = 0; i<a.length; i++){
			for(int j = 0; j<a[0].length; j++){
				add [i][j]= a[i][j]+b[i][j];
			}
		}
		return add;
	}

}
