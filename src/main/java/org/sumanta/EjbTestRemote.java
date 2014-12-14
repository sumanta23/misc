package org.sumanta;

import javax.ejb.Remote;

@Remote
public interface EjbTestRemote {
  public String sayHello(String name);
  public int compute(int n);
}
