import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPclient {

	public static void main(String []args) throws IOException{
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a English sentence: ");
		String in = input.nextLine();
		byte [] sentence = new byte[10000];
		byte [] receive = new byte[10000];
		sentence = in.getBytes();
		//System.out.println(sentence.length);
		DatagramSocket client = new DatagramSocket();
		InetAddress IPad = InetAddress.getLocalHost();
		DatagramPacket message = new DatagramPacket(sentence, sentence.length,IPad,12000);
		client.send(message);
		
		DatagramPacket receiveMessage = new DatagramPacket(receive,receive.length);
		client.receive(receiveMessage);
		String number = new String(receiveMessage.getData());
		System.out.println("The number of vowel in that sentence is " + number);
		client.close();
	}
}
