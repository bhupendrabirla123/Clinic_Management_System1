package com.cms.model;

public class Patient_Details {

	private int id;
	private String name;
	private long contactNumber;
	private String address;
	private String disease;
	private String Appointeddoc;
	private String prescription;

	public Patient_Details() {
	}

	public Patient_Details(int id, String name, long contactNumber, String address, String disease, String appointeddoc,
			String prescription) {
		super();
		this.id = id;
		this.name = name;
		this.contactNumber = contactNumber;
		this.address = address;
		this.disease = disease;
		Appointeddoc = appointeddoc;
		this.prescription = prescription;
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

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getAppointeddoc() {
		return Appointeddoc;
	}

	public void setAppointeddoc(String appointeddoc) {
		Appointeddoc = appointeddoc;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

}
