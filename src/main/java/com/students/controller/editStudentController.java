package com.students.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.students.bean.Student;
import com.students.dao.MngStudents;

/**
 * Servlet implementation class editStudentController
 */
@WebServlet("/editStudentController")
public class editStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		
		MngStudents mngs=new MngStudents();
		Student st=mngs.singleStudentDetails(id);
		System.out.println(st.getFname()+st.getId());
		request.setAttribute("st", st);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/edit.jsp");
		rd.forward(request, response);
		//mngs.updateStudent(student, id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		double result = Double.parseDouble(request.getParameter("marks"));
		Student student = new Student();
		//student.setId();
		student.setFname(fName);
		student.setLname(lName);
		student.setMarks(result);
		MngStudents mst=new MngStudents();
		mst.updateStudent(student, id);
	}

}
