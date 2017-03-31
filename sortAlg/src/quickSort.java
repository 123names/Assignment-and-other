public class quickSort {
	static int [] array;
	public static void main(String []arg){
		int [] test  = {21,38,52,19,30,53,19,55,16,21};
	    for(int i:test){
	        System.out.print(i);
	        System.out.print(" ");
	    }
	    System.out.println();
		quickSortAl(test);
		System.out.print("Result: ");
	    for(int i:test){
	        System.out.print(i);
	        System.out.print(" ");
	    }
	}
	public static void quickSortAl(int[] inputArr){
	    if (inputArr == null || inputArr.length == 0) {
	    	System.out.println("Array is null or it is empty.");
	    }
	    else{
		    array = inputArr;
		    partition(0, (inputArr.length - 1));
	    }
	}
	public static void partition(int lowerIndex,int upperIndex){
	    int l = lowerIndex;
	    int u = upperIndex;
	    int pivot = array[lowerIndex+(upperIndex-lowerIndex)/2];
	    System.out.println("prvot is " + pivot);
	    while(l<u){
	    	while(array[l]<pivot){
	    		l++;
	    	}
	    	while(array[u]>pivot){
	    		u--;
	    	}
	    	if(l<=u){
	    		System.out.print("Position " + (l+1) + " number is " + array[l] +" will switch with ");
		    	System.out.println("Position " + (u+1) + " number is " + array [u]);
	            exchangeNumbers(l, u);
	            l++;
	            u--;
	    	}
	    }
	    if (lowerIndex < u){
	    	partition(lowerIndex, u);
	    }
	    if (l < upperIndex){
	    	partition(l, upperIndex);
	    }
	}
	private static void exchangeNumbers(int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	    for(int x:array){
	        System.out.print(x);
	        System.out.print(" ");
	    }
	    System.out.println();
	}
}


/*
public class MyQuickSort {
	
	private int array[];
	private int length;
		
	public void sort(int[] inputArr) {     
	    if (inputArr == null || inputArr.length == 0) {
	        return;
	    }
	    this.array = inputArr;
	    length = inputArr.length;
	    quickSort(0, length - 1);
	}
	
	private void quickSort(int lowerIndex, int higherIndex) {
	     
	    int i = lowerIndex;
	    int j = higherIndex;
	    // calculate pivot number, I am taking pivot as middle index number
	    int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
	    // Divide into two arrays
	    while (i <= j) {
	        while (array[i] < pivot) {
	            i++;
	        }
	        while (array[j] > pivot) {
	            j--;
	        }
	        if (i <= j) {
	            exchangeNumbers(i, j);
	            //move index to next position on both sides
	            i++;
	            j--;
	        }
	    }
	    // call quickSort() method recursively
	    if (lowerIndex < j)
	        quickSort(lowerIndex, j);
	    if (i < higherIndex)
	        quickSort(i, higherIndex);
	}
	
	private void exchangeNumbers(int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	}
	 
	public static void main(String a[]){
	     
	    MyQuickSort sorter = new MyQuickSort();
	    int[] input = {24,2,45,20,56,75,2,56,99,53,12};
	    sorter.sort(input);
	    for(int i:input){
	        System.out.print(i);
	        System.out.print(" ");
	    }
	}
}
*/