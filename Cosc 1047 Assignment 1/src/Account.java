import java.util.Date;
public class Account {

	Date date1 = new Date ();
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate =0;
	private Date date2;
	
	Account(){
		
	}

	public void setId (int newId){
		id = newId;
	}
	public double getId(){
		return id;
	}
	public void setBalance (double newBalance){
		balance = newBalance;
	}
	public double getBalance(){
		return balance;
	}
	public void setRate (double rate){
		annualInterestRate = rate/100;
	}
	public double getRate(){
		return annualInterestRate;
	}
	public void setDatecreated(){
		date2 = new Date();
	}

	double getMonthlyInterestRate(){
		
		return annualInterestRate /12;
	}
	double getMonthlyInterest(){
		return annualInterestRate / 12 * balance;
	}
	void withdraw1(double withDraw){
		balance = balance - withDraw;
	}
	void deposit1(double deposit1){
		balance = balance + deposit1;
	}
}