package com.cms.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cms.model.Getid;
import com.cms.model.Receptionist_Details;
import com.cms.service.ReceptionistService;
import com.cms.view.Admin;

public class CrudRecepControl {

	public void crudreception() {
		try (Scanner in = new Scanner(System.in);) {
			new Admin().crudreceptionistmenu();
			int n = in.nextInt();
			switch (n) {
			case 1:
				this.addReceptionist();
				break;
			case 2:
				this.viewReceptionisttable();
				break;
			case 3:
				this.updatebyId();
				break;
			case 4:
				this.deleteReceptionist();
				break;
			case 5:
				new Admincontrol().admin();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Please choose correct option");

				break;
			}
		} catch (Exception e) {
			System.out.println("Charater's not allowed");
			this.crudreception();
		}
	}

	public void addReceptionist() {
		try (Scanner in = new Scanner(System.in);) {
			int id = Integer.parseInt(Getid.getrandom());

			System.out.println("Enter name");
			String name = in.next();

			System.out.println("Enter user name");
			String username = in.next();

			System.out.println("Enter password");
			String pass = in.next();

			Receptionist_Details rs = new Receptionist_Details();
			rs.setId(id);
			rs.setName(name);
			rs.setPassword(pass);
			rs.setUsername(username);
			if (ReceptionistService.insertDocCheck(rs)) {
				System.out.println("Successfully inserted");
			} else {
				System.out.println("Something went wrong");
			}
//		ReceptinistDao rd = new ReceptionistDaoImpl();
//		int n = rd.insertReceptionist(rs);
//		if (n == 1) {
//			System.out.println(n + " Inserted data successfully");
//		} else {
//			System.out.println("Something went wrong");
//		}
//
//		System.out.println();
			this.crudreception();
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.crudreception();
		}
	}

	public void viewReceptionisttable() {
		try {
		List<Receptionist_Details> list = new ArrayList<Receptionist_Details>();
		list.addAll(ReceptionistService.view());
		System.out.println("----------------------");
		System.out.printf("%-10s%-25s", "Id", "Name");
		System.out.println();
		System.out.println("----------------------");
		for (Receptionist_Details r : list) {
			System.out.printf("%-10d%-25s", r.getId(), r.getName());
//			System.out.println(r.getId() + " : " + r.getName());
			System.out.println();
			System.out.println("----------------------");
		}
		System.out.println();
		this.crudreception();
		}catch(Exception e){
			System.out.println("Something went wrong");
			this.crudreception();
		}
	}

	public void updatebyId() {
		try (Scanner in = new Scanner(System.in);) {
			System.out.println("Enter Receptionist Id to update data");
			int id = in.nextInt();
			System.out.println("Enter password");
			String pass = in.next();
			Receptionist_Details rs = new Receptionist_Details();
			rs.setId(id);
			rs.setPassword(pass);
			if (ReceptionistService.updatecheck(rs)) {
				System.out.println("Successfully updated");
			} else {
				System.out.println("Something went wrong");
			}
//			int m = rd.updateReceptionist(rs);
//			if (m == 1) {
//				System.out.println("Updated Successfully");
//			} else {
//				System.out.println("Something went wrong");
//			}
			this.crudreception();
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.crudreception();
		}
	}

	public void deleteReceptionist() {
		try (Scanner in = new Scanner(System.in);) {
			System.out.println("Enter Receptionist's id");
			int id = in.nextInt();
			if (ReceptionistService.delete(id)) {
				System.out.println("Successfully deleted");
			} else {
				System.out.println("Something went wrong");
			}
//			int m = rd.delete(id);
//			if (m == 1) {
//				System.out.println("Successfully deleted");
//			} else {
//				System.out.println("Something went wrong");
//			}
			this.crudreception();
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.crudreception();
		}
	}

}
