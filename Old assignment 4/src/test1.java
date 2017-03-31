
public class test1 {

	public static void main(String []args) {
		for(int i = 1; i<15; i++){
		  //System.out.print(i+ " ");
		for(int j = 15-i; j>0; j--){
			System.out.print("   ");
		}
		for(int j = i ; j > 0; j--){
			System.out.printf("%-3d", j);
		}
			System.out.println();
		}
		
	}
}
