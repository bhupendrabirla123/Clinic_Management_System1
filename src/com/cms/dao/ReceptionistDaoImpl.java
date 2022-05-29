package com.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cms.model.Receptionist_Details;
import com.cms.utility.Getconnection;

public class ReceptionistDaoImpl implements ReceptinistDao {
	Getconnection get = new Getconnection();

	@Override
	public int insertReceptionist(Receptionist_Details rd) {
		String sql = "insert into receptionist_details(id, name,username, password) values (?, ?, ?, ?)";
		int n = 0;
		try (Connection con = get.getcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, rd.getId());
			pst.setString(2, rd.getName());
			pst.setString(3, rd.getUsername());
			pst.setString(4, rd.getPassword());
			n = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Something went wrong");
		}
		return n;
	}

	@Override
	public List<Receptionist_Details> view() {
		String sql = "select * from receptionist_details";
		List<Receptionist_Details> list = new ArrayList<Receptionist_Details>();

		try (Connection con = get.getcon(); Statement st = con.createStatement()) {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Receptionist_Details r = new Receptionist_Details();
				r.setId(id);
				r.setName(name);
				list.add(r);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int updateReceptionist(Receptionist_Details re) {
		String sql = "update receptionist_details set password = ?  where id = ?";
		try (Connection con = get.getcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, re.getPassword());
			pst.setInt(2, re.getId());
			int n = pst.executeUpdate();
			return n;
		} catch (SQLException e) {
			System.out.println("Something went wrong");
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		String sql = "delete from receptionist_details where id = ?";
		try (Connection con = get.getcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, id);
			int n = pst.executeUpdate();
			return n;
		} catch (SQLException e) {
			System.out.println("Something went wrong");
		}
		return 0;
	}

	public String getpass(String username) {
		String sql = "select password from receptionist_details where username = ?";
		try (Connection con = get.getcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, username);
			String pass = null;
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				pass = rs.getString(1);
			}
			return pass;
		} catch (Exception e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
		return null;
	}

}
