
public class SavingAccount extends Account{
	
	public SavingAccount(){
	
	}
	public SavingAccount(int i) {
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
		if(getBalance() - withDraw <0){
			System.out.println("You do not have enough money on your account.");
			withDraw =0;
		}
		else withdraw1(withDraw);
	}
	
}