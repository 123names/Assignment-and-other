import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortArrayList {
	
	public static void main(String[] args) {
		
	    Scanner input = new Scanner(System.in);

	    ArrayList<Integer> list = new ArrayList<Integer>();
	    
	    System.out.print("Enter five integer numbers : ");
	    for (int i = 0; i < 5; i++){
	      list.add(input.nextInt());
	    }
	    sort(list);
	}
	public static void sort(ArrayList<Integer> list) {
		Collections.sort(list);
		System.out.print(list);
	}

}
