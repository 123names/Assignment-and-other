import java.util.Arrays;
import java.util.Scanner;


public class transform_and_conquer_check_equal {

	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int set_Size = 0;
		System.out.print("Enter the number of integers in the sets: ");
		set_Size = input.nextInt();
		int [] a = new int [set_Size];
		int [] b = new int [set_Size];
		System.out.print("Enter the first set: ");
		for(int i =0; i<a.length;i++){
			a[i] = input.nextInt();
		}
		System.out.print("Enter the second set: ");
		for(int i =0; i<a.length;i++){
			b[i] = input.nextInt();
		}
		input.close();
		Mergesort(a);
		Mergesort(b);
		if(areTwoSetEqual(a,b)){
			System.out.println("These two sets are equal. ");
		}
		else{
			System.out.println("These two sets are not equal. ");
		}
	}
	public static boolean areTwoSetEqual(int [] firstSet, int [] secondSet){
		if(firstSet.length!=secondSet.length){
			return false;
		}
		else{
			for(int i =0; i<firstSet.length;i++){
				if(firstSet[i]!=secondSet[i]){
					return false;
				}
			}
			return true;
		}
	}
	public static void Mergesort(int [] target){
		if(target.length>1){
			int median = target.length/2;
			int [] part1 = Arrays.copyOfRange(target, 0, median);
			int [] part2 = Arrays.copyOfRange(target, median, target.length);
			Mergesort(part1);
			Mergesort(part2);
			MergePart(part1,part2,target);
		}
	}
	public static void MergePart(int [] part1, int [] part2, int [] target){
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<part1.length && j<part2.length){
			if(part1[i]<=part2[j]){
				target[k] = part1[i];
				i++;
			}
			else{
				target[k] = part2[j];
				j++;
			}
			k++;
		}
		if(i==part1.length){
			while(j<part2.length){
				target[k] = part2[j];
				j++;
				k++;
			}
		}
		else{
			while(i<part1.length){
				target[k] = part1[i];
				i++;
				k++;
			}
		}
	}
}
