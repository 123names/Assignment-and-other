import java.sql.SQLException;

public class logIn {
	private String inputPassword = " ";
	private int inputID = 0;
	private boolean pass = false;
	private DatabaseLink db = new DatabaseLink();
	
	public logIn(){
		
	}
	public boolean Verfiy(String p , int id) throws SQLException{
		inputPassword = p;
		inputID = id;
		boolean exist = db.verifityAccountId(inputID);
		if(exist){
			String retrivedPass = db.getAccountPassword(inputID);
			if(retrivedPass.equals(inputPassword)){
				pass = true;
			}
		}
		return pass;
	}
	public int identify(int id){
		if(id<10&&id>0){
			return 1;
		}
		else if(id>=10&&id<1000){
			return 2;
		}
		else if(id>=1000){
			return 3;
		}
		else{
			return 4;
		}
	}
}
