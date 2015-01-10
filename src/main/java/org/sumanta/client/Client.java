package org.sumanta.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
 
public class Client 
{
 
    static Socket socket;
    
    public static void sendClientRequest(final String host, final String msg) {
    	OutputStream os;
		try {
			bind(host);
			os = socket.getOutputStream();
			final OutputStreamWriter osw = new OutputStreamWriter(os);
	        final BufferedWriter bw = new BufferedWriter(osw);

	        final String sendMessage = msg + "\n";
	        bw.write(sendMessage);
	        bw.flush();
	        System.out.println("Message sent to the server : "+sendMessage);
		} catch (final IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			unBind();
		}
        
	}
    
    
    public static Socket bind(final String host)
    {
    	
		try {
			final int port = 25000;
	        InetAddress address;
			address = InetAddress.getByName(host);
			socket = new Socket(address, port);
		} catch (final Exception e) {
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
    
    
    public static void main(final String args[])
    {
        try
        {
        	String host;
			/*DataInputStream dis=new DataInputStream(System.in);
			System.out.print("Enter Server Adress:");
			String host =dis.readLine();*/
            host = "127.0.0.1";
            final  int port = 25000;
            final InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);
            
            final String msg="2";
            //Send the message to the server
            sendClientRequest(host,msg);
 
            //Get the return message from the server
        }
        catch (final Exception exception) 
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
            catch(final Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
