package genetic_algorithm_AI;

public class positionCoordinate {

	private int x = 0;
	private int y = 0;
	private boolean reachGoal = false;
	private boolean reachMonster = false;
	public positionCoordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	public positionCoordinate() {
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void ReachMonster(boolean reachMonster){
		this.reachMonster = reachMonster;
	}
	public void ReachGoal(boolean reachGoal){
		this.reachGoal = reachGoal;
	}
	public boolean isReachGoal(){
		return reachGoal;
	}
	public boolean isReachMonster(){
		return reachMonster;
	}
}
