package p2;

public class Semaphore extends java.util.concurrent.Semaphore{

	private int signal = 0;

	public Semaphore(int permits) {
		super(permits);
		signal = permits;
	}
	
	public void down() {
		signal--;
	}
	
	public void up(){
		signal++;
	}

}
