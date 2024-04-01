package accounts;

import java.util.ArrayList;

public class BaseAccount{
	protected int id;
	protected String name;
	protected double saldo;
	protected ArrayList<String> statement = new ArrayList<String>();
	
	public  void newBankStatementItem(String operation) {
		statement.add(operation);
	};
		
		
	
	public void Deposito(double value) {
			 saldo+=value;
			 statement.add("Depósito no valor de "+ value +".Saldo anterior: " + (saldo-value) +" Saldo atual:"+ saldo+".");
	}
	
	public void Saque( double value) {
		if(saldo>=value) {
			 saldo-=value;
			 statement.add("Saque no valor de "+ value +".Saldo anterior: " + (saldo+value) +" Saldo atual:"+ saldo+".");

		 }
		 
	}
	public void Transference(double value, BaseAccount accountDestination) {
		if(saldo>= value) {
			saldo-=value;
			accountDestination.saldo +=value ; 
			 statement.add("Transferência feita no valor de "+ value +".Saldo anterior: " + (saldo+value) +" Saldo atual:"+ saldo+".");
			 accountDestination.statement.add("Transferência recebida no valor de "+ value +".Saldo anterior: " + (accountDestination.saldo-value) +" Saldo atual:"+ accountDestination.saldo+".");
		}
		
	}
	public void StatementBank() {
		for(String operation : statement) {
			System.out.println(operation+"\n");
		}
	}

	public int getId() {
		return id;
	}
	
	public double getSaldo() {
		return saldo;
	}

	}

