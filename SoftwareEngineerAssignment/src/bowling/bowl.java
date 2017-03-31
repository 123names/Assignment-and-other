package bowling;

import java.util.Scanner;

public class bowl {

	public static void main (String []args){
		frameScore score [] = new frameScore [14];
		int totalScore = 0;
		boolean nFinish = true;
		boolean unChange = false;
		int frameCount = 0;
		int frameCountLimit = 9;
		
		Scanner input = new Scanner(System.in);
		
		while(nFinish){
			score[frameCount] = new frameScore();
			System.out.println("Please input the Score of frame "+ frameCount +" on the first throw(From 0 to 10): ");
			score[frameCount].setFirst(input.nextInt());
			if(score[frameCount].getFirst()<0 || score[frameCount].getFirst() >10){
				System.out.println("Error input,the number is bigger than 10, Exit");
				System.exit(0);
			}
			else{
				if(score[frameCount].getFirst()==10){
					score[frameCount].setTotal(score[frameCount].getFirst());
					System.out.println("Strike.");
					if(unChange){
						System.out.println("Done");
					}
					else if (frameCount==9||frameCount==10){
						frameCountLimit++;
					}
				}
				else{
					int secondThrowMax = 10 -score[frameCount].getFirst();
					if(unChange){
						score[frameCount].setTotal(score[frameCount].getFirst());
						System.out.println("Done");
					}
					else{
						System.out.println("Please input the score of same frame on second throw: ");
						score[frameCount].setSecond(input.nextInt());
						if(score[frameCount].getSecond()<0||score[frameCount].getSecond()>secondThrowMax){
							System.out.println("Error input, the total in same frame is bigger than 10, Exit");
							System.exit(0);
						}
						else{
							if(score[frameCount].getSecond()==secondThrowMax){
								System.out.println("Spare.");
								score[frameCount].setSpare(true);
								if(frameCount==9){
									frameCountLimit++;
									unChange= true;
								}
							}
							score[frameCount].setTotal(score[frameCount].getFirst(), score[frameCount].getSecond());
						}
					}
				}
			}
			if(frameCountLimit>=11){
				frameCountLimit = 11;
			}
			if(frameCount==frameCountLimit){
				nFinish=false;
			}
			frameCount++;
		}
		System.out.println(frameCount+" frame");
		totalScore = addScore(score,frameCount);
		System.out.println("Total score is " + totalScore);
	}
	
	public static int addScore(frameScore[]score, int frameCount){
		int totalScore = 0;
		
		for(int i = 0; i<frameCount; i++){
			
			if(score[i].getFirst()==10&&i<9){
				if(score[i+1]==null){
					score[i].setStrike(0, 0);
				}
				else{
					if(score[i+1].getFirst()==10){
						if(score[i+2]==null){
							score[i].setStrike(score[i+1].getFirst(), 0);
						}
						else{
							score[i].setStrike(score[i+1].getFirst(), score[i+2].getFirst());
						}
					}
					else{
						score[i].setStrike(score[i+1].getFirst(), score[i+1].getSecond());
					}
				}
			}
			else if(score[i].getSpare()&&i<9){
				if(score[i+1]==null){
					score[i].setSpare(0);
				}
				else{
					score[i].setSpare(score[i+1].getFirst());
				}
			}
			else{
				score[i] = score[i];
			}
		}
		for(int i = 0; i<frameCount; i++){
			totalScore += score[i].getTotal();
			System.out.println("Score for frame " + i + " is " + score[i].getTotal());
		}
		return totalScore;
	}
}
