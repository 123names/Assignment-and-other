package tcpTest;

import java.net.*; 
import java.io.*;
public class ServerSideSocket {   
    public static void main(String args[])throws IOException{ 
        ServerSocket ss=new ServerSocket(8081);

        Socket cs=ss.accept();
        System.out.println("Reached");
        BufferedReader st=new BufferedReader(new InputStreamReader(cs.getInputStream()));
        String s=st.readLine();
        System.out.println("The requested file is : "+s);
        File f=new File(s);
        if(f.exists())
        { 
            BufferedInputStream d=new BufferedInputStream(new FileInputStream(s));
            BufferedOutputStream outStream = new BufferedOutputStream(cs.getOutputStream());
            byte buffer[] = new byte[1024];
            int read;
            while((read = d.read(buffer))!=-1)
            {
                outStream.write(buffer, 0, read);
                outStream.flush();
            }
            d.close();
            System.out.println("File transfered");
            cs.close();
            ss.close();
        }  
    }  
}