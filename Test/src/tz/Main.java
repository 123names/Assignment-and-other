/**
 *
 * Name: Daniel Friyia
 * Course: COSC4436
 * Methods:
 *  + parse(String s) returns a two dimensional array
 *      that returns an adjacency matrix
 *
 *  - parse(ArrayList<Integer> nodeDestination, ArrayList<Integer> nodeWeight)
 *      takes in two Arraylists of the coordinates and processes them into
 *      an adjacency matrix
 *
 * */

package tz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static int totalNodes;
    public static int startNode;
    public static ArrayList<String> nodeNames;
    public static ArrayList<Integer> nodeDestination = new ArrayList<Integer>();
    public static ArrayList<Integer> nodeWeight= new ArrayList<Integer>();
    public static int[] distances;
    public static int[] previouslyVisited;
    public static int[] startingConstant;
    public static final int MINIMUM_VALUE = 999999;

    public static int[][] parse(String s) {
        ArrayList<String> coords = new ArrayList<String>();
        totalNodes = s.charAt(0) - '0';
        startNode = s.charAt(2) - '0';
        previouslyVisited = new int[totalNodes + 1];
        startingConstant = new int[totalNodes + 1];

        nodeNames = new ArrayList<String>();

        for(int i = 4; i < s.length(); i++){
            try {
                if (s.charAt(i) == ' ') {
                    continue;
                } else if((s.charAt(i) - '0') < 10 && s.charAt(i + 1) == ':') {
                    nodeNames.add(s.charAt(i) - '0' + "");
                    i += 2;
                    if(s.charAt(i) == ' ') {
                        i++;
                    } else {
                        String coord = "";
                        while (true) {
                            if (s.charAt(i) != '\n') {
                                coord += s.charAt(i);
                                i++;
                            } else {
                                coords.add(coord);
                                break;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                break;
            }
        }

        for(int i = 0; i < coords.size(); i++) {
            for(int j = 0; j < coords.get(i).length(); j++) {
                if(j == 0) {
                    nodeDestination.add(Integer.parseInt(coords.get(i).charAt(j) + ""));
                } else {
                    if(coords.get(i).charAt(j) == ',') {
                        nodeWeight.add(Integer.parseInt(coords.get(i).charAt(j + 1) + ""));
                        j += 2;
                    } else {
                        if(coords.get(i).charAt(j) != ';') {
                            nodeDestination.add(Integer.parseInt(coords.get(i).charAt(j) + ""));
                        }
                    }
                }
            }
            nodeDestination.add(-1);
            nodeWeight.add(-1);
        }

        return parse(nodeDestination, nodeWeight);
    }

    private static int[][] parse(ArrayList<Integer> nodeDestination, ArrayList<Integer> nodeWeight){
        int[][] adjacencyMartix = new int[nodeNames.size() + 1][nodeNames.size() + 1];

        for(int i = 1; i < nodeNames.size() + 1; i++) {
            startingConstant[i] = startNode;
            for(int j = 1; j <= totalNodes; j++) {
                adjacencyMartix[i][j] = MINIMUM_VALUE;
            }
        }
       

        int destinationCount = 0;

        for(int i = 1; i < nodeNames.size() + 1; i++) {
            for(int j = 1; j < nodeNames.size() + 1; j++) {
               if((j) == nodeDestination.get(destinationCount)) {
                   adjacencyMartix[i][j] = nodeWeight.get(destinationCount);
                   destinationCount++;
               }
               if(nodeDestination.get(destinationCount) == -1) {
                   destinationCount++;
                   break;
               }
            }
        }
        
        System.out.println("\nThe Ajacency Matrix is: ");
        System.out.print("   ");
        for(int i = 0; i < nodeNames.size(); i++) {
        	System.out.print((i + 1) + " ");
        }
        System.out.println();
        for(int i = 1; i < nodeNames.size() + 1; i++) {
        	System.out.print(i + ") ");
            for(int j = 1; j <= totalNodes; j++) {
                if(adjacencyMartix[i][j] == MINIMUM_VALUE) {
                	System.out.print(0 + " ");
                } else {
                	System.out.print(adjacencyMartix[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
        return adjacencyMartix;
    }


    public static void dijkstraShortestPath(int[][] matrix) {
        int nextNode = 0;

        distances = new int[nodeNames.size() + 1];
        distances = matrix[startNode];
        distances[startNode] = 0;
        previouslyVisited[startNode] = 1;

        for(int i = 1; i < nodeNames.size() + 1; i++) {
            int minimumValue = MINIMUM_VALUE;
            for(int j = 1; j < nodeNames.size() + 1; j++) {
                if(minimumValue > distances[j] && previouslyVisited[j] != 1) {
                    minimumValue = distances[j];
                    nextNode = j;
                }
            }

            previouslyVisited[nextNode] = 1;

            for(int k = 1; k < nodeNames.size() + 1; k++) {
                if(previouslyVisited[k] != 1) {
                    if(minimumValue + matrix[nextNode][k] < distances[k]) {
                        distances[k] = minimumValue + matrix[nextNode][k];
                        startingConstant[k] = nextNode;
                        System.out.println(nextNode);
                    }
                }
            }
        }
        /*
        System.out.print("The shortest path is: ");
        for(int i = 1; i < nodeNames.size() + 1; i++) {
            if(i < totalNodes) {
                System.out.print(distances[i] + ", ");
            } else {
                System.out.print(distances[i]);
            }
        }
        System.out.println("\n\n");
        */
    }

    public static void table() {
        System.out.println("Destination       |  Link");
        System.out.println("-----------------------------------");
        int previous = MINIMUM_VALUE;
        for(int i = 1; i < nodeNames.size() + 1; i++) {
        	if(startNode == startingConstant[i]) {
        		System.out.println(i +"                 |  " + startingConstant[i] + ", " + i);
        	} 
        	else {
        		previous = -999;
        		int checker = i;
	        	do {
	        		checker = startingConstant[checker];
	        		if(checker != startNode) {
	        			previous = checker;
	        		} else {
	        			System.out.println(i +"                 |  " + startNode + ", " + previous);
	        		}
	        	} while (checker != startNode);
        	}
        }
    }


    public static void main(String[] args) {
        String read = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("input.txt")));
            String line = reader.readLine();

            while (line != null) {
                read += line;
                read += "\n";
                line = reader.readLine();
            }
            reader.close();

        } catch (java.io.IOException ioe) {
        	System.out.println("File not found!");
            System.exit(0);
        }

        int[][] adjacencyMatrix = parse(read);
        dijkstraShortestPath(adjacencyMatrix);
        table();
    }
}
