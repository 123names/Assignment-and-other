import java.util.Scanner;

public class test {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a binary number: ");
    String bin = input.nextLine();
    System.out.println(bin + " is decimal "+ binaryPrint(bin) );
    
  }  

	public static int binaryPrint(String str){
		int dec=0;
		if(str.length()>1){
		int length = str.length();
		dec = (int) Math.pow(2, length-1)*Integer.parseInt(str.charAt(0)+"", 10);
		
		StringBuilder b = new StringBuilder(str);
		b.deleteCharAt(0);
		str=b.toString();
		
		dec += binaryPrint(str);
		return dec;
		}
		else{
			return dec = (int) (Math.pow(2,0))*Integer.parseInt(str.charAt(0)+"", 10);
		}
	}//

}
