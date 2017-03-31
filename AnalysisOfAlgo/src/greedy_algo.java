import java.util.ArrayList;


public class greedy_algo {

	public static void main(String []args){
		ArrayList<Activity> activityList = new ArrayList<>();
		putActivity(activityList);
		System.out.println("The minimum number of lecture halls required is " + findMinimunLectureHall(activityList));
	}
	public static int findMinimunLectureHall(ArrayList<Activity> activityList){
		int lecture_halls_num = 0;
		
		while(!activityList.isEmpty()){
			lecture_halls_num++;
			if(activityList.size()==1){
				System.out.println("Lecture start at " + activityList.get(0).getStartTime() + " End at " + activityList.get(0).getFinishTime() + " will be hosted in lecture hall number " + lecture_halls_num);
				activityList.remove(0);
			}
			else{
				boolean roundContinue = true;
				int finishTime=0;
				while(roundContinue){
					int minStartTime = Integer.MAX_VALUE;
					int minIndex = 0;
					for(int i = 0; i<activityList.size();i++){
						if(activityList.get(i).getStartTime()-finishTime>=0&&activityList.get(i).getStartTime()<minStartTime){
							minStartTime = activityList.get(i).getStartTime();
							minIndex = i;
						}
					}
					finishTime = activityList.get(minIndex).getFinishTime();
					System.out.println("Lecture start at " + activityList.get(minIndex).getStartTime() + " end at " + activityList.get(minIndex).getFinishTime() + " will be hosted in lecture hall number " + lecture_halls_num);
					activityList.remove(minIndex);
					roundContinue = false;
					for(int i = 0;i<activityList.size();i++){
						if(activityList.get(i).getStartTime()-finishTime>=0){
							roundContinue = true;
							break;
						}
					}
				}
			}
		}
		return lecture_halls_num;
	}
	
	public static void putActivity(ArrayList<Activity> activityList){
		Activity a1 = new Activity(4,7);
		Activity a2 = new Activity(6,9);
		Activity a3 = new Activity(7,8);
		Activity a4 = new Activity(1,3);
		Activity a5 = new Activity(1,4);
		Activity a6 = new Activity(2,5);
		Activity a7 = new Activity(3,7);
		activityList.add(a1);
		activityList.add(a2);
		activityList.add(a3);
		activityList.add(a4);
		activityList.add(a5);
		activityList.add(a6);
		activityList.add(a7);
	}
}
