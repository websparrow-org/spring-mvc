package org.websparrow.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DbAccess {

	// public Connection connect() throws SQLException {
	//
	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	// return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/websparrow",
	// "root", "");
	// } catch (Exception e) {
	// e.printStackTrace();
	// return null;
	// }
	// }

	private DataSource dataSrc;

	public void setDataSrc(DataSource dataSrc) {
		this.dataSrc = (DataSource) dataSrc;
	}

	public Connection connect() throws SQLException {
		Connection con = (Connection) dataSrc;
		return con;
	}
}
