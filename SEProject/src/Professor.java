import java.sql.SQLException;
import java.util.ArrayList;

public class Professor extends Account{

	public ArrayList<Course>listChoiced = new ArrayList<>();
	private DatabaseLink db = new DatabaseLink();
	
	public Professor(){
		
	}
	public void setListChoiced(ArrayList<Course>list){
		listChoiced = list;
	}
	public void choiceCourse(int code) throws SQLException{
		int courseMax = 3;
		int courseCurr = listChoiced.size();
		int courseNum = sharedCourseList.size();
		boolean registered = false;
		if(courseCurr>=courseMax){
			System.out.println("You have already choice 3 courses.");
		}
		else{
			for(int i =0;i<courseCurr;i++){
				Course check = listChoiced.get(i);
				int codeR = check.getCode();
				if(codeR ==code ){
					registered = true;
				}
			}
			if(registered){
				System.out.print("You already choiced that course.");
			}
			else{
				Course choiceOne = null;
				for(int i = 0; i<courseNum; i++){
					Course c = sharedCourseList.get(i);
					if(c.getCode()==code){
						choiceOne = c;
					}
				}
				if(choiceOne==null){
					System.out.println("The course Code your input is not vaild");
				}
				else{
					listChoiced.add(choiceOne);
					db.updateAssignedInfo(getId(),code,choiceOne.getName());
					System.out.println("Choice successful.");
				}
			}
		}
		System.out.println("You now have "+listChoiced.size()+ " Course to teach.");
	}
	public void getStudentList(int code) throws SQLException{
		int courseNum = sharedCourseList.size();
		Course choiceOne = null;
		for(int i = 0; i<courseNum; i++){
			Course c = sharedCourseList.get(i);
			if(c.getCode()==code){
				choiceOne = c;
			}
		}
		if(choiceOne==null){
			System.out.println("The course Code your input is not vaild");
		}
		else{
			ArrayList<Student> StudentInCourse = db.getStudentListInCourse(code);
			int courseSize =StudentInCourse.size();
			System.out.println("List of student register in " + code+ ": ");
			for(int i = 0; i<courseSize; i++){
				Student s = StudentInCourse.get(i);
				System.out.printf("%-40s%20d\n",s.getName(),s.getId());
			}
		}
	}
	public void printChoiced(){
		int choiceNum = listChoiced.size();
		System.out.println("The Couse Choiced : ");
		for(int i = 0; i<choiceNum; i++){
			Course c = listChoiced.get(i);
			System.out.printf("%-40s%20d\n", c.getName(),c.getCode());
		}
	}
}
