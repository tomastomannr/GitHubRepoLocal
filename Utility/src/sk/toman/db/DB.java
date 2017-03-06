package sk.toman.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.DatabaseMetaData;

public class DB {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;

		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://mysql50.websupport.sk:3308/asanatoman_38703","admin_38703", "PASSWORD here");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			
			
			
			DatabaseMetaData m;
			try {
				m = (DatabaseMetaData) connection.getMetaData();

			ResultSet tables = m.getTables(connection.getCatalog(), null, "", null);
			System.out.println("Column count - " + tables.getMetaData().getColumnCount());
			while(tables.next()){
			   System.out.println("table = " + tables.getString("TABLE_NAME"));
			}
			
//			Statement stmt = connection.createStatement();
//			String sql = "CREATE TABLE REGISTRATION " +
//	                   "(id INTEGER not NULL, " +
//	                   " first VARCHAR(255), " + 
//	                   " last VARCHAR(255), " + 
//	                   " age INTEGER, " + 
//	                   " PRIMARY KEY ( id ))"; 
//			stmt.executeUpdate(sql);
//			System.out.println("PO CREATE ");
//			
//			ResultSet tablesS = m.getTables(connection.getCatalog(), null, "", null);
//			System.out.println("Column count - " + tablesS.getMetaData().getColumnCount());
//			for (int i = 1; i <= tablesS.getMetaData().getColumnCount(); i++) {
//			   System.out.println("table = " + tablesS.getMetaData().getTableName(i));
//			}
			
			
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Failed to make connection!");
		}

	}

}
