package com.cms.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cms.model.Doctor_Details;
import com.cms.model.Patient_Details;
import com.cms.service.DoctorDataService;
import com.cms.service.PatientDataservices;
import com.cms.view.Doctor;

public class Doccontrol {

	public void doctor() {
		try (Scanner in = new Scanner(System.in);) {
			Doctor doc = new Doctor();
			doc.doctormenu();
			int n = in.nextInt();
			switch (n) {
			case 1:
				this.patients();
				break;
			case 2:
				this.patientprofile();
				break;
			case 3:
				this.selfprofile();
				break;
			case 4:
				new LoginCon().login();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Please select correct option");
				this.doctor();
				break;
			}
		} catch (Exception e) {
			System.out.println("Characters not allowed");
			this.doctor();
		}
	}

	public void patients() {
		try (Scanner in = new Scanner(System.in);) {
			new Doctor().patientsmenu();
			int n = in.nextInt();

			switch (n) {
			case 1:
				this.viewPatientable();
				break;
			case 2:
				this.updatepatient();
				break;
			case 3:
				this.deletePatient();
				break;
			case 4:
				this.doctor();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Choose correct option");
				this.patients();
				break;
			}
		} catch (Exception e) {
			System.out.println("Characters not allowed");
			this.patients();
		}
	}

	public void viewPatientable() {
		try {
			List<Patient_Details> list = new ArrayList<Patient_Details>();
			list.addAll(PatientDataservices.view());
			for (Patient_Details p : list) {
				System.out.println(p.getId() + " : " + p.getName() + " : " + p.getContactNumber() + " : "
						+ p.getAddress() + " : " + p.getDisease());
			}
			System.out.println();
			this.patients();
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.patients();
		}
	}

	public void updatepatient() {
		try (Scanner in = new Scanner(System.in)) {
			Patient_Details p = new Patient_Details();
			System.out.println("Enter patient id of patient");
			int id = in.nextInt();

			System.out.println("Enter new address");
			in.nextLine();
			String address = in.nextLine();

			System.out.println("Enter new contact no.");
			long cont = in.nextLong();

			System.out.println("Enter problem with patient");
			in.nextLine();
			String disease = in.nextLine();

			p.setId(id);
			p.setAddress(address);
			p.setContactNumber(cont);
			p.setDisease(disease);
			if (PatientDataservices.updatecheck(p)) {
				System.out.println("Successfully updated");
			} else {
				System.out.println("Something went wrong");
			}
//			PatientDao pd = new PatientDaoImpl();
//			int n = pd.updatePatient(p);
//			if (n == 1) {
//				System.out.println("Updated successfully");
//			} else {
//				System.out.println("Something went wrong");
//			}
			this.patients();
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.patients();
		}

	}

	public void deletePatient() {
		try (Scanner in = new Scanner(System.in);) {
			System.out.println("Enter patient's id");
			int id = in.nextInt();
			if (PatientDataservices.delete(id)) {
				System.out.println("Successfully deleted");
			} else {
				System.out.println("Something went wrong");
			}
//			PatientDao pd = new PatientDaoImpl();
//			int i = pd.delete(id);
//			if (i == 1) {
//				System.out.println("Deleted Successfully");
//			} else {
//				System.out.println("Something went wrong");
//			}
			this.patients();
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.patients();
		}

	}

	public void patientprofile() {
		try (Scanner in = new Scanner(System.in);) {
			System.out.println("Enter patients id");
			int id = in.nextInt();
			Patient_Details p = PatientDataservices.singleview(id);
			System.out.println(p.getId() + " : " + p.getName() + " : " + p.getContactNumber() + " : " + p.getAddress()
					+ " : " + p.getDisease());

			System.out.println();
			this.doctor();
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.doctor();
		}

	}

	public void selfprofile() {
		try (Scanner in = new Scanner(System.in);) {
			System.out.println("Enter your Id");
			int id = in.nextInt();
			Doctor_Details s = DoctorDataService.singleview(id);

			System.out.println(
					"--------------------------------------------------------------------------------------------------------");
			System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s", "Id", "Name", "ContactNumber", "Email", "Qualification",
					"Specification");
			System.out.println();
			System.out.println(
					"--------------------------------------------------------------------------------------------------------");

			System.out.printf("%-10d%-20s%-20d%-20s%-20s%-20s", s.getId(), s.getName(), s.getContactNumber(),
					s.getEmailId(), s.getQualification(), s.getSpecification());
			System.out.println();
			System.out.println(
					"--------------------------------------------------------------------------------------------------------");
			System.out.println();
			this.doctor();

		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.doctor();
		}
	}
}
