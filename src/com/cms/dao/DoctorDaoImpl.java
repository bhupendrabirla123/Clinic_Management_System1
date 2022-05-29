package com.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cms.model.Doctor_Details;
import com.cms.utility.Getconnection;

public class DoctorDaoImpl implements DoctorDao {
	Getconnection get = new Getconnection();

	@Override
	public int insertDoctor(Doctor_Details doc) {
		String sql = "insert into doctor_details(id, name,email, pass,qualification, specification,contactno) values (?, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try (Connection con = get.getcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, doc.getId());
			pst.setString(2, doc.getName());
			pst.setString(3, doc.getEmailId());
			pst.setString(4, doc.getPassword());
			pst.setString(5, doc.getQualification());
			pst.setString(6, doc.getSpecification());
			pst.setLong(7, doc.getContactNumber());
			n = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Something went wrong");
		}
		return n;
	}

	@Override
	public List<Doctor_Details> view() {
		String sql = "select * from doctor_details";
		List<Doctor_Details> list = new ArrayList<Doctor_Details>();

		try (Connection con = get.getcon(); java.sql.Statement st = con.createStatement()) {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String qual = rs.getString(5);
				String spe = rs.getString(6);
				long l = rs.getLong(7);
				Doctor_Details d = new Doctor_Details();
				d.setId(id);
				d.setName(name);
				d.setContactNumber(l);
				d.setEmailId(email);
				d.setQualification(qual);
				d.setSpecification(spe);
				list.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public int updateDoctor(Doctor_Details doc) {
		String sql = "update doctor_details set email = ? ,qualification = ?, specification = ?,contactno = ? where id = ?";
		try (Connection con = get.getcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, doc.getEmailId());
			pst.setString(2, doc.getQualification());
			pst.setString(3, doc.getSpecification());
			pst.setLong(4, doc.getContactNumber());
			pst.setInt(5, doc.getId());
			int n = pst.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public int delete(int id) {
		String sql = "delete from doctor_details where id = ?";
		try (Connection con = get.getcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, id);
			int n = pst.executeUpdate();
			return n;
		} catch (SQLException e) {
			System.out.println("Something Went Wrong");
		}
		return 0;
	}

	@Override
	public Doctor_Details getdoc(int id) {
		String sql = "select * from doctor_details where id = ?";
		Doctor_Details d = new Doctor_Details();
		try (Connection con = get.getcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String name = rs.getString(2);
				String email = rs.getString(3);
				String qual = rs.getString(5);
				String spe = rs.getString(6);
				String pas = rs.getString(4);
				long l = rs.getLong(7);
				d.setId(id);
				d.setName(name);
				d.setContactNumber(l);
				d.setEmailId(email);
				d.setQualification(qual);
				d.setSpecification(spe);
				d.setPassword(pas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

//	public String getpass(String username) {
//		String sql = "select passwrod from doctor_details where username =?";
//		try (Connection con = get.getcon(); PreparedStatement pst = con.prepareStatement(sql)) {
//			pst.setString(1, username);
//			String pass = null;
//			ResultSet rs = pst.executeQuery();
//			pass = rs.getString(4);
//			return pass;
//		} catch (Exception e) {
//			System.out.println("Something went wrong");
//		}
//		return null;
//	}

}
