package org.sumanta.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server 
{
 
    private static Socket socket;
 
	// Method Reading the message from the client
	public static String readRequest(final ServerSocket serverSocket)
	{
		String number="";
		try{
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress());
                final InputStream is = socket.getInputStream();
                final InputStreamReader isr = new InputStreamReader(is);
                final BufferedReader br = new BufferedReader(isr);
                number = br.readLine();
                System.out.println("Message received from client is "+number);
				
		}
		catch(final Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return number;
	}
	
	
	// Method Sending the response back to the client.
	public static void sendRequest(final Socket seocket,final String returnMessage)
	{
		try{
			final OutputStream os = socket.getOutputStream();
			final OutputStreamWriter osw = new OutputStreamWriter(os);
			final BufferedWriter bw = new BufferedWriter(osw);
			bw.write(returnMessage);
			System.out.println("Message sent to the client is "+returnMessage);
            bw.flush();
		}
		catch(final Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
    public static void main(final String[] args) 
    {
        try
        {
 
        	final int port = 25000;
            final ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 25000");
 
            //Server is running always. This is done using this while(true) loop
            while(true) 
            {
                //Reading the message from the client
            	final String number=readRequest(serverSocket);
 
                //Multiplying the number by 2 and forming the return message
                String returnMessage;
                try
                {
                	returnMessage=number+number;
                   
                    returnMessage = returnMessage + "\n";
                }
                catch(final NumberFormatException e)
                {
                    //Input was not a number. Sending proper message back to client.
                    returnMessage = "Please send a proper number\n";
                }
 
                //Sending the response back to the client.
				sendRequest(socket,returnMessage);
            }
        }
        catch (final Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {	
                socket.close();
            }
            catch(final Exception e){}
        }
    }
}
