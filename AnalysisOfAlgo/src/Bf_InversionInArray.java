
public class Bf_InversionInArray {

	public static void main (String []args){
		int result = 0;
		int [] a = {9, 8, 4, 5};
		Bf_InversionInArray test = new Bf_InversionInArray();
		result = test.findNumOfInversion(a);
		
		System.out.println("The number of inversions is " + result);
	}
	private int findNumOfInversion(int [] a){
		int countInversion = 0;
		for(int i = 0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]>a[j]){
					System.out.println("Inversion: " + a[i] + ">" + a[j]);
					countInversion++;
				}
			}
		}
		return countInversion;
	}
}
