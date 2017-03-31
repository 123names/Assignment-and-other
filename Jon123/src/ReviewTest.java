import java.util.Scanner;
public class ReviewTest {

	public static void main(String []args){
		int a =6;
	displayPattern(a);
	}
	public static void displayPattern(int a){
		for(int i =1; i<=a;i++){
			for(int j =6; j>i; j--){
				System.out.print("  ");
			}
			for(int j =1; j<=i;j++){
				System.out.print(j +" ");
			}
			System.out.println();
		}
	}
}
