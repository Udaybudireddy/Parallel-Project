package com.capgemini.paymentWallet.Service;

import java.sql.SQLException;

import com.capgemini.paymentWallet.bean.AccountDetails;
import com.capgemini.paymentWallet.bean.CustomerDetails;

public interface IAccountService {
	
	boolean addAccountDetails(AccountDetails account, CustomerDetails customer);
	
	boolean signin(long accountNumber, String password) throws SQLException;
	 
	double displayBalance() throws ClassNotFoundException, SQLException;
	 
	boolean addBalance(double amount) throws ClassNotFoundException;
	
	boolean removeBalance(double amount) throws ClassNotFoundException;
	
	boolean fundTransfer(long benificiary, double amount) throws ClassNotFoundException;
	
	boolean printTransaction() throws ClassNotFoundException;

}
