
public class Course {

	private int code;
	private String name;
	private String inFo = "Not to much to describe.";
	private boolean assigned = false;
	private boolean openToRegister = true;
	private boolean openToDrop = true;
	public Course(){
		
	}
	public Course(int id, String n, String detail, boolean assigned){
		this.code= id;
		name = n;
		inFo = detail;
		this.assigned = assigned;
	}
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
	public void setInfo(String info){
		inFo = info;
	}
	public String getInfo(){
		return inFo;
	}
	public void setCode(int id){
		this.code = id;
	}
	public int getCode(){
		return code;
	}
	public void setAssigned(boolean assign){
		this.assigned = assign;
	}
	public boolean getAssigned(){
		return assigned;
	}
	public void setOpenToRegister(boolean assign){
		this.openToRegister = assign;
	}
	public boolean getOpenToRegister(){
		return openToRegister;
	}
	public void setOpenToDrop(boolean assign){
		this.openToDrop = assign;
	}
	public boolean getOpenToDrop(){
		return openToDrop;
	}
}
