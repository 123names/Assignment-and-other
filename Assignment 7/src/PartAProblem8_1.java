import java.util.Scanner;
public class PartAProblem8_1 {

	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		System.out.print("Please input width and length of rectangle1: ");
		double width = input.nextDouble();
		double length = input.nextDouble();
		Rectangle Rectangle1= new Rectangle(width, length);
		System.out.println("The width of rectangle1 is " + width + " length is " + length + " area is " + Rectangle1.getArea() + " perimeter is " + Rectangle1.getPerimeter());
		System.out.print("Please input width and length of rectangle2: ");
		double width2 = input.nextDouble();
		double length2 = input.nextDouble();
		Rectangle Rectangle2 = new Rectangle(width2, length2);
		System.out.println("The width of rectangle2 is " + width2 + ", length is " + length2 + ", area is " + Rectangle2.getArea() + ", perimeter is " + Rectangle2.getPerimeter());
	}
}
