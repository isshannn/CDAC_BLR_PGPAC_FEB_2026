package com.samvas.controllers;

public class Student {
	private int id;
	private String name;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	private String course;
	
	public Student(int stud_id, String stud_name, String stud_course) {
		this.id = stud_id;
		this.name = stud_name;
		this.course = stud_course;
	}
}
