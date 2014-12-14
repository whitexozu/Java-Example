package db;

import java.sql.*;
import java.sql.SQLException;
import java.io.*;

public class mssqlConnect {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:sqlserver://211.44.193.218:2005;DatabaseName=WinsabisL2";	//서버IP주소:1433;DatabaseName=데이터베이스명
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url, "SA", "SABISSA");
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select emp_no, emp_name, e_mail, grp_id from sc_employee");
		while (rs.next()) {
			String field1 = rs.getString("emp_no");
			String field2 = rs.getString("emp_name");
			System.out.println(field1);
			System.out.println(field2);
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
