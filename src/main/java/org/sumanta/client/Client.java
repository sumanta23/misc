package org.sumanta.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;
 
public class Client 
{
 
    static Socket socket;
    
    public static void sendClientRequest(String host,String msg) {
    	OutputStream os;
		try {
			bind(host);
			os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
	        BufferedWriter bw = new BufferedWriter(osw);

	        String sendMessage = msg + "\n";
	        bw.write(sendMessage);
	        bw.flush();
	        System.out.println("Message sent to the server : "+sendMessage);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			unBind();
		}
        
	}
    
    
    public static Socket bind(String host)
    {
    	
		try {
			int port = 25000;
	        InetAddress address;
			address = InetAddress.getByName(host);
			socket = new Socket(address, port);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socket;
        
    }

    public static void unBind()
    {
    	//Closing the socket
            try
            {
                socket.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }    	
    }
    
    
    public static void main(String args[])
    {
        try
        {
        	String host;
			/*DataInputStream dis=new DataInputStream(System.in);
			System.out.print("Enter Server Adress:");
			String host =dis.readLine();*/
            host = "127.0.0.1";
            int port = 25000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);
            
            String msg="2";
            //Send the message to the server
            sendClientRequest(host,msg);
 
            //Get the return message from the server
        }
        catch (Exception exception) 
        {
            exception.printStackTrace();
        }
        finally
        {
            //Closing the socket
            try
            {
                socket.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
