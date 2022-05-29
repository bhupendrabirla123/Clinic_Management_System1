package com.cms.view;



import java.util.Scanner;

import com.cms.dao.DoctorDao;
import com.cms.dao.DoctorDaoImpl;
import com.cms.dao.PatientDao;
import com.cms.dao.PatientDaoImpl;

public class Doctor {
	PatientDao pd = new PatientDaoImpl();
	DoctorDao doc = new DoctorDaoImpl();
	Scanner in = new Scanner(System.in);

	public void doctormenu() {
		System.out.println("***************");
		System.out.println("1. Patients");
		System.out.println("2. Patient Profile");
		System.out.println("3. Profile");
		System.out.println("4. Back");
		System.out.println("5. Exit");
		System.out.println("***************");
		System.out.println("Choose a number");

	}

	public void patientsmenu() {
		System.out.println("***************");
		System.out.println("1. View Patients Table");
		System.out.println("2. Update Patient Info");
		System.out.println("3. Discharge");
		System.out.println("4. Back");
		System.out.println("5. Exit");
		System.out.println("***************");
		
	}

	/*
	 * public void updatepatient() { System.out.println("***************");
	 * System.out.println("1. Update prescription");
	 * System.out.println("2. Update other info");
	 * System.out.println("***************"); int n = in.nextInt(); switch (n) {
	 * case 1: this.patientprescription(); break; case 2: this.updatebyId(); break;
	 * default: System.out.println("Please Enter a valid Number");
	 * this.updatepatient(); break; }
	 * 
	 * }
	 */



	/*
	 * public void patientprescription() { System.out.println("Enter patient's Id");
	 * int id = in.nextInt();
	 * 
	 * System.out.println("Enter Patient Prescription"); String pres =
	 * in.nextLine();
	 * 
	 * Patient_Details p = new Patient_Details(); p.setId(id);
	 * p.setPrescription(pres); // pd.updatePatient(p);
	 * System.out.println("Updated successfully"); this.patients();
	 * 
	 * }
	 * 
	 * public void updatebyId() { System.out.println("Enter patient's Id"); int id =
	 * in.nextInt();
	 * 
	 * System.out.println("Enter mobile number"); long contactNumber =
	 * in.nextLong();
	 * 
	 * System.out.println("Enter Patient's address"); String address = in.next();
	 * 
	 * System.out.println("Enter Diseas/Symptoms"); String diseas = in.next();
	 * 
	 * Patient_Details p = new Patient_Details(); p.setId(id);
	 * p.setContactNumber(contactNumber); p.setAddress(address);
	 * p.setDisease(diseas); // pd.updatePatient(p);
	 * System.out.println("Updated successfully"); this.patients(); }
	 */

	

	

	
}
