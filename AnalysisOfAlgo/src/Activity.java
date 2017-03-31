
public class Activity {

	private int startTime = 0;
	private int finishTiem = 0;
	public Activity(){
		
	}
	public Activity(int st, int ft){
		this.startTime = st;
		this.finishTiem = ft;
	}
	public int getStartTime (){
		return startTime;
	}
	public int getFinishTime(){
		return finishTiem;
	}
	public void setStartTime(int startTime){
		this.startTime = startTime;
	}
}
