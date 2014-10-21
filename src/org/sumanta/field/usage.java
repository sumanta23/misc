package org.sumanta.field;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class usage {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Class c=Class.forName("org.sumanta.field.TheClass");
		Object o=c.newInstance();
		System.out.println(o.getClass().getName());
		Class cl=Class.forName(o.getClass().getName());
		Object obj=cl.newInstance();
		usage.parseID(o);
		usage.parseColumn(obj);
	}
	
	public static void parseID(Object runner)
	{
		//TheClass runner = new TheClass();
        Field[] fields = runner.getClass().getFields();
        
        for (Field	field: fields) {
            //Id annos = field.getAnnotation(Id.class);
        	Id annos = field.getAnnotation(Id.class);
            if (annos != null) {
            	//System.out.println("printing");
                try {
                	System.out.println(field.getName());
                	System.out.println(annos.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

	}

	public static void  parseColumn(Object runner)
	{
		Field[] fields = runner.getClass().getFields();
        
        for (Field	field: fields) {
            //Id annos = field.getAnnotation(Id.class);
        	Column annos = field.getAnnotation(Column.class);
            if (annos != null) {
            	//System.out.println("printing");
                try {
                	System.out.println(field.getName());
                	System.out.println(annos.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
