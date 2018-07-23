package com.capgemini.paymentWallet.Service;

import java.sql.SQLException;

import com.capgemini.paymentWallet.Dao.AccountDao;
import com.capgemini.paymentWallet.bean.AccountDetails;
import com.capgemini.paymentWallet.bean.CustomerDetails;

public class AccountService implements IAccountService{
	
	AccountDao dao = new AccountDao();

	public boolean addAccountDetails(AccountDetails account, CustomerDetails customer) {
		
		return dao.addAccountDetails(account,customer);
	}
	
	public boolean signin(long accountNumber, String password) throws SQLException {
		
		return dao.signin(accountNumber, password);	
	}

	public double displayBalance() throws ClassNotFoundException, SQLException {
		
		return dao.displayBalance();
	}

	public boolean addBalance(double amount) throws ClassNotFoundException {
		
		return dao.addBalance(amount);
	}

	public boolean removeBalance(double amount) throws ClassNotFoundException {
		
		return dao.removeBalance(amount);
	}

	public boolean fundTransfer(long benificiary, double amount) throws ClassNotFoundException {
		
		return dao.fundTransfer(benificiary, amount);
	}

	public boolean printTransaction() throws ClassNotFoundException {
		
		return dao.printTransaction();
	}

	
	
	


}
