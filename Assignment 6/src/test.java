import java.util.Scanner;

  public class test {
  public static void main(String[] args) {
	  		
	  		Scanner input = new Scanner(System.in);
	  		
	  		int [] numbers = new int [100];
	  		System.out.print("Enter the integer between 1 and 100: ");
	  		
	  			for(int i = 0; i < numbers.length; i ++){
	  				numbers[i] = input.nextInt();
	  				int count = 0;
	  				if(numbers[i]==0){
	  					i = numbers.length;
	  			 }
	  			  for(int j =0; j<numbers.length; j++){
	  				  if (numbers[i]==numbers[j]){
	  					count++;
	  				}
	  			  }
	  				  if(count>1){
	  					System.out.println(numbers[i] + " occurs " + count + " times. ");
	  				}
	  			      if (count ==1){
	  					System.out.println(numbers[i] + " occurs 1 time." );
	  				}
	  			      else{
	  			    	
	  			    }
	  				
	  			}
	  		}
	  		
	  	}
	  