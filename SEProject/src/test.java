import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class test {

	public static void main(String []args) throws SQLException{
		int id = 0;
		String password = "";
		boolean result = false;
		Scanner in = new Scanner(System.in);
		logIn logInPage = new logIn();
		try{
			System.out.println("Please input the id: ");
			id = in.nextInt();
			in.nextLine();
			System.out.println("Please input the password: ");
			password = in.next();
			password.replace(" ","");
		}
		catch(Exception e){
			System.out.println("Your input are invaild");
		}
		result = logInPage.Verfiy(password, id);
		if(result){
			try{
				System.out.println("Log in successful.");
				int check = logInPage.identify(id);
				if(check == 1){
					System.out.println("Welcome administer.");
					AdministerControl adm = new AdministerControl();
					adm.setInFo(id);
					adm.printOp();
					int choice = in.nextInt();
					adm.setChoice(choice);
					adm.action();
					while(choice<9&&choice>0){
						adm.printOp();
						choice = in.nextInt();
						in.nextLine();
						adm.setChoice(choice);
						adm.action();
					}
				}
				else if(check ==2){
					System.out.println("Welcome professor.");
					professorControl p = new professorControl();
					p.setInFo(id);
					p.printOp();
					int choice = in.nextInt();
					p.setChoice(choice);
					p.action();
					while(choice<4&&choice>0){
						p.printOp();
						choice = in.nextInt();
						in.nextLine();
						p.setChoice(choice);
						p.action();
					}
				}
				else if(check ==3){
					System.out.println("Welcome student.");
					studentControl s = new studentControl();
					s.setInFo(id);
					s.printOp();
					int choice = in.nextInt();
					s.setChoice(choice);
					s.action();
					while(choice<7&&choice>0){
						s.printOp();
						choice = in.nextInt();
						in.nextLine();
						s.setChoice(choice);
						s.action();
					}
				}
				else{
					System.out.println("Sorry, an unexpect error happened, we will fix it later.");
				}
			}
			catch(InputMismatchException e){
				System.out.println("Character you input is wrong, system tirgger exit.");
			}
			catch(Exception e){
				System.out.println("Sorry, an unexpect error happened, we will fix it later.");
			}
		}
		else{
			System.out.println("Password wrong or id is not exist.");
		}
		
	}
}
