package com.cms.view;

import java.util.Scanner;

import com.cms.dao.DoctorDao;
import com.cms.dao.DoctorDaoImpl;

public class CRUDDoctors {
	Scanner in = new Scanner(System.in);
	DoctorDao dao = new DoctorDaoImpl();

	// Doctor CRUD operations
	
}

// update doctor
/*
 * public void updateDoctor() { System.out.println("***************");
 * 
 * System.out.println("1. Update by name");
 * System.out.println("2. Update by ID");
 * 
 * System.out.println("***************"); System.out.println("choose a number");
 * int n = in.nextInt(); switch (n) { case 1:
 * System.out.println("Enter Doctor's Name"); this.updateDocDetailname(); break;
 * case 2: System.out.println("Enter Doctor's Id"); this.updateDocDetailid();
 * break; default: System.out.println("please choose correct option"); break; }
 * }
 * 
 * // by name update public void updateDocDetailname() {
 * System.out.println("Enter EmailId"); String email = in.nextLine();
 * 
 * System.out.println("Enter Qualification"); String qual = in.nextLine();
 * 
 * System.out.println("Enter Speciality"); String sp = in.nextLine();
 * 
 * System.out.println("Enter Contact Number"); long contactNumber =
 * in.nextLong();
 * 
 * System.out.println("Provide a initial password for doctor to login"); String
 * pass = in.next(); Doctor_Details doc = new Doctor_Details();
 * doc.setName(pass); }
 */
// by Id update
