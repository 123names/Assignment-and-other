package genetic_algorithm_AI;

import java.util.Arrays;
import java.util.Random;

public class genetic_algorithm {

	final static int MAP[][] = 
	    	 {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		      {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 4, 0, 1},
		      {2, 0, 0, 0, 0, 4, 0, 0, 1, 1, 1, 0, 0, 0, 1},
		      {1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1},
		      {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1},
		      {1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1},
		      {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
		      {1, 4, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 3},
		      {1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 4, 0, 0, 0, 1},
		      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
	public static void main(String [] args){
		geneticFunction();
	}
	public static candidate_object [] generatePopulation(int populationSize){
		candidate_object [] population = new candidate_object [populationSize];
		for (int i = 0;i<populationSize;i++){
			// change candidate size
			population[i] = generateCandidate(40);
		}
		return population;
	}
    public static candidate_object generateCandidate(int candidateSize){
    	String candidate_string = "";
    	Random rn = new Random();
    	for(int i =0;i<candidateSize;i++){
            int bin = rn.nextInt(4);
            candidate_string += String.format("%2s", Integer.toBinaryString(bin)).replace(' ', '0');
    	}
    	candidate_object candidate = new candidate_object(candidate_string);
        return candidate;
    }
	public static void geneticFunction(){
		int generation = 0;
		// change population size by only change value here
		candidate_object [] currentPopulation = generatePopulation(10);
		int MaxfitValue = 0;
		while(MaxfitValue<80){
			MaxfitValue = findMaxFit(currentPopulation);
			Random rn = new Random();
			// save first 5 better fitness over rest with children
			// crossover
			for(int i =5;i<currentPopulation.length;i++){
				candidate_object betterFitCanadidate1 = rouletteWheel(rn.nextDouble(),currentPopulation);
				candidate_object [] currentPopulationCopy = new candidate_object[(currentPopulation.length-1)];
				int counter = 0;
				int counterCopy = 0;
				while(counter<currentPopulation.length){
					if(currentPopulation[counter].equals(betterFitCanadidate1)){
						counter++;
						if(counter>=currentPopulation.length){
							break;
						}
					}
					currentPopulationCopy[counterCopy] = currentPopulation[counter];
					counter++;
					counterCopy++;
				}
				candidate_object betterFitCanadidate2 = rouletteWheel(rn.nextDouble(),currentPopulationCopy);
				// replace rest population where array sorted with least fitness will have higher index
				currentPopulation[i] = genetic_Operator_Crossover(betterFitCanadidate1, betterFitCanadidate2);
			}
			// mutation, mutation rate can be changed by change the 0.00125 only
			currentPopulation = genetic_Operator_Mutation(currentPopulation,0.00125);
			System.out.println("Generation: " + generation);
			generation ++;
		}
		candidate_object goal = null;
		for(int i =0;i<currentPopulation.length;i++){
			if(currentPopulation[i].getFitness()==80){
				goal = currentPopulation[i];
			}
		}
		printGoal(goal.getContent());
	}
	public static void printGoal(String goalString){
		positionCoordinate pos = new positionCoordinate();
		for(int i =0; i <MAP.length;i++){
			for(int j =0; j<MAP[i].length;j++){
				if(MAP[i][j] ==2){
					pos.setX(i);
					pos.setY(j);
				}
			}
		}
		for(int i =0;i<goalString.length();i+=2){
			String step = goalString.substring(i, i+2);
			if(pos.isReachGoal()){
				break;
			}
			else{
				mapMappingPrintDirection(step, pos);
			}
		}
		System.out.println("Goal Reached");
	}
	public static void mapMappingPrintDirection(String step, positionCoordinate pos){
		// 00 means go left
		if(step.equals("00")){
			if(pos.getY() !=0){
				if(MAP[pos.getX()][pos.getY()-1] ==0){
					System.out.println("Vaild Move left");
					pos.setY(pos.getY()-1);
				}
				else if(MAP[pos.getX()][pos.getY()-1] == 3){
					pos.setY(pos.getY()-1);
					System.out.println("Vaild Move left");
					pos.ReachGoal(true);
				}
				else{
					System.out.println("Invaild Move Left");
				}
			}
		}
		// 01 means go top
		else if(step.equals("01")){
			if(MAP[pos.getX()-1][pos.getY()] ==0){
				System.out.println("Vaild Move top");
				pos.setX(pos.getX()-1);
			}
			else if(MAP[pos.getX()-1][pos.getY()] == 3){
				pos.setX(pos.getX()-1);
				System.out.println("Vaild Move top");
				pos.ReachGoal(true);
			}
			else{
				System.out.println("Invaild Move top");
			}
		}
		// 10 means go right
		else if(step.equals("10")){
			if(MAP[pos.getX()][pos.getY()+1] ==0){
				System.out.println("Vaild Move right");
				pos.setY(pos.getY()+1);
			}
			else if(MAP[pos.getX()][pos.getY()+1] == 3){
				pos.setY(pos.getY()+1);
				System.out.println("Vaild Move right");
				pos.ReachGoal(true);
			}
			else{
				System.out.println("Invaild Move right");
			}
		}
		// 11 means go bottom
		else{
			if(MAP[pos.getX()+1][pos.getY()] ==0){
				System.out.println("Vaild Move bottom");
				pos.setX(pos.getX()+1);
			}
			else if(MAP[pos.getX()+1][pos.getY()] == 3){
				pos.setX(pos.getX()+1);
				System.out.println("Vaild Move bottom");
				pos.ReachGoal(true);
			}
			else{
				System.out.println("Invaild Move bottom");
			}
		}
	}
	public static candidate_object [] genetic_Operator_Mutation(candidate_object [] currentPopulation, double mutationRate){
		int totalBitCount = 0;
		for(int i = 0;i<currentPopulation.length;i++){
			totalBitCount +=currentPopulation[i].getContent().length();
		}
		int randomTimes = (int) (totalBitCount*mutationRate);
		for(int i =0;i<randomTimes;i++){
			int populationIndex = (int) (Math.random()*(currentPopulation.length-1));
			int bitLocation = (int) (Math.random()*((totalBitCount/currentPopulation.length)-1));
			char[] myNameChars = currentPopulation[populationIndex].getContent().toCharArray();
			if(myNameChars[bitLocation] == '0'){
				myNameChars[bitLocation] = '1';
			}
			else{
				myNameChars[bitLocation] = '0';
			}
			currentPopulation[populationIndex].setContent(String.valueOf(myNameChars));
		}
		return currentPopulation;
	}
	public static candidate_object genetic_Operator_Crossover(candidate_object parent1,candidate_object parent2){
		candidate_object child = null;
		String part1 = parent1.getContent().substring(0, (parent1.getContent().length()/2));
		String part2 = parent2.getContent().substring((parent2.getContent().length()/2), parent2.getContent().length());
		String result = part1.concat(part2);
		child = new candidate_object(result);
		return child;
	}
	public static candidate_object rouletteWheel (double randomValue,candidate_object [] currentPopulation){
		int totalFitCurrentPopulation = 0;
		for(int i =0;i<currentPopulation.length;i++){
			totalFitCurrentPopulation= totalFitCurrentPopulation+currentPopulation[i].getFitness();
		}
		double value =randomValue* totalFitCurrentPopulation;	
		int parentIndex = -1;
		for(int i=0; i<currentPopulation.length; i++) {		
			value -= currentPopulation[i].getFitness();		
			if(value <= 0){
				parentIndex = i;
				break;
			}
		}
		return currentPopulation[parentIndex];
	}
	public static int findMaxFit(candidate_object [] currentPopulation){
		for (int i = 0;i<currentPopulation.length;i++){
			currentPopulation[i].setFitness(fitness(currentPopulation[i].getContent()));
		}
		Arrays.sort(currentPopulation);
		return currentPopulation[0].getFitness();
	}
	public static int fitness(String candidate){
		//get current position
		positionCoordinate pos = new positionCoordinate();
		for(int i =0; i <MAP.length;i++){
			for(int j =0; j<MAP[i].length;j++){
				if(MAP[i][j] ==2){
					pos.setX(i);
					pos.setY(j);
				}
			}
		}
		// map to find how close to goal
		for(int i =0; i<candidate.length(); i=i+2){
			String step = candidate.substring(i, i+2);
			if(pos.isReachMonster()||pos.isReachGoal()){
				break;
			}
			else{
				pos = mapMapping(step, pos);
			}
		}
		return distanceToGoal(pos);
	}
	public static positionCoordinate mapMapping(String step, positionCoordinate pos){
		// 00 means go left
		if(step.equals("00")){
			if(pos.getY() !=0){
				if(MAP[pos.getX()][pos.getY()-1] ==0){
					pos.setY(pos.getY()-1);
				}
				else if(MAP[pos.getX()][pos.getY()-1] == 3){
					pos.setY(pos.getY()-1);
					pos.ReachGoal(true);
				}
				else if(MAP[pos.getX()][pos.getY()-1] == 4){
					pos.setY(pos.getY()-1);
					pos.ReachMonster(true);
				}
				else{
					
				}
			}
		}
		// 01 means go top
		else if(step.equals("01")){
			if(MAP[pos.getX()-1][pos.getY()] ==0){
				pos.setX(pos.getX()-1);
			}
			else if(MAP[pos.getX()-1][pos.getY()] == 3){
				pos.setX(pos.getX()-1);
				pos.ReachGoal(true);
			}
			else if(MAP[pos.getX()-1][pos.getY()] == 4){
				pos.setX(pos.getX()-1);
				pos.ReachMonster(true);
			}
			else{
				
			}
		}
		// 10 means go right
		else if(step.equals("10")){
			if(MAP[pos.getX()][pos.getY()+1] ==0){
				pos.setY(pos.getY()+1);
			}
			else if(MAP[pos.getX()][pos.getY()+1] == 3){
				pos.setY(pos.getY()+1);
				pos.ReachGoal(true);
			}
			else if(MAP[pos.getX()][pos.getY()+1] == 4){
				pos.setY(pos.getY()+1);
				pos.ReachMonster(true);
			}
			else{
				
			}
		}
		// 11 means go bottom
		else{
			if(MAP[pos.getX()+1][pos.getY()] ==0){
				pos.setX(pos.getX()+1);
			}
			else if(MAP[pos.getX()+1][pos.getY()] == 3){
				pos.setX(pos.getX()+1);
				pos.ReachGoal(true);
			}
			else if(MAP[pos.getX()+1][pos.getY()] == 4){
				pos.setX(pos.getX()+1);
				pos.ReachMonster(true);
			}
			else{
				
			}
		}
		return pos;
	}
	public static int distanceToGoal(positionCoordinate pos){
		int fitValue = 10;
		if(pos.isReachMonster()){
			fitValue = 0;
		}
		else if(pos.isReachGoal()){
			System.out.print("Goal found in population, last generation: ");
			fitValue = 80;
		}
		else{
			positionCoordinate goalPos = new positionCoordinate();
			for(int i =0; i <MAP.length;i++){
				for(int j =0; j<MAP[i].length;j++){
					if(MAP[i][j] ==3){
						goalPos.setX(i);
						goalPos.setY(j);
					}
				}
			}
			int distanceValue = Math.abs(goalPos.getX() - pos.getX()) + Math.abs(goalPos.getY() - pos.getY());
			if(distanceValue>15){
				fitValue = 20;
			}
			if (distanceValue<=15){
				fitValue = 40;
			}
			if (distanceValue<=10){
				fitValue = 60;
			}
		}
		return fitValue;
	}
}
