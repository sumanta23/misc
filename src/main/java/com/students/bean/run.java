package com.students.bean;

import com.students.dao.MngStudents;
import com.students.dto.StudentDTO;

public class run {

	public static void main(String[] args) {
		//MngStudents st=new MngStudents();
		Student s=new Student();
		s.setId(8);
		s.setFname("na");
		s.setLname("ff");
		s.setMarks(69);
		//st.addStudent(s);
	    run.mycall(s);
	}
	
	public static void mycall(Student s)
	{
		StudentDTO sdto = new StudentDTO();
		sdto.addStudent(s);
	}
}
