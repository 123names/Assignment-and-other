
public class PartA {
	public static void main(String[]args){
		int sum = 0;
		int count = 0;
		int sum1 = 0;
		int count1 = 0;
		int largest = 0;
		int smallest = 0;
		int average = 0;
		int total = 0;
		int number1 = 0;
		System.out.println("The random numbers are : ");
		for(int i = 0; i <75; i++ ){
			number1= (int)(Math.random()*68-26);
				if(number1>=0){
					sum= sum + number1;	
					count ++;
					System.out.print( number1 + " ");
					if(count%10==0){
						System.out.println();
					}
			}

			    if(number1<0){
				sum1 = sum1 + number1;
				count1 ++;
				System.out.print( number1 + " ");
			}
			if(largest<number1){
				largest = number1;
			}
			if(smallest>number1){
				smallest = number1;
			}
			total = number1 + total;
			average = total/75;
		}
		System.out.println();
		System.out.println("There are " + count + " positive numbers and "  + count1 + " negative numbers. ");
		System.out.println("The average value of positive numbers is " + sum/count);
		System.out.println("The average value of negative numbers is " + sum1/count1);
		System.out.println("The largest number is " + largest);
		System.out.println("The smallest number is " + smallest);
		System.out.println("The average of all the numbers is " + average);
	}
}