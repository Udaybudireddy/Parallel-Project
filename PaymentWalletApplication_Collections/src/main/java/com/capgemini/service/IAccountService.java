package com.capgemini.service;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.CustomerDetails;

public interface IAccountService {
	
	boolean addAccountDetails(AccountDetails account, CustomerDetails customer);
	
	boolean signin(long accountNumber, String password);
	 
	double displayBalance();
	 
	boolean addBalance(double amount);
	
	boolean removeBalance(double amount);
	
	boolean fundTransfer(long benificiary, double amount);
	
	boolean printTransaction();

}
