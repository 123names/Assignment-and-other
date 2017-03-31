import java.io.*;


public class read {

	public static void main(String []args) throws IOException, ClassNotFoundException{
		
		ObjectInputStream read = new ObjectInputStream(new FileInputStream("Exercise19_05.dat"));
		while(read.available()!=0){
		for(int i =1; i<6;i++){
		System.out.println(read.readInt());
		}
		System.out.println(read.readObject());
		double a = read.readDouble();
		System.out.println(a);
		}
		read.close();
	}
}
