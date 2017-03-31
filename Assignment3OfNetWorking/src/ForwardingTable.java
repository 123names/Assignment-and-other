import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ForwardingTable {

    private static final int INF = Integer.MAX_VALUE;   
    public static int [][] relation ;
    public static int [] nodes;
    public static int numberOfNode = 0;
    static int sourceNode = 0;
    
	public static void main(String []args) throws IOException{
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the information file directory: ");
		String dir = input.nextLine();
		File inText = new File(dir);
		Scanner inFile = new Scanner(inText);
		
		numberOfNode = Integer.valueOf(inFile.nextLine()); // read number of node
		nodes = new int [numberOfNode];
		for(int i = 1; i<=numberOfNode;i++){
			nodes [i-1] = i;
		}
		sourceNode = Integer.valueOf(inFile.nextLine());   // read source node
		
		int[][] relatedNodeNo = new int[numberOfNode][numberOfNode];
		int[][] weightLength = new int[numberOfNode][numberOfNode];
		relation = new int [numberOfNode][numberOfNode];
		
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
		ArrayList <link> links = new ArrayList<link>();
		for(int i = 0; i<numberOfNode;i++){
			for(int j = 0;j<numberOfNode;j++){
				if(relatedNodeNo[i][j]==0){
					
				}
				else{
					links.add(new link(i+1, relatedNodeNo[i][j],weightLength[i][j]));
				}
			}
		}
		for(int i = 0; i<numberOfNode;i++){
			for(int j = 0;j<numberOfNode;j++){
				relation[i][j]= INF;
			}
		}
		
		while(links.size()>0){
			int sIndex;
			int dIndex;
			sIndex = links.get(0).getS();
			dIndex = links.get(0).getD();
			relation [sIndex-1][dIndex-1]= links.get(0).getW();
			links.remove(0);
		}
		System.out.println("Direction table: ");
		System.out.println("Source/Dest:           1                2                3                4                5");
		for(int s = 0; s<numberOfNode;s++){
			for(int d = 0;d<numberOfNode;d++){
				if (s==d){
					relation[s][d] =0;
				}
			}
		}
		for(int i = 0; i<numberOfNode;i++){
			System.out.print("     "+(i+1)+"        ");
			for(int j = 0;j<numberOfNode;j++){
				System.out.printf("%10d       ",relation[i][j]);
			}
			System.out.println();
		}
        int[] w = new int[nodes.length];
        int[] d = new int[nodes.length];
        for(int i =0; i<numberOfNode;i++){
        	d[i] = sourceNode;
        }
        System.out.println("Forwarding Table: ");
		dijkstra(sourceNode,d,w);
	}
	
    public static void dijkstra(int s, int[] destNode, int[] w) {    //(source, weight table for node 2)
    	s= s-1;                   //the array is 1 less
        boolean[] flag = new boolean[nodes.length];         //have link or not
        int mark=0;
        for (int i = 0; i < nodes.length; i++) {
            flag[i] = false;                  
            w[i] = relation[s][i]; //{5,0,2,INF,INF}
        }

        flag[s] = true;
        w[s] = 0;
        
        for (int i = 0; i < nodes.length; i++) {
            int block = INF;
            for (int j = 0; j < nodes.length; j++) {
                if (flag[j]==false && w[j]<block) {
                    block = w[j];
                    mark = j+1;//          indicate next node
                }
            }
            flag[mark] = true;
            for (int j = 0; j < nodes.length; j++) {
                int tmp;
                if(relation[mark-1][j]==INF){
                	tmp = INF;
                }
                else{
                	tmp = (block + relation[mark-1][j]);
                }

                if (flag[j]==false) {
                	if((tmp<w[j]) ){
                        w[j] = tmp;      
                        destNode[j] = mark;
                	}
                }
                //destNode[j] = mark;
            }
        }
        System.out.println("Destination       |  Link");
        for(int i = 1; i <= numberOfNode; i++) {
        	if(sourceNode == destNode[i-1]) {
        		System.out.println(i +"                 |  " + destNode[i-1] + ", " + i);
        	} 
        	else{
        		int previousNode = INF;
        		int indirect = i-1;                 //shifted back
        		while (indirect != sourceNode){
	        		indirect = destNode[indirect];
	        		if(indirect != sourceNode) {
	        			previousNode = indirect;
	        		} 
	        		else {
	        			System.out.println(i +"                 |  " + sourceNode + ", " + previousNode);
	        		}
	        	} 
        	}
        }
        System.out.printf("\ndijkstra(%d): \n", nodes[s]);
        for (int i=0; i < nodes.length; i++){
            System.out.printf("shortest(%d, %d)=%d\n", nodes[s], nodes[i], w[i]);
        }
    }
}