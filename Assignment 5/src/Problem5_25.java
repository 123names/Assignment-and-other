import java.util.Scanner;
public class Problem5_25 {

	public static void main(String[]args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please input how many millisecond you want to convert: ");
		long millis = input.nextLong();
		System.out.println(millis+ " millisecond is " + convertMillis(millis));
		
	}
	public static String convertMillis(long millis){
		long second = millis/1000;
		long min = second/60; 
		long hour = min/60;
		String time = hour + " : " + min%60 + " : " + second%60;
		return time;
	}
}
