package com.project.Beans;

public class Student {
	
	private String studName;
	private int studRoll;
	private String studGender;
	private String studContact;
	private String studEmail;
	private String studCourse;
	private int studTotalFee;
	private int studPaidFee;
	private int studDueFee;
	
	public Student() {}
	
	public Student(String studName, int studRoll, String studGender, String studContact, String studEmail,
			String studCourse, int studTotalFee, int studPaidFee, int studDueFee) {
		super();
		this.studName = studName;
		this.studRoll = studRoll;
		this.studGender = studGender;
		this.studContact = studContact;
		this.studEmail = studEmail;
		this.studCourse = studCourse;
		this.studTotalFee = studTotalFee;
		this.studPaidFee = studPaidFee;
		this.studDueFee = studDueFee;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getStudRoll() {
		return studRoll;
	}

	public void setStudRoll(int studRoll) {
		this.studRoll = studRoll;
	}

	public String getStudGender() {
		return studGender;
	}

	public void setStudGender(String studGender) {
		this.studGender = studGender;
	}

	public String getStudContact() {
		return studContact;
	}

	public void setStudContact(String studContact) {
		this.studContact = studContact;
	}

	public String getStudEmail() {
		return studEmail;
	}

	public void setStudEmail(String studEmail) {
		this.studEmail = studEmail;
	}

	public String getStudCourse() {
		return studCourse;
	}

	public void setStudCourse(String studCourse) {
		this.studCourse = studCourse;
	}

	public int getStudTotalFee() {
		return studTotalFee;
	}

	public void setStudTotalFee(int studTotalFee) {
		this.studTotalFee = studTotalFee;
	}

	public int getStudPaidFee() {
		return studPaidFee;
	}

	public void setStudPaidFee(int studPaidFee) {
		this.studPaidFee = studPaidFee;
	}

	public int getStudDueFee() {
		return studDueFee;
	}

	public void setStudDueFee(int studDueFee) {
		this.studDueFee = studDueFee;
	}

	@Override
	public String toString() {
		return "Student [studName=" + studName + ", studRoll=" + studRoll + ", studGender=" + studGender
				+ ", studContact=" + studContact + ", studEmail=" + studEmail + ", studCourse=" + studCourse
				+ ", studTotalFee=" + studTotalFee + ", studPaidFee=" + studPaidFee + ", studDueFee=" + studDueFee
				+ "]";
	}
	

}
