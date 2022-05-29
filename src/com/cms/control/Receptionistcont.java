package com.cms.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cms.model.Doctor_Details;
import com.cms.model.Getid;
import com.cms.model.Patient_Details;
import com.cms.service.DoctorDataService;
import com.cms.service.PatientDataservices;
import com.cms.view.Receptionist;

public class Receptionistcont {

	public void receptionist() {
		try (Scanner in = new Scanner(System.in);) {
			new Receptionist().receptionistmenu();
			int n = in.nextInt();
			switch (n) {
			case 1:
				this.viewpatients();
				break;
			case 2:
				this.viewDoctors();
				break;
			case 3:
				this.addpatient();
				break;
			case 4:
				this.discharge();
				break;
			case 5:
				new LoginCon().login();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Please choose correct option");
				this.receptionist();
			}
		} catch (Exception e) {
			System.out.println("Characters not allowed");
			this.receptionist();
		}

	}

	public void viewpatients() {
		try {
			List<Patient_Details> list = new ArrayList<Patient_Details>();
			list.addAll(PatientDataservices.view());
			for (Patient_Details p : list) {
				System.out.println(p.getId() + " : " + p.getName() + " : " + p.getContactNumber() + " : "
						+ p.getAddress() + " : " + p.getDisease());
			}
			System.out.println();
			this.receptionist();
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.receptionist();
		}
	}

	public void viewDoctors() {
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
				this.receptionist();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.receptionist();
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
			if(PatientDataservices.insertCheck(p)) {
				System.out.println("Successfully inserted");
			}else {
				System.out.println("Something went wrong");
			}
//			PatientDao pd = new PatientDaoImpl();
//			int result = pd.insertPatient(p);
//			if (result == 1) {
//				System.out.println(result + " Inserted successfully");
//			} else {
//				System.out.println("Something went wrong");
//			}

			this.receptionist();
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.receptionist();
		}
	}

	public void discharge() {
		try(Scanner in = new Scanner(System.in);){
		System.out.println("Enter patient's id");
		int id = in.nextInt();
		if(PatientDataservices.delete(id)) {
			System.out.println("Successfully deleted");
		}else {
			System.out.println("Something went wrong");
		}
//		int n = pd.delete(id);
//		if (n == 1) {
//			System.out.println("Deleted Successfully");
//		} else {
//			System.out.println("Something went wrong");
//		}
		this.receptionist();
		}catch(Exception e) {
			System.out.println("Something went wrong");
			this.receptionist();
		}

	}

}
