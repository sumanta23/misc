package org.sumanta;
import java.util.Collection;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Timer;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

@Stateless
public class TimerSessionBean implements TimerSessionBeanRemote {

   @Resource
   private SessionContext context;

   public void createTimer(long duration) {
      context.getTimerService().createTimer(duration, "Hello World!");
   }

   @Timeout
   public void timeOutHandler(Timer timer) throws NamingException{
      System.out.println("timeoutHandler : " + timer.getInfo());
   // TODO Auto-generated method stub
   		InitialContext ctx = new InitialContext();
   		NamingEnumeration<NameClassPair> list = ctx.list("");
   		System.out.println(list.next().getName());
   		while (list.hasMore()) {
   		  System.out.println(list.next().getName());
   		}
      timer.cancel();
   }
}