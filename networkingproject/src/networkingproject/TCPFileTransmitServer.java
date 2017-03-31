package networkingproject;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPFileTransmitServer {   
    public static void main(String args[])throws IOException{ 
    	
    	byte[] parts = new byte[1000000];              
    	ServerSocket nameSyn  = new ServerSocket(12002);
    	System.out.println("Server is ready to synchronize the file information.");
    	Socket nameLink = nameSyn.accept();
    	Scanner income =new Scanner(new InputStreamReader(nameLink.getInputStream()));
    	String fileName = income.nextLine();
    	System.out.println("Receive file "+ fileName + ".");
    	income.close();
    	nameSyn.close();
    	
    	
        ServerSocket server=new ServerSocket(12003);
        System.out.println("Server is ready to accept file.");
        Socket link =server.accept();
        
        System.out.println("Please input the directory that you want to put the file: ");
        Scanner input = new Scanner(System.in);
        String dir = input.nextLine();
        input.close();
        String fullDir = dir.concat(fileName);
        System.out.println(fullDir);
        
        int fileLength;
        InputStream incontain = link.getInputStream();
        File in = new File(fullDir);
        if(in.exists()==false){
        	System.out.println("No such file name under that directory, file can be synchronized.");
        }
        else{
        	System.out.println("File already exist, overwrite the original one.");
        }
        FileOutputStream fos = new FileOutputStream(in);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        while((fileLength=incontain.read(parts))>0){
        	//System.out.println(fileLength);
        	bos.write(parts, 0, fileLength);
        }
        System.out.println("File received. Socket closeing.");
        
        bos.close();
       // input.close();
        server.close();
    }  
}