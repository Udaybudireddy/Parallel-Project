package com.capgemini.service;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.CustomerDetails;
import com.capgemini.dao.AccountDao;

public class AccountService implements IAccountService{
	
	AccountDao dao = new AccountDao();

	public boolean addAccountDetails(AccountDetails account, CustomerDetails customer) {
		
		return dao.addAccountDetails(account,customer);
	}
	
	public boolean signin(long accountNumber, String password) {
		
		return dao.signin(accountNumber, password);	
	}

	public double displayBalance() {
		
		return dao.displayBalance();
	}

	public boolean addBalance(double amount) {
		
		return dao.addBalance(amount);
	}

	public boolean removeBalance(double amount) {
		
		return dao.removeBalance(amount);
	}

	public boolean fundTransfer(long benificiary, double amount) {
		
		return dao.fundTransfer(benificiary, amount);
	}

	public boolean printTransaction() {
		
		return dao.printTransaction();
	}

	
	
	


}
