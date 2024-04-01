package accounts;

public class SavingsAccount extends BaseAccount{
	final double TRANSFERENCE_TAX = 0.08;
	
	public SavingsAccount(String name, int id) {
		this.id = id;
		saldo = 0.0;
		this.name = name;
	}
	

}
