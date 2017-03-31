
public class SudokuPuzzles {

	public static void main(String []args){
		int [][]array = new int [9][9];
		ValueInput(array);
		System.out.println("Problem is: ");
		printAns(array);
		
	}
	
	public static boolean solution(int [][]a1, int rowIndex, int colIndex){
		if(a1[8][8] != 0){
			return true;
		}
		for(int i =1; i<10;i++){
			if(CheckConflict( i,a1,rowIndex,colIndex)){
				a1[rowIndex][colIndex] = i;
				if(colIndex<8){
					solution(a1,rowIndex,colIndex+1);
				}
				else{
					solution(a1,rowIndex+1,0);
				}
			}
		}
		// my be not 
		return false;
		
	}
	public static boolean CheckConflict(int item,int [][] array,int rowIndex, int colIndex){
		for(int i = 0; i<9;i++){
			if(array[rowIndex][i]==item){
				return false;
			}
			if(array[i][colIndex]==item){
				return false;
			}
		}
		
		
		return true;
		
	}
	public static void printAns(int [][]array1){
		for(int i = 0; i<9; i++){
			for(int j =0; j<9;j++){
				System.out.print(array1[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void ValueInput(int [][]array1){
		array1[0][2] = 6;
		array1[0][3] = 5;
		array1[0][5] = 8;
		array1[0][6] = 4;
		array1[1][0] = 5;
		array1[1][1] = 2;
		array1[2][1] = 8;
		array1[2][2] = 7;
		array1[2][7] = 3;
		array1[2][8] = 1;
		array1[3][2] = 3;
		array1[3][5] = 1;
		array1[3][7] = 8;
		array1[4][0] = 9;
		array1[4][3] = 8;
		array1[4][4] = 6;
		array1[4][5] = 3;
		array1[4][8] = 5;
		array1[5][1] = 5;
		array1[5][4] = 9;
		array1[5][6] = 6;
		array1[6][0] = 1;
		array1[6][1] = 3;
		array1[6][6] = 2;
		array1[6][7] = 5;
		array1[7][7] = 7;
		array1[7][8] = 4;
		array1[8][2] = 5;
		array1[8][3] = 2;
		array1[8][5] = 6;
		array1[8][6] = 3;
	}
}
