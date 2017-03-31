import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPserver {

	public static void main(String []args) throws IOException{
		
		DatagramSocket server = new DatagramSocket(12000);
		
		while(true){
			byte [] receive = new byte [10000];
			byte [] sent = new byte[10000];
			
			DatagramPacket receivePacket = new DatagramPacket(receive,receive.length);
			System.out.println("This server is ready!");
			server.receive(receivePacket);
			String in = new String(receivePacket.getData());
			String sentence = in.toLowerCase();
			//System.out.println(sentence);
			String [] words = sentence.split("\\s+");
			int numberOfVowel = countVowel(words);
			String number = String.valueOf(numberOfVowel);
			//System.out.println(numberOfVowel);
			
			sent = number.getBytes();
			InetAddress Ip = receivePacket.getAddress();
			int port = receivePacket.getPort();
			DatagramPacket sentPacket = new DatagramPacket(sent, sent.length,Ip,port);
			server.send(sentPacket);
		}
		
	}
	public static int countVowel(String[]word){
		
		int count = 0;
		for(int i =0; i<= word.length-1;i++){
			if(word[i].charAt(0)=='a'||word[i].charAt(0)=='e'||word[i].charAt(0)=='i'||word[i].charAt(0)=='o'||word[i].charAt(0)=='u'){
				count++;
			}
		}
		return count;
	}
}
