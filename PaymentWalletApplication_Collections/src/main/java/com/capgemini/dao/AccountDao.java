package com.capgemini.dao;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.CustomerDetails;

public class AccountDao implements IAccountDao {

	AccountDetails login = new AccountDetails();
	AccountDetails account = new AccountDetails();

	static List<AccountDetails> list1 = new ArrayList<AccountDetails>();
	static List<CustomerDetails> list2 = new ArrayList<CustomerDetails>();
	static List<String> details = new ArrayList<String>();
	

	public boolean addAccountDetails(AccountDetails account, CustomerDetails customer) 
	{
		boolean b1 = list1.add(account);
		boolean b2 = list2.add(customer);

		System.out.println(list1);
		System.out.println(list2);
		if (b1 && b2) 
		{
			return true;
		} else {
			return false;
		}

	}

	public boolean signin(long accountNumber, String password) 
	{

		Iterator<AccountDetails> it = list1.iterator();

		while (it.hasNext()) 
		{
			AccountDetails account = (AccountDetails) it.next();
			if (accountNumber == account.getAccountNumber()) 
			{
				if (password.equals(account.getPassword())) 
				{
					login=account;
					return true;
				}
			}
		}
			return false;
	}

	public double displayBalance() 
	{
		Iterator<AccountDetails> it = list1.iterator();
		double r = 0;
		while (it.hasNext()) 
		{
			AccountDetails account = (AccountDetails) it.next();
			if (login.getAccountNumber() == account.getAccountNumber()) 
			{
				r = account.getBalance();
				System.out.println("Your Account Balance is : ");
				return r;
		}
		}
		return 0;
	}

	public boolean addBalance(double amount) 
	{
		Iterator<AccountDetails> it = list1.iterator();
		
		while (it.hasNext()) 
		{
			double b = 0;
			AccountDetails account = (AccountDetails) it.next();
			if (login.getAccountNumber() == account.getAccountNumber()) 
			{
				account.setAmount(amount);
				b = account.getBalance() + account.getAmount();
				System.out.println("Your updated account balance is : ");
				System.out.println(b);
				account.setBalance(b);
				long transId = (long) (Math.random() * 100000 + 9999);
				System.out.println("Transaction ID is : " + transId);
				String s1 = "Amount : "+login.getAmount()+" is deposited to the account number "+login.getAccountNumber()+ ". Transaction ID is : "+transId ;
				login.getTransID().add(s1);
				//transID.put(transId, account.getClass());
				return true;
			}
		}
		return false;
	}

	public boolean removeBalance(double amount) 
	{
		Iterator<AccountDetails> it = list1.iterator();
		while (it.hasNext()) 
		{
			double b = 0;
			AccountDetails account = (AccountDetails) it.next();
			if (login.getAccountNumber() == account.getAccountNumber()) 
			{
				account.setAmount(amount);
				b = account.getBalance() - account.getAmount();
				System.out.println("Your updated account balance is : ");
				System.out.println(b);
				account.setBalance(b);
				long transId = (long) (Math.random() * 100000 + 9999);
				System.out.println("Transaction ID is : " + transId);
				String s2 = "Amount : "+login.getAmount()+" is debited from  the account number "+login.getAccountNumber()+ ". Transaction ID is : "+transId ;
				login.getTransID().add(s2);
				return true;
			}

		}
		return false;

	}

	public boolean fundTransfer(long benificiary, double amount) 
	{
		Iterator<AccountDetails> it1 = list1.iterator();

		while (it1.hasNext()) 
		{
			AccountDetails account = (AccountDetails) it1.next();
			if (login.getAccountNumber() == account.getAccountNumber()) 
			{
				account.setAmount(amount);
				account.setBenificiary(benificiary);
				double b = account.getBalance() - account.getAmount();
				System.out.println("Your updated account balance is : ");
				account.setBalance(b);
				System.out.println(b);
				long transId = (long) (Math.random() * 100000 + 9999);
				System.out.println("Transaction ID is : " + transId);
				String s3 = "Amount : "+login.getAmount()+" is transferred to the account number "+login.getBenificiary()+ ". Transaction ID is : "+transId ;
				login.getTransID().add(s3);
				System.out.println(details);
			}

		}
		Iterator<AccountDetails> it2 = list1.iterator();

		while (it2.hasNext()) 
		{

			double b = 0;

			AccountDetails account = (AccountDetails) it2.next();

			if (account.getAccountNumber() == benificiary) {

				account.setAmount(amount);
				System.out.println(account.getAmount());
				b = account.getBalance() + account.getAmount();
				account.setBalance(b);
				return true;
			}

		}
		return false;
	}

	public boolean printTransaction() 
	{
		
		 Iterator<AccountDetails> it = list1.iterator();
		 while (it.hasNext())
		 {
			 AccountDetails account = it.next();
			
			 if (login.getAccountNumber() == account.getAccountNumber())
			 {
				 System.out.println(account.getTransID());
				 return true;
			 }
		 }
		 return false;

	}
}
