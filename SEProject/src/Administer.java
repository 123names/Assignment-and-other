import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Administer extends Account{
	
	public ArrayList<Account>accountList = new ArrayList<Account>();
	private DatabaseLink db = new DatabaseLink();
	Scanner in = new Scanner(System.in);
	
	public Administer(){
		
	}
	public void addStudent() throws SQLException {
		System.out.println("Please assign non used id for new student: ");
		int id = in.nextInt();
		
		if(id<1000){
			System.out.println("The id of new student must bigger or equal to 1000.");
		}
		else{
			boolean exist = db.verifityAccountId(id);
			if (exist){
				System.out.println("ID already exist");
			}
			else{
				System.out.println("Please input the name of new student you want to put in system: ");
				String name = in.next();
				System.out.println("Please input the password for that new student");
				String password = in.next();
				db.addAccount(id, name, password);
			}
		}
	}
	public void addProfessor() throws SQLException{
		System.out.println("Please assign non used id for new professor: ");
		int id = in.nextInt();
		if(id<10||id >=1000){
			System.out.println("The id of new professor must from 10 to 999.");
		}
		else{
			boolean exist = db.verifityAccountId(id);
			if (exist){
				System.out.println("ID already exist");
			}
			else{
				System.out.println("Please input the name of new professor you want to put in system: ");
				String name = in.next();
				System.out.println("Please input the password for that new professor");
				String password = in.next();
				db.addAccount(id, name, password);
			}
		}
	}
	public void addAdminister() throws SQLException{
		System.out.println("Please assign non used id for new administer: ");
		int id = in.nextInt();
		if(id>=10||id<=0){
			System.out.println("The id of new administer must from 1 to 9.");
		}
		else{
			boolean exist = db.verifityAccountId(id);
			if (exist){
				System.out.println("ID already exist");
			}
			else{
				System.out.println("Please input the name of new administer you want to put in system: ");
				String name = in.next();
				System.out.println("Please input the password for that new administer");
				String password = in.next();
				db.addAccount(id, name, password);
			}
		}
	}
	public void addNewCourse() throws SQLException{
		System.out.println("Please assign non used id for new course: ");
		int id = in.nextInt();
		boolean exist = db.verifityCourseId(id);
		if (exist){
			System.out.println("ID already exist");
		}
		else{
			in.nextLine();
			System.out.println("Please input the name of new course you want to put in system: ");
			String name = in.nextLine();
			System.out.println("Please input the detail for that new course: ");
			String detail = in.nextLine();
			int assigned = 0;
			int registerCondition = 1;
			int dropCondition = 1;
			db.addCourse(id, name, detail, assigned,registerCondition,dropCondition);
		}
	}
	public void changeRegisteration() throws SQLException{
		System.out.println("Warning, you are about to make change of registration system for students, you sure you want to do that(0 close registeration, 1 open registeration, other no change).");
		int choice = in.nextInt();
		Course closeOne = null;
		Course openOne = null;
		int courseNum = sharedCourseList.size();
		if(choice ==0){
			printCourseList();
			System.out.println("Please input the course that you want to close to registeration: ");
			int code = in.nextInt();
			for(int i = 0; i<courseNum; i++){
				Course check = sharedCourseList.get(i);
				int codeR = check.getCode();
				if(code ==codeR ){
					closeOne = check;
				}
			}
			if(closeOne==null){
				System.out.println("The course Code your input is not vaild");
			}
			else{
				db.closeRegister(code);
				for(int i = 0; i<courseNum; i++){
					ArrayList<Student>studentInCourseList = db.getStudentListInCourse(code);
					ArrayList<Student>studentAlternative = db.getStudentListInAlternativeCourse(code);
					int classAlterSize = studentAlternative.size();
					int classSize = studentInCourseList.size();
					if(classSize<3){
						for(int j = 0; j<classSize; j++){
							Student StudentInCanceledCourse = studentInCourseList.get(j);
							db.updateDropCourse(StudentInCanceledCourse.getId(), code);
						}
						for(int j = 0; j<classAlterSize; j++){
							Student StudentInCanceledCourse = studentAlternative.get(j);
							db.dropAlternative(StudentInCanceledCourse.getId(), code);
						}
					}
				}
				System.out.println("The course " +code+ " is closed to registeration");
			}
		}
		else if(choice ==1){
			printCourseList();
			System.out.println("Please input the course that you want to open to registeration: ");
			int code = in.nextInt();
			for(int i = 0; i<courseNum; i++){
				Course check = sharedCourseList.get(i);
				int codeR = check.getCode();
				if(code ==codeR ){
					openOne = check;
				}
			}
			if(openOne==null){
				System.out.println("The course Code your input is not vaild");
			}
			else{
				db.openRegister(code);
				System.out.println("The course " +code+ " is open to registeration");
			}
		}
		else{
			System.out.println("Nothing changes");
		}
	}
	public void changeDrop() throws SQLException{
		System.out.println("Waring, you are about to make change of drop system for students, you sure you want to do that(0 close drop, 1 open drop, other no change).");
		int choice = in.nextInt();
		if(choice ==0){
			printCourseList();
			System.out.println("Please input the course that you want to close to drop: ");
			int code = in.nextInt();
			Course closeOne = null;
			int courseNum = sharedCourseList.size();
			for(int i = 0; i<courseNum; i++){
				Course check = sharedCourseList.get(i);
				int codeR = check.getCode();
				if(code ==codeR ){
					closeOne = check;
				}
			}
			if(closeOne==null){
				System.out.println("The course Code your input is not vaild");
			}
			else{
				db.closeDrop(code);
				System.out.println("The course " +code+ " is closed to drop");
			}
		}
		if(choice ==1){
			printCourseList();
			System.out.println("Please input the course that you want to open to drop: ");
			int code = in.nextInt();
			Course openOne = null;
			int courseNum = sharedCourseList.size();
			for(int i = 0; i<courseNum; i++){
				Course check = sharedCourseList.get(i);
				int codeR = check.getCode();
				if(code ==codeR ){
					openOne = check;
				}
			}
			if(openOne==null){
				System.out.println("The course Code your input is not vaild");
			}
			else{
				db.openDrop(code);
				System.out.println("The course " +code+ " is open to drop");
			}
		}
		else{
			System.out.println("Nothing changes");
		}
	}
	public void printAccountList(){
		int accountNum = accountList.size();
		System.out.println("ID:   " + "\t" +"\t" +"\t" +"\t" +"\t" +"The Account name:  ");
		for(int i = 0; i<accountNum; i++){
			Account acc = accountList.get(i);
			System.out.printf("%-20d%30s\n", acc.getId(),acc.getName());
		}
	}
}
