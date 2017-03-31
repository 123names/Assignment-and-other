import java.util.ArrayList;
import java.util.Collections;


public class Step {

	ArrayList<String> steps = null;
	private int h = 0;
	private int g = 0;
	private int f = h+g;
	private boolean inOpen = false;
	private boolean inClose = false;
	private Step parent = null;
	
	public Step(int g,ArrayList<String> s){
		this.g = g;
		steps = s;
		f = g+h;
	}
	public Step(int generateHValue, int g2, ArrayList<String> startStep) {
		this.h = generateHValue;
		this.g= g2;
		steps = startStep;
		f = g+h;
	}
	public void setParent(Step parent){
		this.parent = parent;
	}
	public Step getParent(){
		return parent;
	}
	public void setInOpen(boolean inOpen){
		this.inOpen = inOpen;
	}
	public void setInClose(boolean inClose){
		this.inClose = inClose;
	}
	public boolean getInOpen(){
		return inOpen;
	}
	public boolean getInClose(){
		return inClose;
	}
	public ArrayList<String> getsteps(){
		return steps;
	}
	public void setHValue(int h){
		this.h = h;
		f= g+h;
	}
	public int getGValue(){
		return g;
	}
	public int getfValue(){
		return f;
	}
	public ArrayList<Step> generateChild(){
		ArrayList<Step> child = new ArrayList<Step>();
		int stepsSize = steps.size();
		for(int i = 0; i<stepsSize;i++){
			if(steps.get(i)==" "){
				if(i+1<stepsSize){
					ArrayList<String> tempChild = (ArrayList<String>) steps.clone();
					Collections.swap(tempChild, i, i+1);
					int currG = getGValue();
					Step newChild = new Step(1+currG,tempChild);
					child.add(newChild);
					// set to track
					newChild.setParent(this);
				}
				if(i+2<stepsSize){
					ArrayList<String> tempChild = (ArrayList<String>) steps.clone();
					Collections.swap(tempChild, i, i+2);
					int currG = getGValue();
					Step newChild = new Step(1+currG,tempChild);
					child.add(newChild);
					// set to track
					newChild.setParent(this);
				}
				if(i+3<stepsSize){
					ArrayList<String> tempChild = (ArrayList<String>) steps.clone();
					Collections.swap(tempChild, i, i+3);
					int currG = getGValue();
					Step newChild = new Step(2+currG,tempChild);
					child.add(newChild);
					// set to track
					newChild.setParent(this);
				}
				if(i-1>=0){
					ArrayList<String> tempChild = (ArrayList<String>) steps.clone();
					Collections.swap(tempChild, i, i-1);
					int currG = getGValue();
					Step newChild = new Step(1+currG,tempChild);
					child.add(newChild);
					// set to track
					newChild.setParent(this);
				}
				if(i-2>=0){
					ArrayList<String> tempChild = (ArrayList<String>) steps.clone();
					Collections.swap(tempChild, i, i-2);
					int currG = getGValue();
					Step newChild = new Step(1+currG,tempChild);
					child.add(newChild);
					// set to track
					newChild.setParent(this);
				}
				if(i-3>=0){
					ArrayList<String> tempChild = (ArrayList<String>) steps.clone();
					Collections.swap(tempChild, i, i-3);
					int currG = getGValue();
					Step newChild = new Step(2+currG,tempChild);
					child.add(newChild);
					// set to track
					newChild.setParent(this);
				}
			}
		}
		return child;
	}
	public void printStep(){
		for(int i = 0; i<steps.size();i++){
			System.out.print(steps.get(i));
		}
		System.out.print("    G Value for current step is " + getGValue() + ". F value for current step is " + getfValue());
		System.out.println();
	}
}
