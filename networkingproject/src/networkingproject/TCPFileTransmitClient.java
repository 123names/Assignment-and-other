package networkingproject;
import java.util.Scanner;
import java.io.*;
import java.net.Socket;

public class TCPFileTransmitClient {

	public static void main(String[]args) throws IOException, InterruptedException{
		
		try{
		Scanner in = new Scanner(System.in);
		System.out.println("Please input the file directory you want to transmit: ");
		String fileDir = in.nextLine();
		File tFile = new File(fileDir);
		//System.out.println(tFile.getName());
		//int fileLength = (int) tFile.length();
		Socket nameSyn = new Socket("127.0.0.1", 12002);
		String name =tFile.getName();
		PrintWriter write = new PrintWriter(nameSyn.getOutputStream(),true);
		write.println(name);
		nameSyn.close();
		
		byte [] parts  = new byte [(int) tFile.length()];
		Socket client = new Socket("127.0.0.1", 12003);
		OutputStream outContain = client.getOutputStream();
		//PrintWriter write = new PrintWriter(client.getOutputStream(),true);
		//write.println(fileLength);
		FileInputStream outFile = new FileInputStream(tFile);
		BufferedInputStream out = new BufferedInputStream(outFile);
		out.read(parts, 0, parts.length);                     //put data in byte array then close file
		out.close();
		outContain.write(parts,0,parts.length);                       // write the file bytes in to outputstream to send
	    //os.flush();
		client.close();
		System.out.println("File is sended to server.");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
