package com.students.dto;

import com.students.bean.Student;
import com.students.dao.MngStudents;

public class StudentDTO {
	public void addStudent(Student student) {
	try{
		System.out.println("hi1");
		MngStudents st=new MngStudents();
		System.out.println("hi2");
		st.addStudent(student);
	}
	catch(Exception e)
	{
		System.out.println("Problem in StudentDTO");
	}
	
	}
	
}
