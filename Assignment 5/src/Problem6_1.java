import java.util.Scanner;
public class Problem6_1 {

	public static void main(String []args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of students: ");
		int studentNum = input.nextInt();
		int[]score = new int[studentNum];
		char grade = 'D';

		System.out.print("Enter " + score.length + " scores: ");
		for(int i = 0; i<score.length; i++){
			score[i]=input.nextInt();
		}
		int max = score[0];
		for(int i = 0; i<score.length; i++){
			if(max<score[i]){
				max = score[i];
			}
		}
		for(int a = 0; a<score.length; a++){
			if ((max-10)<=score[a]){
				grade = 'A';
			}
			else if((max-20)<=score[a]){
				grade = 'B';
			}
			else if((max-30)<=score[a]){
				grade = 'C';
			}
			else if((max-40)<=score[a]){
				
				grade = 'D';
			}
			else{
				grade = 'F';
			}
			System.out.println("Student " + a + " score  is " + score[a]+ " and the grade is " + grade);
			
		}
	}
		
}


