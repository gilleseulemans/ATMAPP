package atmapp.dbConnection;

import java.sql.*;

public class DatabaseAccesClass {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	//needed to connect to database of the localhost
	private String url = "jdbc:mysql://localhost/banking?userTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String ww = "159487";
	
	//method that will be used to insert data in the banking database
	public void insertInDatabase(String name, String lastName, int balance) throws Exception{
		try {
			//this will load the mysql driver, each database has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connection setup
			connect = DriverManager.getConnection(url, user, ww);
			//prepared statement allow to issue SQL querries to the database with parameters
			preparedStatement = connect.prepareStatement("insert into banking.bankusers values (?,?,?)");
			
			//parameters start with 1
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, lastName);
			preparedStatement.setInt(3, balance);
			preparedStatement.executeUpdate();
			
			preparedStatement = connect.prepareStatement("SELECT Firstname, LastName, Balance FROM banking.bankusers");
			resultSet = preparedStatement.executeQuery();
			//WriteResultSet(resultSet);
			
			}catch(Exception e) {
				throw e;
			}finally {
				close();
			}
	}
	
	public String getUserName(String userName) throws Exception{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect= DriverManager.getConnection(url,user,ww);
			preparedStatement = connect.prepareStatement("SELECT Firstname FROM banking.bankusers WHERE Firstname = '" + userName + "';");
			resultSet = preparedStatement.executeQuery();
			String nameFromDb = resultSet.getString("Firstname");
			return nameFromDb;
		}catch(Exception e) {
			throw e;
		}
		
	}
	
	private void WriteResultSet(ResultSet resultSet) throws SQLException{
		while(resultSet.next()) {
			//it is possible to get the column by name
			//also possible to get the column via the column number
			//wich starts at one
			//e.g. resultSet.getString(2)
			String FirstName = resultSet.getString("Firstname");
            String LastName = resultSet.getString("LastName");
            int balance = resultSet.getInt("Balance");
           
            
            System.out.println("FirstName  " + FirstName);
            System.out.println("LastName " +LastName);
            System.out.println("balance " + balance);
            
		}
	}
	
	private void close() {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(connect != null) {
				connect.close();
			}
		}catch(Exception e) {
			
		}
	}
	
	
	

}
