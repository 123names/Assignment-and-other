package genetic_algorithm_AI;

public class candidate_object implements Comparable<candidate_object> {

	private String content;
	private int fitness = 0;
	public candidate_object(String content){
		this.content = content;
	}
	public void setFitness(int fitness){
		this.fitness = fitness;
	}
	public int getFitness(){
		return fitness;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent(){
		return content;
	}
	@Override
	public int compareTo(candidate_object o) {
		if(this.getFitness() > o.getFitness()){
			return -1;
		}
		else if (this.getFitness() == o.getFitness()){
			return 0;
		}
		else{
			return 1;
		}
	}
}
