package org.sumanta;
import javax.ejb.Remote;

@Remote
public interface TimerSessionBeanRemote {
   public void createTimer(long milliseconds);
}