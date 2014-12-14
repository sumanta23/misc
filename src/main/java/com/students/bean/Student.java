package com.students.bean;

import javax.persistence.*;


@Entity (name="Student_Details")
public class Student {
	@Id //@GeneratedValue
	@Column (name="ID")
	private int id;
	@Column (name="FirstName", nullable=false)
	private String fname;
	@Column (name="LastName", nullable=false)
	//@Transient //to skip the element
	private String lname;
	@Column (name="Marks", nullable=false)
	private double marks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
}
