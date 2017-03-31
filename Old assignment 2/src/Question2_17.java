import java.util.Scanner;
public class Question2_17 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double fahrenheit = 0;
		double speed = 0;
		do {
			System.out.println("Enter the temperature in Fahrenheit: ");
			fahrenheit = input.nextDouble();
			if(-58>fahrenheit || fahrenheit> 41){
				System.out.println("Wrong answer, try again. ");
				
			}
		}while (-58> fahrenheit || fahrenheit>41);
		do {
			System.out.print("Enter the wind speed in miles per hours: ");
			speed = input.nextDouble();
			if(speed<2){
				System.out.println("Wrong answer, try again. ");
			}
		}while (speed <2);
		
		double index = 35.74 + (0.6215 * fahrenheit) - (35.75 * Math.pow(speed, 0.16)) + 0.4275 * Math.pow(speed, 0.16) * fahrenheit;
	    System.out.print("The wind chill index is " + index);
			}
	}
