package t1;

import java.util.ArrayList;

public class Item {
	int i = 0;
	int j = 0;
	
	/*public Item() {
		items = new ArrayList<Integer>();
	}*/

	public Item(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	@Override
	public String toString() {
		return ", and the item is " + j;
	}
	

}
