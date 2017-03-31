import java.util.Scanner;


public class longest_common_squence {

	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the first sequence (X): ");
		String sequence1 = input.nextLine();
		System.out.println("Please input the second sequence (Y): ");
		String sequence2 = input.nextLine();
		input.close();
		//String sequence1 = "ABCBDAB";
		//String sequence2 = "BDCABA";
		System.out.println("First sequence (X): " + sequence1);
		System.out.println("Second sequence (Y): " + sequence2);
		String result = dynamic_programming_solve_LCS(sequence1, sequence2);
		System.out.println("The longest common sequence is:" + result);
	}
	public static String dynamic_programming_solve_LCS(String sequence1,String sequence2){
		String [][] sequenceTable = new String [sequence2.length()+1][sequence1.length()+1];
		
		for(int i =0; i<sequenceTable.length;i++){
			sequenceTable[i][0] = "";
		}
		for(int j =0; j<sequenceTable[0].length;j++){
			sequenceTable[0][j] = "";
		}
		for(int i =1; i<sequenceTable.length;i++){
			String Local_LCS = "";
			for(int j =1;j<sequenceTable[0].length;j++){
				if(sequence2.charAt(i-1)==sequence1.charAt(j-1)){
					Local_LCS = sequenceTable[i-1][j-1];
					Local_LCS+=sequence2.charAt(i-1);
				}
				else{
					if(sequenceTable[i-1][j].length()>sequenceTable[i][j-1].length()){
						Local_LCS = sequenceTable[i-1][j];
					}
					else{
						Local_LCS = sequenceTable[i][j-1];
					}
				}
				sequenceTable[i][j]=Local_LCS;
			}
		}
		printSequenceTable(sequenceTable);
		return sequenceTable[sequence2.length()][sequence1.length()];
	}
	public static void printSequenceTable(String [][] sequenceTable){
		System.out.println("Sequence table generated: ");
		for(int i = 0;i<sequenceTable.length;i++){
			for(int j =0; j<sequenceTable[0].length;j++){
				if(sequenceTable[i][j].length()==0){
					System.out.printf("%5s","*");
				}
				else{
					System.out.printf("%5s",sequenceTable[i][j]);
				}
			}
			System.out.println();
		}
	}
}
