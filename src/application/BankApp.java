package application;
import java.util.Scanner;
import java.util.ArrayList;
import accounts.Agencies;
import accounts.CheckingAccount;
import accounts.SavingsAccount;
public class BankApp {


	public static void main(String[]args) {
		boolean loop = true;
		int option;
		ArrayList<Agencies> BankAgencies = new ArrayList<Agencies>(); 
		if(BankAgencies.isEmpty())
		System.out.println("Sim");
		
		Scanner sc = new Scanner(System.in);
		while(loop) { 
			System.out.print(
					    " --------------------------------------- "
					+ "\n|      Bem-Vindo ao Banco Mondial!      |"
			 		+ "\n|                                       |"
					+ "\n|   MENU                                |"
					+ "\n|                                       |"
					+ "\n|   1-Adicionar agência bancária;       |"
					+ "\n|   2-Adicionar um cliente;             |"
					+ "\n|   3-Fazer um Depósito;                |"
					+ "\n|   4-Fazer um Saque;                   |"
					+ "\n|   5-Fazer uma transferência;          |"
					+ "\n|   6-Consultar extrato;                |"
					+ "\n|                                       |"
					+ "\n|   7-Encerrar sistema.                 |"
					+ "\n --------------------------------------- "
					+ "\nSua escolha: ");
			
			option = sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("Nome da agência bancária:");
				String name = sc.next();
				System.out.println("Número da agência bancária:");
				int number = sc.nextInt();
				BankAgencies.add(new Agencies(number, name));
				break;
			case 2:
				if(!BankAgencies.isEmpty()) {
					System.out.println("Entre com o número da agência do novo cliente:");
					int agencyNumber = sc.nextInt();
					for(Agencies ag : BankAgencies) {
						if (ag.getNumber()== agencyNumber) {
							System.out.println("Entre com o nome do cliente:");
							String clientName = sc.next();
							System.out.println("Entre com o Id do cliente:");
							int clientId = sc.nextInt();
							System.out.println("Escolha o tipo de conta 1-Conta poupança ou 2-Conta corrente:");
							int accountType = sc.nextInt();
							switch(accountType) {
							case 1:
								ag.addSavingsAccount(clientName, clientId);
								break;
							case 2:
								ag.addCheckingAccount(clientName, clientId);
								break;
								default:
									System.out.println("Opçao inválida.");
							}
						}else {
							System.out.println("Agência não encontrada.");
						}
					}
				}else
					System.out.println("Nenhuma agencia cadastrada!");
				break;
			case 3: 
				if(!BankAgencies.isEmpty()) {
					System.out.println("Entre com o número da agência:");
					int agencyNumber = sc.nextInt();
					for(Agencies ag : BankAgencies) {
					if(ag.getNumber() == agencyNumber) {
						System.out.println("Id da conta:");
						int clientId = sc.nextInt();
						System.out.println("Conta 1-Conta poupança ou 2-Conta corrente:");
						int accountType = sc.nextInt();
						switch(accountType) {
						case 1:
							SavingsAccount sa = ag.findSavingsAccount(clientId);
							if(sa!=null) {
								System.out.println("Valor do deposito:");
								double depositValue = sc.nextDouble();
								ag.findSavingsAccount(clientId).Deposito(depositValue);
							}else
								System.out.println("Cliente não encontrado.");
							break;
						case 2:
							CheckingAccount ca = ag.findCheckingAccount(clientId);
							if(ca!=null) {
								System.out.println("Valor do deposito:");
								double depositValue = sc.nextDouble();
								ag.findCheckingAccount(clientId).Deposito(depositValue);
							}else
								System.out.println("Cliente não encontrado.");
							
							break;
							default:
								System.out.println("Opçao inválida.");
						}
					}
					}
				}else
					System.out.println("Nenhuma agencia cadastrada!");
				break;
			case 4:
				if(!BankAgencies.isEmpty()) {
					System.out.println("Entre com o número da agência:");
					int agencyNumber = sc.nextInt();
					for(Agencies ag : BankAgencies) {
					if(ag.getNumber() == agencyNumber) {
						System.out.println("Id da conta:");
						int clientId = sc.nextInt();
						System.out.println("Conta 1-Conta poupança ou 2-Conta corrente:");
						int accountType = sc.nextInt();
						switch(accountType) {
						case 1:
							SavingsAccount sa = ag.findSavingsAccount(clientId);
							if(sa!=null) {
								System.out.println("Valor do saque:");
								double withdrawValue = sc.nextDouble();
								ag.findSavingsAccount(clientId).Saque(withdrawValue);
							}else
								System.out.println("Cliente não encontrado.");
							break;
						case 2:
							CheckingAccount ca = ag.findCheckingAccount(clientId);
							if(ca!=null) {
								System.out.println("Valor do saque:");
								double withdrawValue = sc.nextDouble();
								ag.findCheckingAccount(clientId).Saque(withdrawValue);
							}else
								System.out.println("Cliente não encontrado.");
							
							break;
							default:
								System.out.println("Opçao inválida.");
						}
					}
					}
				}else
					System.out.println("Nenhuma agencia cadastrada!");
				break;
			case 5:
				
				
				System.out.println("Entre com o valor a ser transferido:");
				double value = sc.nextInt();
				System.out.println("Entre com a agência da conta de destino:");
				int destinationNumber = sc.nextInt();
				System.out.println("Entre com o id da conta de destino:");
				int destinationId = sc.nextInt();
				System.out.println("Conta 1-Conta poupança ou 2-Conta corrente:");
			    int destinationType = sc.nextInt();
				System.out.println("Entre com a agencia da conta de origem:");
				int originNumber = sc.nextInt();
				System.out.println("Entre com o id da conta de origem:");
				int originId = sc.nextInt();
				System.out.println("Conta 1-Conta poupança ou 2-Conta corrente:");
			    int originType = sc.nextInt();
			    if(!BankAgencies.isEmpty()) {
			    
			    
			    	for(Agencies ago : BankAgencies) {
			    		if(ago.getNumber() == originNumber) {
			    			for(Agencies agd : BankAgencies) {
			    				if(agd.getNumber() == destinationNumber) {
			    				if((originType == 1)&&(destinationType == 1)) {
			    					ago.findSavingsAccount(originId).Transference(value, agd.findSavingsAccount(destinationId));
			    				}else if((originType == 1)&&(destinationType == 2)) {
			    					ago.findSavingsAccount(originId).Transference(value, agd.findCheckingAccount(destinationId));
			    				}else if((originType == 2)&&(destinationType == 1)) {
			    					ago.findCheckingAccount(originId).Transference(value, agd.findSavingsAccount(destinationId));
			    				}else if((originType == 2)&&(destinationType == 2)) {
			    					ago.findCheckingAccount(originId).Transference(value, agd.findCheckingAccount(destinationId));
			    				}
			    			}
			    			}
			    	}
			    	}
			    }else
			    	System.out.println("Não existem agencias cadastradas!");
				break;
			case 6:
				System.out.println("Entre com a Agência bancaria:");
				int agNumber = sc.nextInt();
				for(Agencies ag : BankAgencies) {
					if(!BankAgencies.isEmpty()) {
						if(ag.getNumber() == agNumber) {
							System.out.println("Entre com o id do cliente:");
							int idClient = sc.nextInt();
							System.out.println("Conta 1-Conta poupança ou 2-Conta corrente:");
						    int type = sc.nextInt();
							if(type == 1) {
								ag.findSavingsAccount(idClient).StatementBank();
							}else if(type == 2) {
								ag.findCheckingAccount(idClient).StatementBank();
							}
						}
					}else {
						System.out.println("Não existem agencias cadastradas.");
					}
				}
				break;
			case 7: 
				System.out.println("Encerrando sistema ... ... ...");
				loop = false;
				break;
				default:
					System.out.println("Opção inválida");
				break;
			}
			
		}
		
			 
	
		sc.close();
	}
}
