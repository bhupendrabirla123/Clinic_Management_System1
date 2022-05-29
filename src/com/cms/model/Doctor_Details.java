package com.cms.model;

public class Doctor_Details {
	private int id;
	private String name;
	private String emailId;
	private String qualification;
	private String specification;
	private long contactNumber;
	private String password;

	public Doctor_Details() {

	}

	public Doctor_Details(int id, String name, String emailId, String qualification, String specification,
			long contactNumber, String password) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.qualification = qualification;
		this.specification = specification;
		this.contactNumber = contactNumber;
		this.password = password;
	}

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
