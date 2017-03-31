import java.io.*;


public class Exercise19_7 {

	public static void main(String []args) throws IOException, ClassNotFoundException{
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise19_07.dat"));
		test t1 = new test();
		int count =0;
		int total = 0;
		try{
		while (true){
			t1 = (test) input.readObject();	
			total += (((test) t1).getLoanAmount());
		}
	}
		catch(EOFException ie){
		}
		finally{
			System.out.println("Total Loan Amount is "+total);
		    input.close();
		}
	}
}
