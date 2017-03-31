package tDatabase;
import java.sql.*;
import java.util.Date;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
public class testDatabase {

	public static void main(String[]args) throws SQLException{
		String url = "jdbc:mysql://localhost:3306/ursdatabase";
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		System.out.println("Connnected");
		//statement create table 
			Statement s5 = myConn.createStatement();
			int CourseId = 1046;
			String queryNewTable ="CREATE TABLE StudentInCourse"+CourseId+" "+
	                   "(ID INTEGER not NULL, " +
	                   " NAME VARCHAR(255), " + 
	                   " PRIMARY KEY ( id ))"; 
			s5.executeUpdate(queryNewTable);
		/*
		//statement insert
		try{
			Statement s2 = myConn.createStatement();
			int id = 4;
			String name = "key";
			String passwordIn = "123";
			String queryInsert = "INSERT INTO account VALUES ("+id+", '"+name+"', '"+passwordIn+"')";
		    s2.executeUpdate(queryInsert);
		}
		catch(MySQLIntegrityConstraintViolationException e){
			System.out.println("Duplicate entry for id that is key 'PRIMARY', please use different id");
		}
		
		//statement delete row value
		Statement s4 = myConn.createStatement();
		int testId = 1;
		String deleteQuery = "DELETE FROM account WHERE ID = "+testId+" ";
		s4.executeUpdate(deleteQuery);
		
		//statement get all value
		Statement s1 = myConn.createStatement();
		String query = "select * " + "from account";
		ResultSet rsT1 = s1.executeQuery(query);
		while (rsT1.next()) {
			int IDOut = rsT1.getInt("ID");
			String nameOut = rsT1.getString("NAME");
			Date dobOut = rsT1.getDate("DOB");
            String passwordOut = rsT1.getString("password");
            System.out.println(IDOut + "\t" + nameOut +"\t" + dobOut + "\t" + passwordOut +"\t");
        }
		*/
	}
}
