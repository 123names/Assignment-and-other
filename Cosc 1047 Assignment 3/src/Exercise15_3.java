import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Exercise15_3 {
  public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
    ArrayList<Number> list = new ArrayList<Number>();
    System.out.print("How many number do you want in array: ");
    int number = input.nextInt();
    int a =0;
    for(int i =0; i<number; i++){
    	a =i+1;
    	System.out.print("number " + a + " : ");
        list.add(input.nextInt());
    }
    shuffle(list);
        for (int i1 = 0; i1 < list.size(); i1++) 
            System.out.print(list.get(i1) + " ");
        }


  public static void shuffle(ArrayList<Number> list) {
	  Collections.shuffle(list);
    }
  }

