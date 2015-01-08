package org.sumanta.common;

import java.net.InetAddress;
import java.net.Socket;

public class WebPing {
	static InetAddress addr;
	static boolean flag=false;
   public static boolean ping(String address,int port) {
      try {
         Socket sock = new Socket(address,port);
         addr = sock.getInetAddress();
         System.out.println("Connected to " + addr);
         sock.close();
         flag=true;
         
      } catch (java.io.IOException e) {
         System.out.println("Can't connect to " + addr);
         System.out.println(e);
      }
	  finally
	  {
	      return flag;
	  }
   }
}