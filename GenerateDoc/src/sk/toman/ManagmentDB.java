package sk.toman;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ManagmentDB {
	
	private static Connection connection;
	
	public ManagmentDB(){
		
	}
	public void ConnectServer(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//com.microsoft.sqlserver.jdbc.SQLServerDriver   MS SQL
			//com.mysql.jdbc.Driver  MY SQL
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR MSSQL JDBC Driver!");
			e.printStackTrace();
		}
		
		System.out.println("MSSQL JDBC Driver Registered!");
		connection = null;
		
		try {
			String connectionURL = "jdbc:sqlserver://DESKTOP-59FLU6V:1433;integratedSecurity=true"; //user=tomastomannr;password=tomastoman"; databaseName=salesDB;   //\\MSSQLSERVER   integratedSecurity=true;
			//"jdbc:sqlserver://<Computer Name>\\SQLFULL:1433;databaseName=BA_ELTRUN;"
			//"jdbc:mysql://mysql50.websupport.sk:3308/asanatoman_38703","admin_38703", "95525111Abc"
			
			connection = DriverManager
			.getConnection(connectionURL);
			
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
	}
	
	public void ConnectDB(String databaseName){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//com.microsoft.sqlserver.jdbc.SQLServerDriver   MS SQL
			//com.mysql.jdbc.Driver  MY SQL
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR MSSQL JDBC Driver!");
			e.printStackTrace();
		}
		
		System.out.println("MSSQL JDBC Driver Registered!");
		connection = null;
		
		try {
			String connectionURL = "jdbc:sqlserver://DESKTOP-59FLU6V:1433;integratedSecurity=true;databaseName="+databaseName; //user=tomastomannr;password=tomastoman"; databaseName=salesDB;   //\\MSSQLSERVER   integratedSecurity=true;
			//"jdbc:sqlserver://<Computer Name>\\SQLFULL:1433;databaseName=BA_ELTRUN;"
			//"jdbc:mysql://mysql50.websupport.sk:3308/asanatoman_38703","admin_38703", "95525111Abc"
			
			connection = DriverManager
			.getConnection(connectionURL);
			
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getDatabases(){
		ConnectServer();
		ArrayList<String> databaseNames = new ArrayList<String>();
		try {
			DatabaseMetaData dbmd = connection.getMetaData();
			ResultSet rs = dbmd.getCatalogs();
			
			while(rs.next()){
				databaseNames.add(rs.getString(1));
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return databaseNames;
	}
	
	public ArrayList<String> getTableColNames(String databaseName, String tableName){
		ConnectDB(databaseName);
		Statement stmt;
		ArrayList<String> colNames = new ArrayList<String>();
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM "+tableName);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			for(int i=1;i<columnCount+1;i++){
				colNames.add(rsmd.getColumnName(i));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return colNames;
	}
	
	public ArrayList<String> getTableNames(String databaseName){
		ArrayList<String> tableNames = new ArrayList<String>();//List<String>
		DatabaseMetaData m;		
		
		ConnectDB(databaseName);
		if(connection!=null){

			try {
				m = (DatabaseMetaData) connection.getMetaData();
				ResultSet rsTables = m.getTables(connection.getCatalog(), null, "%Tab", null);
				
				//System.out.println("Column count - " + rsTables.getMetaData().getColumnCount());
				while(rsTables.next()){
					//System.out.println("ctlgs="+rsTables.getString(1));

					tableNames.add(rsTables.getString("TABLE_NAME"));

				}	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return tableNames;
		}
		return tableNames;
	}
}
