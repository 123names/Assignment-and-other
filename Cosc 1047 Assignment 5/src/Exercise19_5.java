import java.io.*;
import java.util.Date;


public class Exercise19_5 {

	public static void main(String [] args) throws IOException{
		
		ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("Exercise19_05.dat"));
		
		for(int i = 1; i <6;i++){
			write.writeInt(i);
		}
		write.writeObject(new Date());
		write.writeDouble(5.5);
		write.close();
	}
}
