
public class divide_and_conquer_InversionInArray {

	public static int [] a = {9, 8, 4, 5};
	public static int [] temp;
	public static void main(String [] args){
		System.out.print("For following array: ");
		for(int i = 0; i<a.length;i++){
			System.out.print(a[i]+ " ");
		}
		System.out.println();
		int result = 0;
		divide_and_conquer_InversionInArray test = new divide_and_conquer_InversionInArray();
		result = test.divideProcess(0,a.length-1);
		System.out.println("The number of inversions is " + result);
	}
	public int divideProcess(int lowIndex, int highIndex){
		int inversionCount = 0;
		if(lowIndex<highIndex){
			int median = (lowIndex + highIndex)/2;
			inversionCount=divideProcess(lowIndex,median);
			inversionCount+=divideProcess(median+1,highIndex);
			inversionCount+= conquerProcess(lowIndex,median+1,highIndex);
		}
		return inversionCount;
	}
	public int conquerProcess(int lowIndex, int middle, int highIndex){
		temp = new int[a.length];
        for (int i = lowIndex; i <= highIndex; i++) {
            temp[i] = a[i];
        }
		int i = lowIndex;
		int j = middle;
		int k = lowIndex;
		int inversionCount = 0;
		while(i<=middle&&j<=highIndex){
			if(temp[i]<temp[j]){
				a[k] = temp[i];
				i++;
			}
			else{
				a[k] = temp[j];
				j++;
				inversionCount = inversionCount+(middle-i);
				//System.out.println(inversionCount + " test");
			}
			k++;
		}
        while (i <= middle-1) {
            a[k] = temp[i];
            k++;
            i++;
        }
        while(j<=highIndex){
        	a[k] = temp[j];
        	j++;
        	k++;
        }
        return inversionCount;
	}
}
