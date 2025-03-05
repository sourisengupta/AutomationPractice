package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseActivity {
	
	static final String DB_URL="jdbc:mysql://localhost:3306/thebucketlist";
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	
	public static void main(String args[]) throws SQLException {		
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//1.  Register JDBC driver
			Class.forName(JDBC_DRIVER);
			
			//2.  Open a connection
			conn = DriverManager.getConnection(DB_URL, "root", "root");
			
			//3.  Create a statement
			stmt = conn.createStatement();
			
			String sql = "select * from logbook;";
			//4.  Execute a query
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String vehicle_entry_type = rs.getString("vehicle_entry_type ");
				System.out.println(vehicle_entry_type);
			}	

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				conn.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
		}
	}
}
