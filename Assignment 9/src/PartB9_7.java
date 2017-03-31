import java.util.Scanner;
public class PartB9_7 {

	public static void main(String []args){
		
		Scanner input = new Scanner(System.in);
		StringBuilder phoneNumber = new StringBuilder();
		System.out.print("Enter a string: ");
		phoneNumber.append(input.nextLine());
		char [] charOfNumber = new char [phoneNumber.length()];
		
		for(int i =0; i<phoneNumber.length(); i++){
			charOfNumber [i]= phoneNumber.charAt(i);
		}
		
		for(int i =0; i<phoneNumber.length(); i++){
		    if(Character.isLetter(charOfNumber[i])){
		    	charOfNumber[i] = Character.toUpperCase(charOfNumber[i]);
		    	phoneNumber.replace(i, i+1, getNumber(charOfNumber[i]));
		     }
	    }
		System.out.print(phoneNumber);
}
	public static String getNumber(char uppercaseletter){
		String number = null;
		if(uppercaseletter=='A'||uppercaseletter=='B'||uppercaseletter=='C'){
			number ="2";
		}
		if(uppercaseletter=='D'||uppercaseletter=='E'||uppercaseletter=='F'){
			number ="3";
		}
		if(uppercaseletter=='G'||uppercaseletter=='H'||uppercaseletter=='I'){
			number ="4";
		}
		if(uppercaseletter=='J'||uppercaseletter=='K'||uppercaseletter=='L'){
			number ="5";
		}
		if(uppercaseletter=='M'||uppercaseletter=='N'||uppercaseletter=='O'){
			number ="6";
		}
		if(uppercaseletter=='P'||uppercaseletter=='Q'||uppercaseletter=='R'||uppercaseletter =='S'){
			number ="7";
		}
		if(uppercaseletter=='T'||uppercaseletter=='U'||uppercaseletter=='V'){
			number ="8";
		}
		if(uppercaseletter=='W'||uppercaseletter=='X'||uppercaseletter=='Y'||uppercaseletter=='Z'){
			number ="9";
		}
		return number;
	}
	
	
}
