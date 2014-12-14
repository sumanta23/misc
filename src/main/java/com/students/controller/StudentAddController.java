package com.students.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.students.bean.Student;
import com.students.bean.run;
import com.students.dao.MngStudents;
import com.students.dto.StudentDTO;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentAddController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		double result = Double.parseDouble(request.getParameter("marks"));
		Student student = new Student();
		student.setId(909);
		student.setFname(fName);
		student.setLname(lName);
		student.setMarks(result);
		//StudentDTO sdto = new StudentDTO();
		//sdto.addStudent(student);
		MngStudents mst=new MngStudents();
		mst.addStudent(student);
		response.sendRedirect("http://www.google.com");
	}

}
