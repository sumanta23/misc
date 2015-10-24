package org;

import java.util.ArrayList;

public class main {
	public static String[] ar={"getName","getRoll"};

	public static void main(String s[]) {
	FetchData fd=new FetchData();
	try {
		ArrayList al=new ArrayList<bean>();
		bean b=new bean();
		b.setName("hello");
		b.setRoll(1);
		al.add(b);
		fd.fetchData("org.bean",1,al);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		System.out.println("written in eclipse");
	}
	
}
	
}
