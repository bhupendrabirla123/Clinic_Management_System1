package com.cms.control;

import java.util.List;
import java.util.Scanner;

import com.cms.model.Doctor_Details;
import com.cms.model.Getid;
import com.cms.service.DoctorDataService;
import com.cms.view.Admin;

public class CRUDDocCon {

	public void crudDoc() {
		new Admin().Doctormenu();
		try (Scanner in = new Scanner(System.in);) {
			int n = in.nextInt();
			switch (n) {
			case 1:
				this.createdoc();
				break;
			case 2:
				this.readdoc();
				System.out.println();
				this.crudDoc();
				break;
			case 3:
				this.updateDoc();
				break;
			case 4:
				this.deleteDoc();
				break;
			case 5:
				this.readsingle();
				System.out.println();
				this.crudDoc();
				break;
			case 6:
				new Admincontrol().admin();
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("Choose valid option");
				this.crudDoc();
			}
		} catch (Exception e) {
			System.out.println("Character's not allowed");
			this.crudDoc();
		}
	}

	public void createdoc() {
		try (Scanner in = new Scanner(System.in);) {

			int id = Integer.parseInt(Getid.getrandom());

			System.out.println("Enter name");
			String name = in.next();

			System.out.println("Enter Qualification");
			String qual = in.next();

			System.out.println("Enter EmailId");
			String email = in.next();

			System.out.println("Enter Speciality");
			String sp = in.next();

			System.out.println("Enter Contact Number");
			long contactNumber = in.nextLong();

			System.out.println("Provide a initial password for doctor to login");
			String pass = in.next();

			Doctor_Details doctor = new Doctor_Details();
			doctor.setId(id);
			doctor.setName(name);
			doctor.setEmailId(email);
			doctor.setQualification(qual);
			doctor.setSpecification(sp);
			doctor.setContactNumber(contactNumber);
			doctor.setPassword(pass);
			if (DoctorDataService.insertDocCheck(doctor)) {
				System.out.println("Inserted successfully");
				this.crudDoc();
			} else {
				System.out.println("Something went wrong");
				this.crudDoc();
			}

		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.crudDoc();
		}

	}

	public void readdoc() {
		try {
			List<Doctor_Details> list = DoctorDataService.view();
			System.out.println(
					"--------------------------------------------------------------------------------------------------------");
			System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s", "Id", "Name", "ContactNumber", "Email", "Qualification",
					"Specification");
			System.out.println();
			System.out.println(
					"--------------------------------------------------------------------------------------------------------");
			for (Doctor_Details s : list) {
//			System.out.println(s.getId() + " : " + s.getName() + " : " + s.getContactNumber() + " : " + s.getEmailId()
//					+ " : " + s.getQualification() + " : " + s.getSpecification());
//			System.out.println(
//					"--------------------------------------------------------------------------------------------------------");

				System.out.printf("%-10d%-20s%-20d%-20s%-20s%-20s", s.getId(), s.getName(), s.getContactNumber(),
						s.getEmailId(), s.getQualification(), s.getSpecification());
				System.out.println();
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");

			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}

	}

	public void updateDoc() {
		try (Scanner in = new Scanner(System.in);) {
			System.out.println("Enter id of doctor to change details");
			int id = in.nextInt();

			System.out.println("Enter EmailId");
			String email = in.next();

			System.out.println("Enter Qualification");
			String qual = in.next();

			System.out.println("Enter Speciality");
			String sp = in.next();

			System.out.println("Enter Contact Number");
			long contactNumber = in.nextLong();

			Doctor_Details doc = new Doctor_Details();
			doc.setId(id);
			doc.setEmailId(email);
			doc.setContactNumber(contactNumber);
			doc.setQualification(qual);
			doc.setSpecification(sp);
			if (DoctorDataService.updatecheck(doc)) {
				System.out.println("Updated successfully");
				this.crudDoc();
			} else {
				System.out.println("Something went wrong");
				this.crudDoc();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.crudDoc();
		}
//		DoctorDao doc1 = new DoctorDaoImpl();
//		int m = doc1.updateDoctor(doc);
//		if (m == 1) {
//			System.out.println("Updated Successfully");
//			this.crudDoc();
//		} else {
//			System.out.println("Something went wrong");
//			this.crudDoc();
//		}

	}

	public void deleteDoc() {
		try (Scanner in = new Scanner(System.in);) {
			System.out.println("Please Enter Doctor's Id");
			int Id = in.nextInt();
			if (DoctorDataService.delete(Id)) {
				System.out.println("Deleted successfully");
				this.crudDoc();
			} else {
				System.out.println("Something went wrong");
				this.crudDoc();
			}
		} catch (Exception e) {
			System.out.println("type Mismatch");
			this.crudDoc();
		}
//		DoctorDao doc = new DoctorDaoImpl();
//		int m = doc.delete(Id);
//		if (m == 1) {
//			System.out.println("deleted successfully");
//			this.crudDoc();
//		} else {
//			System.out.println("Something went wrong");
//			this.crudDoc();
//		}

	}

	public void readsingle() {
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("Enter doctor's id");
			int id = in.nextInt();
			Doctor_Details s = DoctorDataService.singleview(id);
			if (s != null) {
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
				System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s", "Id", "Name", "ContactNumber", "Email",
						"Qualification", "Specification");
				System.out.println();
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");

				System.out.printf("%-10d%-20s%-20d%-20s%-20s%-20s", s.getId(), s.getName(), s.getContactNumber(),
						s.getEmailId(), s.getQualification(), s.getSpecification());
				System.out.println();
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
			} else {
				System.out.println("Something went wrong");
				this.crudDoc();
			}

		} catch (Exception e) {
			System.out.println("type Mismatch");
			this.crudDoc();
		}
	}

}
