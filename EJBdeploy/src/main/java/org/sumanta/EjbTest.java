package org.sumanta;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EjbTest
 */
@Stateless
@LocalBean
public class EjbTest implements EjbTestRemote {

    /**
     * Default constructor. 
     */
    public EjbTest() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "hello "+name;
	}

	@Override
	public int compute(int n) {
		// TODO Auto-generated method stub
		return fibonacci(n);
		
	}

	public int fibonacci(int n)  {
	    if(n == 0)
	        return 0;
	    else if(n == 1)
	      return 1;
	   else
	      return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
