package com.logronj.models;

public class Education {

	private String elementary;
	private String highschool;
	private String college;
	private String course;
	
	
	public String getElementary() {
		return elementary;
	}
	public void setElementary(String elementary) {
		this.elementary = elementary;
	}
	public String getHighschool() {
		return highschool;
	}
	public void setHighschool(String highschool) {
		this.highschool = highschool;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Education [elementary=");
		builder.append(elementary);
		builder.append(", highschool=");
		builder.append(highschool);
		builder.append(", college=");
		builder.append(college);
		builder.append(", course=");
		builder.append(course);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
