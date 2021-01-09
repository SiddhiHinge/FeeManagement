package com.project.Beans;

public class Accountant {
	private String accName;
	private String accEmail;
	private String accPassword;
	private String accContact;
	
	public Accountant() {}

	public Accountant(String accName, String accEmail, String accPassword, String accContact) {
		this.accName = accName;
		this.accEmail = accEmail;
		this.accPassword = accPassword;
		this.accContact = accContact;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccEmail() {
		return accEmail;
	}

	public void setAccEmail(String accEmail) {
		this.accEmail = accEmail;
	}

	public String getAccPassword() {
		return accPassword;
	}

	public void setAccPassword(String accPassword) {
		this.accPassword = accPassword;
	}

	public String getAccContact() {
		return accContact;
	}

	public void setAccContact(String accContact) {
		this.accContact = accContact;
	}

	@Override
	public String toString() {
		return "Accountant [accName=" + accName + ", accEmail=" + accEmail + ", accPassword=" + accPassword
				+ ", accContact=" + accContact + "]";
	}
	
}
