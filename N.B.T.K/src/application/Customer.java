package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {

	private int custID;
	private int phoneNumber;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	
	private Connection dbConn = null;
	private Statement dbStatement = null;
	
	public Customer() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");
			dbConn.setAutoCommit(false);
			System.out.println("Opened database successfully");

			dbStatement = dbConn.createStatement();
			ResultSet dbResultSet = dbStatement.executeQuery("SELECT * FROM CUSTOMER;");

			dbResultSet.close();
			dbStatement.close();
			dbConn.close();
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	
	//Setters below:
	
	public void setCustID(int custID) {
		this.custID = custID;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void addToDatabase(int custID, String firstName, String lastName, int phoneNumber, String email, String address) {
		
		
		try {
			dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");
			
			String sql = "INSERT INTO customer(id, firstName, lastName, phoneNumber, email, address) VALUES(?,?,?,?,?,?)";
			
			PreparedStatement ps = dbConn.prepareStatement(sql);
			
			ps = dbConn.prepareStatement(sql);
			ps.setInt(1, custID);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setInt(4, phoneNumber);
			ps.setString(5, email);
			ps.setString(6, address);
			
			ps.executeUpdate();
			
			
			
			dbConn.close();
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
	}
	
	
	//Getters below:
	
	public int getCustID() {
		return custID;
	}
	
	public String getFirstName() {
		
		//Try-catch to fetch database
		try {
			Class.forName("org.sqlite.JDBC");
			dbConn = DriverManager.getConnection("jdbc:sqlite:testdb.db");
			dbConn.setAutoCommit(false);
			System.out.println("Opened database successfully");

			dbStatement = dbConn.createStatement();
			ResultSet dbResultSet = dbStatement.executeQuery("SELECT firstName FROM CUSTOMER;");

			//Go to the correct ID to fetch correct first name
			
			
			
			
			dbResultSet.close();
			dbStatement.close();
			dbConn.close();
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		return firstName;
	}
	
	public String getLastName() {
		return null;
	}
	
	public int getPhoneNumber() {
		return 0;
	}
	
	public String getEmail() {
		return null;
	}
	
	public String getAddress() {
		return null;
	}
	
}
