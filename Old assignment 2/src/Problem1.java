import java.util.Scanner; 

public class Problem1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of years: ");
		int year = input.nextInt();
		int second = 365*24*60*60*year;
		double birth = (second/7);
		double death = (second/13);
		double immigrant = (second/45);
		int population =  (int) ((312032486)+birth-death+immigrant);
		System.out.println("The population in " + year + " years is " +population);
	}

}
