package com.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cms.utility.Getconnection;

public class AdminDao {

	public String get(String username) {
		String sql = "select * from admin_login where username = ?";
		ResultSet rs = null;
		try (Connection con = new Getconnection().getcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, username);
			rs = pst.executeQuery();
			String password = null;
			while (rs.next()) {
				password = rs.getString(4);
			}
			return password;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
