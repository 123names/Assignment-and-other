import java.util.Scanner;
import java.util.ArrayList;

public class testforArrayList {
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the array list size n: ");
		int size = input.nextInt();

		int matrix[][] = new int[size][size];

		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int) (Math.random() * 2);
			}
		}
		System.out.println("The random array is: ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {

			}

		}
		largestRowIndex(matrix);
		largestColIndex(matrix);
	}

	public static void largestRowIndex(int array[][]) {
		int Max = 0;
		int sum = 0;

		ArrayList<Integer> row = new ArrayList<>();

		for (int i = 0; i < array.length; i++) {

			sum = 0;//initialization sum 
			for (int j = 0; j < array[i].length; j++) {
				sum += array[i][j];//get sum
			}
			if (Max < sum) {
				Max = sum;

			}

		}

		for (int i = 0; i < array.length; i++) {
			sum = 0;
			for (int j = 0; j < array[i].length; j++) {
				sum += array[i][j];
			}

			if (sum == Max) {
				row.add(i);
			}
		}
		System.out.print("The largest row Index: ");
		for (int i = 0; i < row.size(); i++) {
			System.out.print(row.get(i) + " ");
		}

	}

	public static void largestColIndex(int array[][]) {
		int highestRow = 0;
		int sum = 0;

		ArrayList<Integer> col = new ArrayList<>();

		for (int i = 0; i < array.length; i++) {

			sum = 0;
			for (int j = 0; j < array[i].length; j++) {
				sum += array[j][i];
			}
			if (highestRow < sum) {
				highestRow = sum;

			}

		}

		for (int i = 0; i < array.length; i++) {
			sum = 0;
			for (int j = 0; j < array[i].length; j++) {
				sum += array[j][i];
			}

			if (sum == highestRow) {
				col.add(i);
			}
		}
		System.out.println();
		System.out.print("The largest coloumn Index: ");
		for (int i = 0; i < col.size(); i++) {
			System.out.print(col.get(i) + " ");
		}

	}
}
