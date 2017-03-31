import java.sql.SQLException;
import java.util.Scanner;

public class AdministerControl {

	private DatabaseLink db = new DatabaseLink();
	private Administer adm = new Administer();
	private int choice ;
	Scanner in = new Scanner(System.in);
	public AdministerControl(){
		
	}
	public void setInFo(int id) throws SQLException{
		adm.SetId(id);
		adm.setName(db.getAccountName(adm.getId()));
	}
	public void printOp(){
		System.out.println("You have 8 option, 1 add student, 2 add perfessioner, 3 add administer, 4 add course, 5 list current course, 6 list current account, 7 change registeration setting, 8 change for drop setting, other exit.");
	}
	public void setChoice(int c){
		choice = c;
	}
	public void action() throws SQLException{
		adm.sharedCourseList = db.getCourseList();
		adm.accountList = db.getAccountList();
		if(choice ==1){
			adm.addStudent();
		}
		else if(choice ==2){
			adm.addProfessor();
		}
		else if(choice ==3){
			adm.addAdminister();
		}
		else if(choice ==4){
			adm.addNewCourse();
		}
		else if(choice ==5){
			adm.printCourseList();
		}
		else if(choice ==6){
			adm.printAccountList();
		}
		else if(choice ==7){
			adm.changeRegisteration();
		}
		else if(choice ==8){
			adm.changeDrop();
		}
		else{
			System.out.println("Exit");
		}
	}
}
