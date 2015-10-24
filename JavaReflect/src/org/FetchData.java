package org;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class FetchData {

	public static void  fetchData(String className,int index,ArrayList al) throws Exception {
		
		
		Class thisClass = Class.forName(className);
		//Object obj = thisClass.newInstance();
		Object obj=thisClass.cast(al.get(0));
		if(obj instanceof bean)
		System.out.println("true");
		Method m = thisClass.getMethod(main.ar[index]);
        String returnVal=""+(m.invoke(obj));
        System.out.println(returnVal);
	}
}
