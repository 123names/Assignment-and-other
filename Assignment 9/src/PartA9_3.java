import java.util.Scanner;
public class PartA9_3 {

	public static void main(String []args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please input the password: ");
		String inputPassword = input.nextLine();
		char [] charOfPassword = new char [inputPassword.length()];
		int countForDigit = 0;
		String password = "568whatever";
		int a = 0;
		
		for(int i =0; i<inputPassword.length(); i++){
			charOfPassword [i] = inputPassword.charAt(i);
		}
		for(int i =0; i<inputPassword.length(); i++){ 
		     if(Character.isLetterOrDigit(charOfPassword[i])==false){
		    	 a =1;
	        	}
		     if(Character.isDigit(charOfPassword[i])){
		    	 countForDigit++;
		        }
	        }
		
		if(inputPassword.length()<8){
			System.out.println("Wrong password length. Invalid Password.");
    	}
		else if (a ==1){
			System.out.println("Only can input  letters and digits. Invalid Password.");
		}

		else if(countForDigit<2){
			System.out.println("No enough digit. Invalid Password.");
		}
		else if(inputPassword.equals(password)){
			System.out.println("Valid Password.");
		}
		else{
			System.out.println("Other input wrong. Invalid Password.");
		}
		
     }
 }
