import java.util.Scanner;
public class Exercise15_11 {

	public static void main(String []args){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the radius of first circle: ");
		GeometricObject circle1 = new Circle(input.nextDouble());
		System.out.println("Please input the radius of second circle: ");
		GeometricObject circle2 = new Circle(input.nextDouble());
	    System.out.println("Is first circle equal second circle? " + circle1.equals(circle2));
	    System.out.println(((Circle)circle1).compareTo((Circle)circle2));
	}
}
