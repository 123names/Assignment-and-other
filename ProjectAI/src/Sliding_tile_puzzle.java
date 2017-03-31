import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class Sliding_tile_puzzle {
	// create a pq that reorder items
	public static PriorityBlockingQueue<Step> open= new PriorityBlockingQueue<Step>(10 , new Comparator<Step>(){
		public int compare(Step step1,Step step2){
			if (step1.getfValue()<step2.getfValue()){
				return -1;
			}
			else if (step1.getfValue()==step2.getfValue()){
				return 0;
			}
			else{
				return 1;
			}
		}
	});
	public static ArrayList<Step> close = new ArrayList<Step>();

	public static void main(String []args){
		ArrayList<String> startStep = new ArrayList<String>();
		ArrayList<String> goalStep = goalStep();
		initial(startStep);
		//removeBlank(startStep);
		astar_algorithm(goalStep,0,startStep);
	}
	public static void astar_algorithm(ArrayList<String> goal,int g,ArrayList<String> startStep){
		Step firstStep = new Step(generateHValue(startStep),g,startStep);
		open.add(firstStep);
		while(!open.isEmpty()){
			Step currentStep = open.poll();
			ArrayList<String> checkSteptemp = (ArrayList<String>) currentStep.getsteps().clone();
			ArrayList<String> checkStep = removeBlank(checkSteptemp);
			if(goal.equals(checkStep)){
				System.out.print("Goal, The g value is ");
				System.out.println(currentStep.getGValue());
				System.out.println("Step track back: ");
				while(currentStep.getParent()!=null){
					currentStep.printStep();
					currentStep =currentStep.getParent();
				}
				firstStep.printStep();
				System.exit(0);
			}
			else{
				System.out.print("Current step: ");
				currentStep.printStep();
				ArrayList<Step> childrens = currentStep.generateChild();
				for(int i = 0; i<childrens.size();i++){
					// assignment each children h value
					int h = generateHValue(childrens.get(i).getsteps());
					childrens.get(i).setHValue(h);
					if(close.isEmpty()){
						System.out.print("First round: ");
						childrens.get(i).printStep();
						//add it to open
						open.add(childrens.get(i));
					}
					else{
						for (Step os : open) {
							if(childrens.get(i).getsteps().equals(os.getsteps())){
								/*
								System.out.print("Children " + i + " is  on open. It is ");
								childrens.get(i).printStep();
								*/
								childrens.get(i).setInOpen(true);
								// if reached by lower g value, switch
								if(childrens.get(i).getGValue()<os.getGValue()){
									open.remove(os);
									open.add(childrens.get(i));
									//System.out.println("Switch to open with better g value");
								}
								else{
									//System.out.println("Not switch in to open");
								}
							}
						}
						// never get to here because h value is Monotonic
						for(Step cs: close){
							if(childrens.get(i).getsteps().equals(cs.getsteps())){
								/*
								System.out.print("Children " + i + " is  on close. It is ");
								childrens.get(i).printStep();
								*/
								childrens.get(i).setInClose(true);
								// if reached by lower g value, move it from close and add it to open
								if(childrens.get(i).getGValue()<cs.getGValue()){
									close.remove(cs);
									open.add(childrens.get(i));
									//System.out.println("Switch to open from close");
								}
								else{
									//System.out.println("Not switch out of close.");
								}
							}
						}
						if(!childrens.get(i).getInOpen()&&!childrens.get(i).getInClose()){
							/*
							System.out.print("Children " + i + " is not in open and close. It is ");
							childrens.get(i).printStep();
							*/
							open.add(childrens.get(i));
						}
					}
				}
			}
			// add current step to close
			close.add(currentStep);
			// the pq i use will re order it self base on the comparator i created
		}
		//System.out.println("Fail to reach the goal");
	}
	public static int generateHValue(ArrayList<String> step){
		int counter = 0;
		for(int i = 0; i<step.size();i++){
			if(step.get(i).equals("B")){
				for(int j=i;j<step.size();j++){
					if(step.get(j).equals("W")){
						counter++;
					}
				}
			}
		}
		return counter;
	}
	public static void checkBlankRemovedOrNot(ArrayList<String> steps){
		while(!steps.isEmpty()){
			int i = 0;
			System.out.print(steps.get(i));
			steps.remove(i);
			i++;
		}
	}
	public static ArrayList<String> goalStep(){
		ArrayList<String> goal = new ArrayList<String>();
		goal.add("W");
		goal.add("W");
		goal.add("W");
		goal.add("B");
		goal.add("B");
		goal.add("B");
		return goal;
	}
	public static ArrayList<String> removeBlank(ArrayList<String> steps){
		steps.remove(" ");
		return steps;
	}
	public static void initial(ArrayList<String> startStep){
		startStep.add("B");
		startStep.add("B");
		startStep.add("B");
		startStep.add(" ");
		startStep.add("W");
		startStep.add("W");
		startStep.add("W");
	}
}
