import java.util.Scanner;
public class TestForTriangle {

	public static void main(String []args){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please input 3 side: ");
		int side1 = input.nextInt();
		int side2 = input.nextInt();
		int side3 = input.nextInt();
		Triangle a = new Triangle(side1,side2,side3);
		System.out.println("Area is " + a.getArea());
		
	}
}
