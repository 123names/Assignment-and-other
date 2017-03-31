/* Cosc 1046
 * Yan Gao
 * Conver Killogram to pounds and reverse.
 * 
 */
public class problem45 {

	public static void main(String[] args) {
		
		int kilograms = -1;
		int pounds = 15;
		double pound = 0;
		double kilogram = 0;
		//declear variable
		System.out.printf("%13s%9s%5s%10s%15s\n","Killograms","Pounds","|","Pounds","Killograms");
		while(kilograms<199){
			kilograms = kilograms + 2;
		    pound = (kilograms * 2.2);
		    //Work
		    	   System.out.printf("%8d%12.1f%7s", kilograms, pound ,"|");
		    	   if (pounds<515){
		    		   pounds = pounds + 5;
		   			kilogram = pounds * 0.453;
		   			//Work
		   			System.out.printf("%8d%12.2f\n", pounds,kilogram);
		    	   }
		}

	}
}
