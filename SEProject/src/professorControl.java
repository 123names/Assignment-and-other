import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class professorControl {
	private DatabaseLink db = new DatabaseLink();
	private Professor p = new Professor();
	private int choice ;
	Scanner in = new Scanner(System.in);
	public professorControl(){
		
	}
	public void setInFo(int id) throws SQLException{
		p.SetId(id);
		p.setName(db.getAccountName(p.getId()));
	}
	public void printOp(){
		System.out.println("You have 3 option, 1 choice course to teach, 2 see the course choiced, 3 see the student in course, other exit.");
	}
	public void setChoice(int c){
		choice = c;
	}
	public void action() throws SQLException{
		p.sharedCourseList = db.getCourseList();
		p.setListChoiced(db.getAssignedList(p.getId()));
		if(choice ==1){
			p.printCourseList();
			System.out.println("Please input the course code of course you want to choice: ");
			int inCode = in.nextInt();
			p.choiceCourse(inCode);
		}
		else if(choice ==2){
			p.printChoiced();
		}
		else if(choice ==3){
			System.out.println("Please input the course code, then you can see the student list: ");
			int code =  in.nextInt();
			p.getStudentList(code);
		}
		else{
			System.out.println("Exit");
		}
	}
}
