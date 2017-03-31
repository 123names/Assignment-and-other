import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListQuest11_9 {

	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter array size n: ");
		int number = input.nextInt();
		ArrayList<Integer> row = new ArrayList<>();
		int[][] array = new int [number][number];
		
		for (int i = 0; i <array.length; i++){
			for (int j = 0; j <array[i].length; j++){
				array[i][j] =(int)(Math.random()*2);
	     }
	}
		for(int i =0; i <array.length; i++){
			System.out.println();
			for(int j =0; j<array[i].length; j++){
				System.out.print(array[i][j] + " ");
			}
		}
		System.out.println();
		System.out.println("The largest row index is " );
	}
}
