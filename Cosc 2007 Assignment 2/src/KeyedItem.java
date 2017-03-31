// keyed item to store the item 
public class KeyedItem {
	private String item = null;
	public KeyedItem(){
		
	}
	public KeyedItem(String in){
		item = in;
	}
	public String getKey() {
		return item;
	}
	public int compareTo(String key) {
		return this.item.compareTo(key);

	}
	
}
