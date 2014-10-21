package org.sumanta.method;
import java.util.Date;



public class TheClass {
	
	@MyAnnotation(name="ff", value="gg")
	public void getDate() {
		Date d=new Date();
		System.out.println(d);
	}
	

}
