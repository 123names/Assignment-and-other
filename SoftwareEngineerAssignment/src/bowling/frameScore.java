package bowling;

public class frameScore {

	private int firstThrow = 0;
	private int secondThrow = 0;
	private int frameTotal = 0;
	private boolean spare = false;
	
	public frameScore(){
		
	}
	public boolean getSpare(){
		return spare;
	}
	public void setFirst(int num){
		firstThrow = num;
	}
	public void setSecond(int num){
		secondThrow = num;
	}
	public void setTotal(int num){
		frameTotal = num;
	}
	public void setTotal(int first, int second){
		frameTotal = first+second;
	}
	public void setSpare(boolean s){
		spare = s;
	}
	public void setStrike(int num, int num1){
		frameTotal = frameTotal + num+num1;
	}
	public void setLastStrike(int num, int num1){
		frameTotal = frameTotal + num+num1;
	}
	public void setSpare(int num){
		frameTotal = frameTotal+num;
	}
	public void setLastSpare(int num){
		frameTotal = frameTotal+num;
	}
	public int getFirst(){
		return firstThrow;
	}
	public int getSecond(){
		return secondThrow;
	}
	public int getTotal(){
		return frameTotal;
	}
}
