package t1;

public class Semaphore {
	private int sephamore = 0;
	
	public Semaphore(int n) {
		this.sephamore = n;
	}
	
	public void down() {
		this.sephamore--;
	}
	
	public void up(){
		this.sephamore++;
	}
}
