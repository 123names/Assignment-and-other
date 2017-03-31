
public class optimal_plan_finder {

	public static void main(String []args){
		int [] lowStress = {10,1,10,10};
		int [] highStress = {5,50,5,1};
		System.out.println("Income table: ");
		System.out.print("l: ");
		for(int i=0;i<lowStress.length;i++){
			System.out.printf("%-4d",lowStress[i]);
		}
		System.out.println();
		System.out.print("h: ");
		for(int i=0;i<lowStress.length;i++){
			System.out.printf("%-4d",highStress[i]);
		}
		System.out.println();
		System.out.println("The value of the optimal plan is :" + optimalEarn(lowStress,highStress));
	}
	public static int optimalEarn(int []lowStress, int []highStress){
		int totalWeek = lowStress.length;
		int totalValue[] = new int [lowStress.length];
		int lowStressTotal = 0;
		System.out.println("Optimal Schedul: ");
		for(int i=0; i<totalWeek; i++){
			if(i==0){
				lowStressTotal += lowStress[i];
				totalValue[i] = lowStress[i];
				System.out.println("Week "+ (i+1)+", choice low stress.");
			}
			else{
				lowStressTotal += lowStress[i];
				if(highStress[i]>lowStressTotal){
					totalValue[i] =highStress[i];
					System.out.println("Week "+ (i+1)+", choice high stress.");
					System.out.println("Schedul change for Week "+ (i)+", choice prepare for high stress work.");
				}
				else{
					totalValue[i] = totalValue[i-1] + lowStress[i];
					System.out.println("Week "+ (i+1)+", choice low stress.");
				}
				lowStressTotal = lowStress[i];
			}
		}
		System.out.println("Result table (Total Value): ");
		for(int i = 0; i<totalValue.length;i++){
			System.out.printf("%-4d",totalValue[i]);
		}
		System.out.println();
		return totalValue[totalWeek-1];
	}
}
