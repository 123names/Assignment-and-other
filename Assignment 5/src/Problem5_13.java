import java.util.Scanner;
public class Problem5_13 {

	public static void main(String []args){
		
		Scanner input = new Scanner (System.in);
		System.out.print("Please input numbers you want to display : ");
		double i = input.nextDouble();
		System.out.println("i                 m(i)");
		System.out.printf("%15s\n", "----------------------");
		table(i, 0);
		
	}
	public static void table(double i,double m){
		for(int j = 0; j <i;j++){
			 double count= j+1;
			 double a  = count/++count;
			 m= m +a;
			 System.out.printf("%-2d%20.4f\n",(j+1), m);
		}
	}
}
