import java.util.Scanner;

public class Exercise20_23 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a binary number: ");
    String bin = input.nextLine();
    System.out.println(bin + " is decimal " + binaryToDecimal(bin));
  }  

  
  public static int binaryToDecimal(String binString) {
	  if(binString.length()==0){
		  return 0;
	  }
	      int number = Integer.parseInt(binString.charAt(binString.length()-1)+"",10);
	      
	return  number+2*binaryToDecimal(binString.substring(0, (binString.length()-1)));
  }
}