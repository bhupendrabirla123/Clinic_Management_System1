package com.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cms.model.Patient_Details;
import com.cms.utility.Getconnection;

public class PatientDaoImpl implements PatientDao {
	Getconnection get = new Getconnection();

	@Override
	public int insertPatient(Patient_Details d) {
		String sql = "insert into patient(id, name, contactno, address, disease) values (?, ?, ?, ?, ? )";
		int n = 0;
		try (Connection con = get.getcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, d.getId());
			pst.setString(2, d.getName());
			pst.setLong(3, d.getContactNumber());
			pst.setString(4, d.getAddress());
			pst.setString(5, d.getDisease());
			n = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}
		return n;
	}

	@Override
	public List<Patient_Details> view() {
		String sql = "select * from patient";
		List<Patient_Details> list = new ArrayList<Patient_Details>();

		try (Connection con = get.getcon(); Statement st = con.createStatement()) {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				long cont = rs.getLong(3);
				String address = rs.getString(4);
				String disease = rs.getString(5);
				Patient_Details pd = new Patient_Details();
				pd.setId(id);
				pd.setName(name);
				pd.setContactNumber(cont);
				pd.setAddress(address);
				pd.setDisease(disease);
				list.add(pd);
			}

		} catch (SQLException e) {
			System.out.println("Something went wrong");

		}
		return list;
	}

	@Override
	public int updatePatient(Patient_Details p) {
		String sql = "update patient set contactno = ? ,address = ?, disease = ?  where id = ?";
		try (Connection con = get.getcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setLong(1, p.getContactNumber());
			pst.setString(2, p.getAddress());
			pst.setString(3, p.getDisease());
			pst.setInt(4, p.getId());
			int n = pst.executeUpdate();
			return n;
		} catch (SQLException e) {
			System.out.println("Something went wrong");
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		String sql = "delete from patient where id = ?";
		try (Connection con = get.getcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, id);
			int n = pst.executeUpdate();
			return n;
		} catch (SQLException e) {
			System.out.println("Something Went wrong...");
		}
		return 0;
	}

	@Override
	public Patient_Details viewsingle(int id) {
		String sql = "select * from patient where id = ?";
		Patient_Details pd = new Patient_Details();
		try (Connection con = get.getcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String name = rs.getString(2);
				long cont = rs.getLong(3);
				String address = rs.getString(4);
				String disease = rs.getString(5);
				pd.setId(id);
				pd.setName(name);
				pd.setContactNumber(cont);
				pd.setAddress(address);
				pd.setDisease(disease);

			}
		} catch (SQLException e) {

			System.out.println("Something went wrong...");
		}
		return pd;
	}

}
