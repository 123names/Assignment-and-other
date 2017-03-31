import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
public class MISubsequence {

	private static int FinalCount = 0;
	public static void main(String[]args) throws FileNotFoundException{
		ArrayList<StringTokenizer>num = new ArrayList();
		File file = new File("E:/JAVA/ass1q2test/123.txt");
		Scanner in = new Scanner(file);
		while(in.hasNextLine()){
			num.add(new StringTokenizer(in.nextLine()));
		}
		int [][] array= new int [num.size()] [num.get(0).countTokens()];
		for(int i = 0; i<num.size();i++){
			int j = 0;
			while (num.get(i).hasMoreTokens()) {
		         array[i][j]= Integer.parseInt(num.get(i).nextToken());
		         j++;
		     }
		}
		MIS(array,0,0,0);
		System.out.println("The length of max increase subsequence is " + FinalCount);
		
	}
	
	public static void MIS(int [][]array, int rowIndex, int colIndex, int StartCount){
		int count = StartCount;
		int rowMax = array.length - 1;
		int colMax = array[0].length - 1;
		
		if(count>FinalCount){
			FinalCount = count;
		}
		if(rowIndex>0&&array[rowIndex][colIndex]<array[rowIndex-1][colIndex]){
			System.out.println("( " + rowIndex + " ," + colIndex+" )");
			MIS(array,rowIndex-1,colIndex,count++);
		}
		if(rowIndex>0&&colIndex<colMax&&array[rowIndex][colIndex]<array[rowIndex-1][colIndex+1]){
			System.out.println("( " + rowIndex + " ," + colIndex+" )");
			MIS(array,rowIndex-1,colIndex+1,count++);
		}
		if(colIndex<colMax&&array[rowIndex][colIndex]<array[rowIndex][colIndex+1]){
			System.out.println("( " + rowIndex + " ," + colIndex+" )");
			MIS(array,rowIndex,colIndex+1,count++);
		}
		if(colIndex<colMax&&rowIndex<rowMax&&array[rowIndex][colIndex]<array[rowIndex+1][colIndex+1]){
			System.out.println("( " + rowIndex + " ," + colIndex+" )");
			MIS(array,rowIndex+1,colIndex+1,count++);
		}
		if(rowIndex<rowMax&&array[rowIndex][colIndex]<array[rowIndex+1][colIndex]){
			System.out.println("( " + rowIndex + " ," + colIndex+" )");
			MIS(array,rowIndex+1,colIndex,count++);
		}
		if(rowIndex<rowMax&&colIndex>0&&array[rowIndex][colIndex]<array[rowIndex+1][colIndex-1]){
			System.out.println("( " + rowIndex + " ," + colIndex+" )");
			MIS(array,rowIndex+1,colIndex-1,count++);
		}
		if(colIndex>0&&array[rowIndex][colIndex]<array[rowIndex][colIndex-1]){
			System.out.println("( " + rowIndex + " ," + colIndex+" )");
			MIS(array,rowIndex,colIndex-1,count++);
		}
		if(rowIndex>0&&colIndex>0&&array[rowIndex][colIndex]<array[rowIndex-1][colIndex-1]){
			System.out.println("( " + rowIndex + " ," + colIndex+" )");
			MIS(array,rowIndex-1,colIndex-1,count++);
		}
	}
	
	
	public static void printAns(int [][]array1){
		for(int i = 0; i<array1.length; i++){
			for(int j =0; j<array1[0].length;j++){
				System.out.print(array1[i][j] + " ");
			}
			System.out.println();
		}
	}
}
