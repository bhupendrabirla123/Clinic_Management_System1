package com.cms.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cms.model.Getid;
import com.cms.model.Patient_Details;
import com.cms.service.PatientDataservices;
import com.cms.view.Admin;

public class CrudPatientcon {

	public void crudpatient() {
		try (Scanner in = new Scanner(System.in);) {
			new Admin().patientmenu();
			int n = in.nextInt();
			switch (n) {
			case 1:
				this.addpatient();
				break;
			case 2:
				this.viewPatientable();
				break;
			case 3:
				this.updatebyId();
				;
				break;
			case 4:
				this.deletePatient();
				break;
			case 5:
				new Admincontrol().admin();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Please choose correct option");
				this.crudpatient();
				break;
			}
		} catch (Exception e) {
			System.out.println("Character's not allowed");
			this.crudpatient();
		}

	}

	public void addpatient() {
		try (Scanner in = new Scanner(System.in);) {
			int id = Integer.parseInt(Getid.getrandom());

			System.out.println("Enter name");
			String name = in.next();

			System.out.println("Enter mobile number");
			long contactNumber = in.nextLong();

			System.out.println("Enter Patient's address");
			String address = in.next();

			System.out.println("Enter Diseas/Symptoms");
			String diseas = in.next();

			Patient_Details p = new Patient_Details();
			p.setId(id);
			p.setName(name);
			p.setContactNumber(contactNumber);
			p.setAddress(address);
			p.setDisease(diseas);
			if (PatientDataservices.insertCheck(p)) {
				System.out.println("Successfully inserted");
				this.crudpatient();
			} else {
				System.out.println("Something went wrong");
				this.crudpatient();
			}
//			PatientDao pd = new PatientDaoImpl();
//			int result = pd.insertPatient(p);
//
//			if (result == 1) {
//				System.out.println(result + " Inserted successfully");
//				this.crudpatient();
//			} else {
//				System.out.println("Something went wrong");
//				this.addpatient();
//			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.crudpatient();
		}

	}

	public void viewPatientable() {
		try {
		List<Patient_Details> list = new ArrayList<Patient_Details>();
		list.addAll(PatientDataservices.view());

		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		System.out.printf("%-15s%-20s%-20s%-20s%-20s", "PatientID", "Patient_Name", "ContactNumber", "Address",
				"Disease");
		System.out.println();
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		for (Patient_Details p : list) {

			System.out.printf("%-15s%-20s%-20s%-20s%-20s", p.getId(), p.getName(), p.getContactNumber(), p.getAddress(),
					p.getDisease());
			System.out.println();
			System.out.println(
					"--------------------------------------------------------------------------------------------------------");
		}
		System.out.println();
		this.crudpatient();
		}catch (Exception e){
			System.out.println("Something went wrong");
			this.crudpatient();
		}
	}

	public void updatebyId() {
		try (Scanner in = new Scanner(System.in);) {
			System.out.println("Enter patient's Id");
			int id = in.nextInt();

			System.out.println("Enter mobile number");
			long contactNumber = in.nextLong();

			System.out.println("Enter Patient's address");
			String address = in.next();

			System.out.println("Enter Diseas/Symptoms");
			String diseas = in.next();

			Patient_Details p = new Patient_Details();
			p.setId(id);
			p.setContactNumber(contactNumber);
			p.setAddress(address);
			p.setDisease(diseas);
			if (PatientDataservices.updatecheck(p)) {
				System.out.println("Successfully updated");
			} else {
				System.out.println("Something went wrong..");
			}
//		PatientDao pd = new PatientDaoImpl();
//		int m = pd.updatePatient(p);
//		if (m == 1) {
//			System.out.println("Updated successfully");
//		} else {
//			System.out.println("Something went wrong");
//		}
			this.crudpatient();
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.crudpatient();
		}

	}

	public void deletePatient() {
		try (Scanner in = new Scanner(System.in);) {
			System.out.println("Enter patient's id");
			int id = in.nextInt();
			if(PatientDataservices.delete(id)) {
				System.out.println("Deleted successfully");
			}else {
				System.out.println("Something went wrong");
			}
			this.crudpatient();
//			PatientDao pd = new PatientDaoImpl();
//			int m = pd.delete(id);
//			if (m == 1) {
//				System.out.println("Deleted Successfully");
//			} else {
//				System.out.println("Something went wrong");
//			}
			this.crudpatient();
		} catch (Exception e) {
			System.out.println("Character's not allowed");
		}
	}

}
