import java.util.*;
public class testforsort {

	public static void main(String []args){
		int [] a = new int [10];
		for (int i = 0; i <a.length;i++){
			a[i] = (int)(1+Math.random()*100);
		}
		for(int i = 0; i<a.length;i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		bubbleSort(a,a.length);
		for(int i = 0; i<a.length;i++){
			System.out.print(a[i] + " ");
		}
	}
	public static void bubbleSort(int[] a, int n) {

		for (int pass = 1; pass <= n; pass++) {
			
		      for (int index = 0; index < n-pass; index++) {
		    	  
			  int nextIndex = index + 1;  
		         if (a[index]>a[nextIndex]){
		            // exchange items
		            int temp = a[index];
		            a[index] = a[nextIndex];
		            a[nextIndex] = temp;
		         }  // end if
		      }  // end for
		}  // end for
	}  // end bubbleSort
}
