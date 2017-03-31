import java.util.ArrayList;

public class Account {
	
	private String name;
	private int id;
	private String password;
	public ArrayList<Course>sharedCourseList = new ArrayList<>();
	public Account(){
		
	}
	public Account(String n){
		name = n;
		password = n;
	}
	protected String getName(){
		return name;
	}
	protected void setName(String n){
		name = n;
	}
	protected String getPassword(){
		return password;
	}
	protected void setPassword(String p){
		password = p;
	}
	protected int getId(){
		return id;
	}
	protected void SetId(int id){
		this.id = id;
	}
	public void printCourseList(){
		int courseNum = sharedCourseList.size();
		System.out.println("The Couse list:   " + "\t" +"\t" +"\t" +"\t" +"\t" +"Couse Code:  ");
		for(int i = 0; i<courseNum; i++){
			Course c = sharedCourseList.get(i);
			if(c.getOpenToRegister()){
				System.out.printf("%-40s%20d\n", c.getName(),c.getCode());
			}
			else{
				System.out.printf("%-40s%20d (Close to register)\n", c.getName(),c.getCode());
			}
		}
	}
}
