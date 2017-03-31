
public class testQueue {
	
	public static void main(String []args){
		MyQueue nQueue = new MyQueue();
		int count = 0;
		while(count<50){
			int ranNum = (int)(1+Math.random()*100);
			nQueue.enqueue(ranNum);
			count++;
		}
		nQueue.print();
		nQueue.sort();
	}
}
