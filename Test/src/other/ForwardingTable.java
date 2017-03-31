package other;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import other.Node;

public class ForwardingTable {

	public static void main(String []args) throws IOException{
		
		int numberOfNode = 0;
		int sourceNode = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the information file directory: ");
		String dir = input.nextLine();
		File inText = new File(dir);
		Scanner inFile = new Scanner(inText);
		
		numberOfNode = Integer.valueOf(inFile.nextLine());
		sourceNode = Integer.valueOf(inFile.nextLine());
		int[][] relatedNodeNo = new int[numberOfNode][numberOfNode];
		int[][] weightLength = new int[numberOfNode][numberOfNode];
		
		//System.out.println(numberOfNode +" " + targetNum);
		for(int i = 0; i<numberOfNode;i++){
			String relationOfNode = inFile.nextLine();
			relationOfNode.replaceAll("\\s","");
			int relationLength = relationOfNode.length();
			int countN = 0;
			int countL = 0;
			for(int j = 0; j<relationLength;j++){
				if(relationOfNode.charAt(j)== ':'){
					relatedNodeNo[i][countN]=(Character.getNumericValue(relationOfNode.charAt(j+1)));
					countN++;
				}
				if(relationOfNode.charAt(j)== ';'){
					relatedNodeNo[i][countN]=(Character.getNumericValue(relationOfNode.charAt(j+1)));
					countN++;
				}
				if(relationOfNode.charAt(j)== ','){
					weightLength[i][countL]=(Character.getNumericValue(relationOfNode.charAt(j+1)));
					countL++;
				}
			}
		}
		ArrayList<Node> nodes = new ArrayList();
		/*
		for(int i = 0; i<numberOfNode;i++){
			nodes.add(new Node(i+1,relatedNodeNo[i],weightLength[i]));
		}
		
		
		
		/*for(int i = 0;i<numberOfNode;i++){
			for(int j =0; j<numberOfNode;j++){
				System.out.print(relatedNodeNo[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i = 0;i<numberOfNode;i++){
			
			for(int j =0; j<numberOfNode;j++){
				System.out.print(weightLength[i][j]+ " ");
			}
			System.out.println();
		}*/
		System.out.println("Forwarding table of node 2: ");
		System.out.println("Source/Dest   |   1            2            3            4            5 ");
		/*
		for(int i = 0; i<numberOfNode;i++){
			System.out.print("     " +nodes.get(i).getID());
			for(int j = 0; j<numberOfNode;j++){
				System.out.print("            "+ nodes.get(i).getCost(j));
			}
			System.out.println();
		}
		*/
	}
}
