
public class link {
	
	private int source;
	private int dest;
	private int weight;
	
	public link(int s, int d , int w){
		source = s;
		dest = d;
		weight = w;
	}
	public int getS(){
		return source;
	}
	public int getD(){
		return dest;
	}
	public int getW(){
		return weight;
	}
}
