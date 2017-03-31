/* Cosc 1046
 * Yan Gao 
 * number pyramid
 */
import java.util.Scanner;
public class Problem_4_17 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of lines: ");
		int number = input.nextInt();
		//Ask user for input
		if (number<1 || number>15){
			System.out.println("Wrong number. ");
		}
		else{
			
		int count = 1;
		do{
			for(int i= 15-count; i>0; i--){
				System.out.print("   ");
			}
			for(int i = count-1; i>0; i--){
				System.out.printf("%-3d",(i +1));
			}
			//left side of pyramid
			int num1 = 1;

			for(int i = 0; i <count; i++){
					System.out.printf("%-3d",num1);
					num1++;
				}
			//right side of pyramid
            System.out.println();
			count ++;
		}while(count<=number);
	  }
   }
}
