import java.util.Scanner;
public class Problem6_27 {

	public static void main(String []args){
		
		Scanner input = new Scanner (System.in);
		boolean answer = false;
		System.out.print("Enter list1: ");
		int firstNum = input.nextInt();
		int[] list1 = new int [firstNum];
		for(int i = 0; i<list1.length; i++){
			list1[i]= input.nextInt();
		}
		System.out.println();
		System.out.print("Enter list2: ");
		int secondNum = input.nextInt();
		int []list2 = new int [secondNum];
		for(int i = 0; i<list2.length; i++){
			list2[i]= input.nextInt();
		}
		if(equals(list1, list2, answer)){
			System.out.println("Two list are idential. ");
		}
		else{
			System.out.println("Two list are not idential. ");
		}
	}
	public static boolean equals(int[]list1, int[]list2, boolean answer){
		int count = 0;
		for(int i =0; i<list1.length; i++){
			for(int j =0; j<list1.length; j++){
				if(list1[i] == list2[j]){
					count++;
					if (count ==list1.length){
						answer = true;
					}
				}
			}
		}
		return answer;
	}
}
