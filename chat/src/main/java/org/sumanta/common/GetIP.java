package org.sumanta.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIP {
   public static void main(final String[] args) {
      InetAddress address = null;
      try {
         address = InetAddress.getByName
         ("localhost");
      }
	  catch (UnknownHostException e) {
         System.exit(2);
      }
      System.out.println(address.getHostName() + "="
      + address.getHostAddress());
      System.exit(0);
   }
}