package tcpTest;

import java.io.*;
import java.net.*;

public class ClientSocket {public static void main(String srgs[])throws IOException{
    Socket s=null;
    //BufferedReader get=null;
    PrintWriter put=null;
    s=new Socket("127.0.0.1",8081);
    //get=new BufferedReader(new InputStreamReader(s.getInputStream()));
    put=new PrintWriter(s.getOutputStream(),true);        

    //InputStreamReader get2=new InputStreamReader(s.getInputStream());
    System.out.println("Enter the file name to transfer:");
    DataInputStream dis=new DataInputStream(System.in);
    String f=dis.readLine();
    put.println(f);
    File f1=new File("d:/test3.txt");
    FileOutputStream  fs=new FileOutputStream(f1);

    BufferedInputStream d=new BufferedInputStream(s.getInputStream());
    BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(f1));
    byte buffer[] = new byte[1024];
    int read;
    while((read = d.read(buffer))!=-1){
        outStream.write(buffer, 0, read);
        outStream.flush();
    }
    fs.close();
    System.out.println("File received");
    s.close();
    outStream.close();
    }
}