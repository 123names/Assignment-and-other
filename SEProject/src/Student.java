import java.sql.SQLException;
import java.util.ArrayList;

public class Student extends Account{

	private DatabaseLink db = new DatabaseLink();
	private ArrayList<Course>listRegistered = new ArrayList<>();
	private ArrayList<Course>listAlternative = new ArrayList<>();
	private ArrayList<Course>listTaken = new ArrayList<>();
	
	public Student(){
		
	}
	public void setListRegister(ArrayList<Course>list){
		listRegistered = list;
	}
	public ArrayList<Course> getRegistered(){
		return listRegistered;
	}
	public void setListAlternative(ArrayList<Course>list){
		listAlternative = list;
	}
	public ArrayList<Course> getAlternative(){
		return listRegistered;
	}
	public void registerAlternative(int code) throws SQLException{
		int alternativeMax = 2;
		int courseCurrNum = listRegistered.size();
		int courseListNum = sharedCourseList.size();
		int alternativeCurrNum = listAlternative.size();
		boolean registered = false;
		boolean registeredAlternative = false;
		boolean closeToRegister = db.getRegisteredDeadlineInfo(code);
		if(closeToRegister){
			System.out.println("The course is close to registeration.");
		}
		else{
			if(courseCurrNum!=4){
				System.out.println("You have not register enough course yet, this is only backup menu, please fill register course first.");
			}
			else{
				if(alternativeCurrNum>=alternativeMax){
					System.out.println("You have already eroll 2 courses, you can't eroll anymore.");
				}
				else{
					for(int i =0;i<courseCurrNum;i++){
						Course check = listRegistered.get(i);
						int codeR = check.getCode();
						if(code ==codeR ){
							registered = true;
						}
					}
					if(registered){
						System.out.print("You already registered that course.");
					}
					else{
						for(int i = 0;i<alternativeCurrNum;i++){
							Course check = listAlternative.get(i);
							int codeR = check.getCode();
							if(code ==codeR ){
								registeredAlternative = true;
							}
						}
						if(registeredAlternative){
							System.out.print("You already registered that course as alternative.");
						}
						else{
							Course choiceOne = null;
							for(int i = 0; i<courseListNum; i++){
								Course codeCheck = sharedCourseList.get(i);
								if(codeCheck.getCode()==code){
									choiceOne = sharedCourseList.get(i);
								}
							}
							if(choiceOne==null){
								System.out.println("The course Code your input is not vaild");
							}
							else{
								ArrayList<Student> StudentInCourse = db.getStudentListInCourse(code);
								int courseSize =StudentInCourse.size();
								int courseSizeLimit = 10;
								if(courseSize>=courseSizeLimit){
									System.out.println("The Course is full.");
								}
								else{
									listAlternative.add(choiceOne);
									db.addAlternativeCourse(getId(),getName(), code, choiceOne.getName());
									System.out.println("Register alternative successful.");
								}
							}
						}
					}
				}
				System.out.println("You now have "+listAlternative.size()+ " Alternative Course reigstered.");
			}
		}
	}
	public void registerCourse(int code) throws SQLException{
		
		int courseMax = 4;
		int courseCurrNum = listRegistered.size();
		int courseListNum = sharedCourseList.size();
		boolean registered = false;
		boolean closeToRegister = db.getRegisteredDeadlineInfo(code);
		if(closeToRegister){
			System.out.println("The course is close to registeration.");
		}
		else{
			if(courseCurrNum>=courseMax){
				System.out.println("You have already eroll 4 courses, you can't eroll anymore.");
			}
			else{
				for(int i =0;i<courseCurrNum;i++){
					Course check = listRegistered.get(i);
					int codeR = check.getCode();
					if(code ==codeR ){
						registered = true;
					}
				}
				if(registered){
					System.out.print("You already registered that course.");
				}
				else{
					Course choiceOne = null;
					for(int i = 0; i<courseListNum; i++){
						Course codeCheck = sharedCourseList.get(i);
						if(codeCheck.getCode()==code){
							choiceOne = sharedCourseList.get(i);
						}
					}
					if(choiceOne==null){
						System.out.println("The course Code your input is not vaild");
					}
					else{
						ArrayList<Student> StudentInCourse = db.getStudentListInCourse(code);
						int courseSize =StudentInCourse.size();
						int courseSizeLimit = 10;
						if(courseSize>=courseSizeLimit){
							System.out.println("The Course is full.");
						}
						else{
							listRegistered.add(choiceOne);
							db.updateRegisteredCourse(getId(),getName(), code, choiceOne.getName());
							System.out.println("Register successful.");
						}
					}
				}
			}
			System.out.println("You now have "+listRegistered.size()+ " Course reigstered.");
		}
	}
	public void dropCourse(int code) throws SQLException{
		int courseCurrN = listRegistered.size();
		int AlternativeNum = listAlternative.size();
		int removeIndex = 0;
		boolean exist = false;
		boolean closeToDrop = db.getDropDeadlineInfo(code);
		if(closeToDrop){
			System.out.println("The course is close to Drop.");
		}
		else{
			if(courseCurrN<=0){
				System.out.println("You have no course to drop.");
			}
			else{
				for(int i = 0; i<courseCurrN; i++){
					Course check = listRegistered.get(i);
					int codeC = check.getCode();
					if(code ==codeC){
						removeIndex = i;
						exist = true;
					}
				}
				if(exist){
					listRegistered.remove(removeIndex);
					db.updateDropCourse(getId(), code);
					System.out.println("Drop successful");
					if(AlternativeNum>0){
						int registerCode = listAlternative.get(0).getCode();
						registerCourse(registerCode);
						dropAlternative(registerCode);
					}
				}
				else{
					System.out.println("The course Code your input is not vaild on the course you have registered.");
				}
			}
		}
	}
	public void dropAlternative(int code) throws SQLException{
		int AlternativeNum = listAlternative.size();
		int removeIndex = 0;
		boolean exist = false;
		boolean closeToDrop = db.getDropDeadlineInfo(code);
		if(closeToDrop){
			System.out.println("The course is close to Drop.");
		}
		else{
			if(AlternativeNum<=0){
				System.out.println("You have no course to drop.");
			}
			else{
				for(int i = 0; i<AlternativeNum; i++){
					Course check = listAlternative.get(i);
					int codeC = check.getCode();
					if(code ==codeC){
						removeIndex = i;
						exist = true;
					}
				}
				if(exist){
					listAlternative.remove(removeIndex);
					db.dropAlternative(getId(), code);
					System.out.println("Drop successful");
				}
				else{
					System.out.println("The course Code your input is not vaild on the course you have registered.");
				}
			}
		}
	}
	public void printRegisteredList(){
		int registeredNum = listRegistered.size();
		System.out.println("The Couse list registered : ");
		for(int i = 0; i<registeredNum; i++){
			Course c = listRegistered.get(i);
			System.out.printf("%-40s%20d\n", c.getName(),c.getCode());
		}
	}
	public void printAlternative(){
		int listAlternativeNum = listAlternative.size();
		System.out.println("The Couse list Alternative : ");
		for(int i = 0; i<listAlternativeNum; i++){
			Course c = listAlternative.get(i);
			System.out.printf("%-40s%20d\n", c.getName(),c.getCode());
		}
	}
}
