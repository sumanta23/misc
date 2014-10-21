package org.sumanta.method;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


public class usage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		TheClass runner = new TheClass();
        Method[] methods = runner.getClass().getMethods();

        for (Method method : methods) {
            MyAnnotation annos = method.getAnnotation(MyAnnotation.class);
            if (annos != null) {
                try {
                	System.out.println(method.getName());
                	System.out.println(annos.name());
                	System.out.println(annos.value());
                    method.invoke(runner);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

		
		
		
		
		
		
		
		
		
		
		
		
		
		Class aClass = TheClass.class;
		Annotation[] annotations = aClass.getAnnotations();

		for(Annotation annotation : annotations){
		    if(annotation instanceof MyAnnotation){
		        MyAnnotation myAnnotation = (MyAnnotation) annotation;
		        System.out.println("name: " + myAnnotation.name());
		        System.out.println("value: " + myAnnotation.value());
		    }
		}

	}

}
