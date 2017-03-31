import java.util.Scanner;
public class TestForOctagon {

	public static void main(String []args) throws CloneNotSupportedException{
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please input the side of Octgon: ");
		Octagon number1 = new Octagon(input.nextDouble());
		System.out.println("The area for octagon is " + number1.getArea());
		System.out.println("The perimeter of octagon is " + number1.getPerimeter());
		Octagon number2 = (Octagon)number1.clone();
		System.out.println("Is clone work? It will print 0 if it's work: " + number1.compareTo(number2));
	}
}
