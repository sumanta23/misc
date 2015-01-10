package org.sumanta.common;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class WebPing {
	static InetAddress addr;
	static boolean flag=false;
   public static boolean ping(final String address,final int port) {
      try {
         final Socket sock = new Socket(address,port);
         addr = sock.getInetAddress();
         System.out.println("Connected to " + addr);
         sock.close();
         flag=true;
         
      } catch (final IOException e) {
         System.out.println("Can't connect to " + addr);
         System.out.println(e);
      }
	return flag;
   }
}