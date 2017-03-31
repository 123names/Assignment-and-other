import java.sql.SQLException;
import java.util.Scanner;

public class studentControl {
	private DatabaseLink db = new DatabaseLink();
	private Student a = new Student();
	private int choice ;
	Scanner in = new Scanner(System.in);
	public studentControl(){
		
	}
	public void setInFo(int id) throws SQLException{
		a.SetId(id);
		a.setName(db.getAccountName(a.getId()));
	}
	public void printOp(){
		System.out.println("You have 6 option, 1 choice course, 2 drop an exist course, 3 see the course registered, 4 choice alternative course, 5 drop alternative, 6 see alternative, other exit.");
	}
	public void setChoice(int c){
		choice = c;
	}
	public void action() throws SQLException{
		a.sharedCourseList = db.getCourseList();
		a.setListRegister(db.getRegisteredList(a.getId()));
		a.setListAlternative(db.getAlternativeList(a.getId()));
		if(choice ==1){
			a.printCourseList();
			System.out.println("Please input the course code of course you want to choice: ");
			int inCode = in.nextInt();
			a.registerCourse(inCode);
		}
		else if(choice ==2){
			a.printRegisteredList();
			System.out.println("Please input the course code of course you want to drop: ");
			int inDropCode = in.nextInt();
			a.dropCourse(inDropCode);
		}
		else if(choice ==3){
			a.printRegisteredList();
		}
		else if(choice ==4){
			a.printCourseList();
			System.out.println("Please input the course code of course you want to choice as alternative: ");
			int inCode = in.nextInt();
			a.registerAlternative(inCode);
		}
		else if(choice ==5){
			a.printAlternative();
			System.out.println("Please input the course code of course you want to drop: ");
			int inDropCode = in.nextInt();
			a.dropAlternative(inDropCode);
		}
		else if(choice ==6){
			a.printAlternative();
		}
		else{
			System.out.println("Exit");
		}
	}
}
