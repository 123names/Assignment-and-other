import java.util.ArrayList;


public class Bf_KnapsackProblem {

	private static ArrayList<Item> allConbineSet = new ArrayList<Item>();
	public static void main(String [] args){
		int maxWeight = 9;
		Item test1 = new Item(20,8);
		Item test2 = new Item(10,4);
		Item test3 = new Item(11,5);
		ArrayList<Item> listItems = new ArrayList<Item>();
		listItems.add(test1);
		listItems.add(test2);
		listItems.add(test3);
		
		Bf_KnapsackProblem test = new Bf_KnapsackProblem();
		test.findTotalPossibleResultSet(listItems);
		System.out.print("Total weight of subset: ");
		for(int i =0; i<allConbineSet.size();i++){
			System.out.printf("%3d",allConbineSet.get(i).getWeight());
		}
		System.out.println();
		System.out.print("Total value  of subset: ");
		for(int i =0; i<allConbineSet.size();i++){
			System.out.printf("%3d",allConbineSet.get(i).getValue());
		}
		System.out.println();
		System.out.println("The largest value that fits into the knapsack: " + test.findLargestValueFit(maxWeight));
	}
	public ArrayList<Item> findTotalPossibleResultSet(ArrayList<Item> listItems){
		if(listItems.isEmpty()){
			//listItems.add(new Item(0,0));
			allConbineSet.add(new Item(0,0));
		}
		else{
			ArrayList<Item> temp = new ArrayList<Item>();
			allConbineSet.add(listItems.get(0));
			for(int i = 0; i<allConbineSet.size();i++){
				if(i==allConbineSet.size()-1){
				}
				else{
					temp.add(allConbineSet.get(allConbineSet.size()-1).addedItems(allConbineSet.get(i)));
				}
			}
			allConbineSet.addAll(temp);
			listItems.remove(0);
			listItems.addAll(findTotalPossibleResultSet(listItems));
		}
		return listItems;
	}
	public int findLargestValueFit(int maxWeight){
		int largestValue = 0;
		for(int i = 0; i<allConbineSet.size();i++){
			if(allConbineSet.get(i).getWeight()<=maxWeight){
				if(largestValue<allConbineSet.get(i).getValue()){
					largestValue = allConbineSet.get(i).getValue();
				}
			}
		}
		return largestValue;
	}
}
