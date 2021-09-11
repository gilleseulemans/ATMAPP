package atmapp.dbconnectiontester;

import java.sql.*;

public class MySQLAcces {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private String url = "jdbc:mysql://localhost/feedback?userTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String ww = "159487";
	
	public void readDataBase() throws Exception{
		try {
			//this will load the mysql driver, each database has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//setup the connection with the database
			connect = DriverManager.getConnection(url, user, ww);
			
			//Statements allow to issue SQL querries to the database
			statement = connect.createStatement();
			//resultset get the result of the SQL query
			resultSet = statement.executeQuery("select * from feedback.comments");
			WriteResultSet(resultSet);
			
			//PreparedStatements can use variables and are more efficient
			preparedStatement = connect.prepareStatement(
					// "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
					"insert into feedback.comments values (default,?,?,?,?,?,?)");
			
			//Parameters start with 1
			preparedStatement.setString(1, "Test");
			preparedStatement.setString(2, "TestEmail");
			preparedStatement.setString(3,"TestWebpage");
			preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
			preparedStatement.setString(5, "TestSummary");
			preparedStatement.setString(6, "TestComment");
			preparedStatement.executeUpdate();
			
			preparedStatement = connect.prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from feedback.comments");
			resultSet = preparedStatement.executeQuery();
			WriteResultSet(resultSet);
			
			//remove again the insert comment
			preparedStatement = connect.prepareStatement("delete from feedback.comments where myuser= ? ;");
			preparedStatement.setString(1, "Test");
			preparedStatement.executeUpdate();
			
			resultSet = statement.executeQuery("select * from feedback.comments");
			writeMetaData(resultSet);
			
			
			
			
		}catch(Exception e) {
			throw e;
		}finally {
			close();
		}
	}
	
	private void writeMetaData(ResultSet resultSet) throws SQLException{
		//get some metadata from the database
		//result set get the result of the SQL query
		System.out.println("the columns in the table are: ");
		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for( int i = 1; i<resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " +i + " " + resultSet.getMetaData().getColumnName(i));
		}
	}
	
	private void WriteResultSet(ResultSet resultSet) throws SQLException{
		while(resultSet.next()) {
			//it is possible to get the column by name
			//also possible to get the column via the column number
			//wich starts at one
			//e.g. resultSet.getString(2)
			String user = resultSet.getString("myuser");
            String website = resultSet.getString("webpage");
            String summary = resultSet.getString("summary");
            Date date = resultSet.getDate("datum");
            String comment = resultSet.getString("comments");
            
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("summary: " + summary);
            System.out.println("Date: " + date);
            System.out.println("Comment: " + comment);
			
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
