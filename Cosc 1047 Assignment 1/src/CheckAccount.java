
public class CheckAccount extends Account{

	private double overdraftLim;
	
	public CheckAccount(){
		
	}
	public CheckAccount(int i) {
		setBalance(i);
	}
	public double balance(){
		return getBalance();
	}
	public double getRate(){
		return getRate();
	}
	void deposit(double deposit1){
		deposit1(deposit1);
	}
	void withdraw(double withDraw){
		if(getBalance() - withDraw <this.overdraftLim){
			System.out.println("You can not withdraw that much, your withdraw limit is 0.");
			withDraw =0;
		}
		else withdraw1(withDraw);
	
	}
	
}

