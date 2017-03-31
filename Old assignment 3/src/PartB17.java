/* Cosc 1046  
 * question 3.17
 * Yan Gao
 * rock, scissor, paper
 * January 29, 2014
 */
import java.util.Scanner;

public class PartB17 {

	public static void main(String []args){
		
		System.out.print("Scissor (0), Rock (1), Paper (2): ");
		Scanner input = new Scanner(System.in);
		int player = input.nextInt();
		int computer = (int)(Math.random()*2);
		int scissor = 0;
		int rock = 1;
		int paper = 2;
		
		switch(computer){
		case 0: System.out.println("The computer is scissor. ");
		break;
		case 1: System.out.println("The computer is Rock. ");
		break;
		case 2: System.out.println("The computer is paper. ");
		break;
		}
		switch(player){
		case 0: System.out.println("You are scissor. ");
		break;
		case 1: System.out.println("You are rock. ");
		break;
		case 2: System.out.println("You are paper. ");
		break;
		}
		
		if(computer==2&&player==0){
			System.out.println("You win. ");
		}
		else if(computer==0&&player==2){
			System.out.println("Computer win. ");			
		}
		else if(computer<player){
			System.out.println("You win.");
		}
		else if(computer>player){
			System.out.println("Computer win. ");
		}
		else 
		    System.out.println("It is a draw. ");
		}
   }