import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseLink {

	private String url = "jdbc:mysql://localhost:3306/ursdatabase";
	
	public DatabaseLink(){
		
	}
	public boolean verifityAccountId(int id) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "select * from account WHERE ID = '" + id + "'";
		ResultSet rs = s.executeQuery(query);
		boolean exist = rs.first();
		myConn.close();
		return exist;
	}
	public boolean verifityCourseId(int id) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "select * from sharedcourselist WHERE CODE = '" + id + "'";
		ResultSet rs = s.executeQuery(query);
		boolean exist = rs.first();
		myConn.close();
		return exist;
	}
	public String getAccountName(int id) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "select NAME from account WHERE ID = '" + id + "'";
		ResultSet rs = s.executeQuery(query);
		String name = "";
		if(rs.next()){
			name = rs.getString("NAME");
		}
		myConn.close();
		return name;
	}
	public String getAccountPassword(int id) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "select PASSWORD from account WHERE ID = '" + id + "'";
		ResultSet rs = s.executeQuery(query);
		String passwordOut = "";
		if(rs.next()){
			passwordOut = rs.getString("PASSWORD");
		}
		myConn.close();
		return passwordOut;
	}
	public ArrayList<Account> getAccountList() throws SQLException{
		ArrayList<Account>accountList = new ArrayList<Account>();
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "select * from account" ;
		ResultSet rs = s.executeQuery(query);
		while(rs.next()){
			Account acc = new Account();
			acc.SetId(rs.getInt("ID"));
			acc.setName(rs.getString("NAME"));
			acc.setPassword(rs.getString("PASSWORD"));
			accountList.add(acc);
		}
		myConn.close();
		return accountList;
	}
	public ArrayList<Course> getAssignedList(int id) throws SQLException{
		ArrayList<Course>AssignedList = new ArrayList<Course>();
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "select * from assigned"+id;
		ResultSet rs = s.executeQuery(query);
		while(rs.next()){
			Course c = new Course();
			c.setCode(rs.getInt("CODE"));
			c.setName(rs.getString("NAME"));
			AssignedList.add(c);
		}
		myConn.close();
		return AssignedList;
	}
	public ArrayList<Course> getRegisteredList(int id) throws SQLException{
		ArrayList<Course>registeredList = new ArrayList<Course>();
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "select * from courseRegistered"+id;
		ResultSet rs = s.executeQuery(query);
		while(rs.next()){
			Course c = new Course();
			c.setCode(rs.getInt("CODE"));
			c.setName(rs.getString("NAME"));
			registeredList.add(c);
		}
		myConn.close();
		return registeredList;
	}
	public ArrayList<Course> getAlternativeList(int id) throws SQLException{
		ArrayList<Course>registeredList = new ArrayList<Course>();
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "select * from courseAlternative"+id;
		ResultSet rs = s.executeQuery(query);
		while(rs.next()){
			Course c = new Course();
			c.setCode(rs.getInt("CODE"));
			c.setName(rs.getString("NAME"));
			registeredList.add(c);
		}
		myConn.close();
		return registeredList;
	}
	public ArrayList<Course> getCourseList() throws SQLException{
		ArrayList<Course>sharedCourseList = new ArrayList<Course>();
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "select * from sharedcourselist" ;
		ResultSet rs = s.executeQuery(query);
		while(rs.next()){
			Course c = new Course();
			c.setCode(rs.getInt("CODE"));
			c.setName(rs.getString("NAME"));
			c.setInfo(rs.getString("DETAIL"));
			int assign = rs.getInt("ASSIGNED");
			if(assign ==1){
				c.setAssigned(true);
			}
			int closeRegister = rs.getInt("REGISTERDEADLINE");
			if(closeRegister==0){
				c.setOpenToRegister(false);
			}
			int closeDrop = rs.getInt("DROPDEADLINE");
			if(closeDrop==0){
				c.setOpenToDrop(false);
			}
			sharedCourseList.add(c);
		}
		myConn.close();
		return sharedCourseList;
	}
	public ArrayList<Student> getStudentListInCourse(int code) throws SQLException{
		ArrayList<Student>studentInCourseList = new ArrayList<Student>();
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "select * from studentInCourse"+code ;
		ResultSet rs = s.executeQuery(query);
		while(rs.next()){
			Student a = new Student();
			a.SetId(rs.getInt("ID"));
			a.setName(rs.getString("NAME"));
			studentInCourseList.add(a);
		}
		myConn.close();
		return studentInCourseList;
	}
	public ArrayList<Student> getStudentListInAlternativeCourse(int code) throws SQLException{
		ArrayList<Student>studentInCourseList = new ArrayList<Student>();
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "select * from studentInAlternative"+code ;
		ResultSet rs = s.executeQuery(query);
		while(rs.next()){
			Student a = new Student();
			a.SetId(rs.getInt("ID"));
			a.setName(rs.getString("NAME"));
			studentInCourseList.add(a);
		}
		myConn.close();
		return studentInCourseList;
	}
	public void addAccount(int id, String name, String password) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "INSERT INTO account VALUES ("+id+", '"+name+"', '"+password+"')";
		s.executeUpdate(query);
		if(id>=10&&id<1000){
			Statement s3 = myConn.createStatement();
			String queryNewTable1 ="CREATE TABLE assigned"+id+" "+
	                "(CODE INTEGER not NULL, " +
	                " NAME VARCHAR(255) not NULL, " + 
	                " PRIMARY KEY ( CODE ))"; 
			s3.executeUpdate(queryNewTable1);
		}
		else if(id>=1000){
			/*
			Statement s1 = myConn.createStatement();
			String queryNewTable ="CREATE TABLE studentTaken"+id+" "+
	                "(CODE INTEGER not NULL, " +
	                " NAME VARCHAR(255) not NULL, " + 
	                " PRIMARY KEY ( CODE ))"; 
			s1.executeUpdate(queryNewTable);
			*/
			Statement s2 = myConn.createStatement();
			String queryNewTable1 ="CREATE TABLE courseRegistered"+id+" "+
	                "(CODE INTEGER not NULL, " +
	                " NAME VARCHAR(255) not NULL, " + 
	                " PRIMARY KEY ( CODE ))"; 
			s2.executeUpdate(queryNewTable1);
			Statement s3 = myConn.createStatement();
			String queryNewTable2 ="CREATE TABLE courseAlternative"+id+" "+
	                "(CODE INTEGER not NULL, " +
	                " NAME VARCHAR(255) not NULL, " + 
	                " PRIMARY KEY ( CODE ))"; 
			s3.executeUpdate(queryNewTable2);
		}
		myConn.close();
	}
	public void addCourse(int id, String name, String describe, int assigned, int register,int drop) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "INSERT INTO sharedcourselist VALUES ("+id+", '"+name+"', '"+describe+"', "+ assigned+", "+register+", "+drop+")";
		s.executeUpdate(query);
		Statement s1 = myConn.createStatement();
		String queryNewTable ="CREATE TABLE studentInCourse"+id+" "+
                   "(ID INTEGER not NULL, " +
                   " NAME VARCHAR(255) not NULL, " + 
                   " PRIMARY KEY ( id ))"; 
		s1.executeUpdate(queryNewTable);
		Statement s2 = myConn.createStatement();
		String queryNewTable1 ="CREATE TABLE studentInAlternative"+id+" "+
                   "(ID INTEGER not NULL, " +
                   " NAME VARCHAR(255) not NULL, " + 
                   " PRIMARY KEY ( id ))"; 
		s2.executeUpdate(queryNewTable1);
		myConn.close();
	}
	public void updateAssignedInfo(int accountID,int courseCode,String courseName) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String inStudentSide = "UPDATE sharedcourselist SET ASSIGNED =1 WHERE CODE =" + courseCode;
		s.executeUpdate(inStudentSide);
		Statement s1 = myConn.createStatement();
		String inCourseSide = "INSERT INTO assigned"+accountID+" VALUES ("+courseCode+", '"+courseName+"')";
		s1.executeUpdate(inCourseSide);
		myConn.close();
	}
	public void dropAlternative(int accountID,int code) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String q = "DELETE FROM courseAlternative"+accountID+" WHERE CODE ="+code;
		s.executeUpdate(q);
		Statement s1 = myConn.createStatement();
		String inCourseSide = "DELETE FROM studentInAlternative"+code+" WHERE ID ="+accountID;;
		s1.executeUpdate(inCourseSide);
		myConn.close();
	}
	public void updateDropCourse(int accountID,int code) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String inStudentSide = "DELETE FROM courseRegistered"+accountID+" WHERE CODE ="+code;
		s.executeUpdate(inStudentSide);
		Statement s1 = myConn.createStatement();
		String inCourseSide = "DELETE FROM studentInCourse"+code+" WHERE ID ="+accountID;;
		s1.executeUpdate(inCourseSide);
		myConn.close();
	}
	public void updateRegisteredCourse(int accountID,String accountName,int code, String courseName) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String inStudentSide = "INSERT INTO courseRegistered"+accountID+" VALUES ("+code+", '"+courseName+"')";
		s.executeUpdate(inStudentSide);
		Statement s1 = myConn.createStatement();
		String inCourseSide = "INSERT INTO studentInCourse"+code+" VALUES ("+accountID+", '"+accountName+"')";
		s1.executeUpdate(inCourseSide);
		myConn.close();
	}
	public void addAlternativeCourse(int accountID,String accountName,int code, String courseName) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String inStudentSide = "INSERT INTO courseAlternative"+accountID+" VALUES ("+code+", '"+courseName+"')";
		s.executeUpdate(inStudentSide);
		Statement s1 = myConn.createStatement();
		String inCourseSide = "INSERT INTO studentInAlternative"+code+" VALUES ("+accountID+", '"+accountName+"')";
		s1.executeUpdate(inCourseSide);
		myConn.close();
	}
	public void addCourseTaken(int studentID, int courseCode,String courseName) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "INSERT INTO studentTaken"+studentID+" VALUES ("+courseCode+", '"+courseName+"')";
		s.executeUpdate(query);
	}
	public void closeRegister(int courseCode) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "UPDATE sharedcourselist SET REGISTERDEADLINE =0 WHERE CODE =" + courseCode;
		s.executeUpdate(query);
	}
	public void openRegister(int courseCode) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "UPDATE sharedcourselist SET REGISTERDEADLINE =1 WHERE CODE ="+ courseCode;
		s.executeUpdate(query);
	}
	public void closeDrop(int courseCode) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "UPDATE sharedcourselist SET DROPDEADLINE =0 WHERE CODE ="+ courseCode;
		s.executeUpdate(query);
	}
	public void openDrop(int courseCode) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "UPDATE sharedcourselist SET DROPDEADLINE =1 WHERE CODE ="+ courseCode;
		s.executeUpdate(query);
	}
	public boolean getRegisteredDeadlineInfo(int code) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "select REGISTERDEADLINE from sharedcourselist where CODE ="+code;
		ResultSet rs = s.executeQuery(query);
		boolean close = false;
		if(rs.next()){
			int in = rs.getInt("REGISTERDEADLINE");
			if(in ==0){
				close = true;
			}
		}
		myConn.close();
		return close;
	}
	public boolean getDropDeadlineInfo(int code) throws SQLException{
		Connection myConn = DriverManager.getConnection(url, "root", "test123");
		Statement s = myConn.createStatement();
		String query = "select DROPDEADLINE from sharedcourselist where CODE ="+code;
		ResultSet rs = s.executeQuery(query);
		boolean close = false;
		if(rs.next()){
			int in = rs.getInt("DROPDEADLINE");
			if(in ==0){
				close = true;
			}
		}
		myConn.close();
		return close;
	}
}
