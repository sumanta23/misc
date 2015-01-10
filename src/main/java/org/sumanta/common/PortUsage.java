package org.sumanta.common;

import java.net.*;
import java.io.*;

public class PortUsage {
	public static boolean getPortUsage(final String host) throws IOException
	{
	
		Socket Skt = null;
		for (int i = 24000; i < 24999; i++) {
			try {
				System.out.println("Looking for "+ i);
				Skt = new Socket(host, i);
				System.out.println("There is a server on port "
				+ i + " of " + host);
			}
			catch (final UnknownHostException e) {
				System.out.println("Exception occured"+ e);
				if(Skt!=null){
					Skt.close();
				}
            break;
			}
			catch (final IOException e) {
				if(Skt!=null){
					Skt.close();
				}
			}
		}
	
		return true;
	}

   
}