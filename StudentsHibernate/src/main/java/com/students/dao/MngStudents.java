package com.students.dao;





import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;

import com.students.bean.Student;

public class MngStudents {
	private static SessionFactory factory=new Configuration().configure().buildSessionFactory(); 
	
	
	public void addStudent(Student student)
	{
		//System.out.println("hello");
		Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.save(student); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   
	  } //end of addStudent
	
	
	public void removeStudent(Student student) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.delete(student); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   
	}

	
	public void updateStudent(Student student,int id) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Student temp = (Student)session.get(Student.class, id); 
	         temp.setFname(student.getFname());
	         temp.setLname(student.getLname());
	         temp.setMarks(student.getMarks());
			 session.update(temp);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}
	
	public List viewStudents() {
		Session session = factory.openSession();
	      Transaction tx = null;
	      List result=new ArrayList<Student>();
	      try{
	         tx = session.beginTransaction();
	        // Query query = session.createSQLQuery("select ID,FirstName,LastName,Marks from student_details");
	        // System.out.println(Student.class.getSimpleName());
	         Query query =session.createQuery("from com.students.bean.Student");
	         result = query.list();
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      
	      return result;
		
	}
	
	
	public Student singleStudentDetails(String id) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      Student st=new Student();
	      try{
	         tx = session.beginTransaction();
	         Student temp = (Student)session.get(Student.class, Integer.parseInt(id)); 
	         st=temp;
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return st;
		
	}
	
}
