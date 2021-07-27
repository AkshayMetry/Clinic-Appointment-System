package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB {
	Connection con = null;
	PreparedStatement pst;
	public static Connection dbconnect() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_system","root","");
			return conn;
		}
		
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
