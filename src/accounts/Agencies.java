package accounts;
import java.util.ArrayList;


public class Agencies {
  private int number;
  private String name;
  private ArrayList<SavingsAccount> savingAccounts = new ArrayList<SavingsAccount>();
  private ArrayList<CheckingAccount> checkingAccounts = new ArrayList<CheckingAccount>();

  public Agencies(int number, String name){
	  this.number = number;
	  this.name = name;
  }


public void addSavingsAccount(String name, int id) {
	savingAccounts.add(new SavingsAccount(name, id));
}
public void addCheckingAccount(String name, int id) {
	checkingAccounts.add(new CheckingAccount(name, id));
}
public SavingsAccount findSavingsAccount(int id) {
	for(SavingsAccount sa : savingAccounts) {
		if(sa.getId()==id) {
			return sa;
		}
	}
	return null;
}
public CheckingAccount findCheckingAccount(int id) {
	for(CheckingAccount ca : checkingAccounts) {
		if(ca.getId()==id) {
			return ca;
		}
	}
	return null;
}

public int getNumber() {
	return number;
}
  
public String getName() {
	return name;
}
}
