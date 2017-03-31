
public class Item {
	
	private int value = 0;
	private int weight = 0;
	
	public Item(){
		
	}
	public Item(int value, int weight){
		this.value = value;
		this.weight = weight;
	}
	public int getValue(){
		return value;
	}
	public int getWeight(){
		return weight;
	}
	public Item addedItems(Item item){
		return new Item(this.value+item.getValue(), this.weight+item.getWeight());
	}
}
