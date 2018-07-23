package com.capgemini.paymentWallet.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capgemini.paymentWallet.Util.ClientUtil;
import com.capgemini.paymentWallet.bean.AccountDetails;
import com.capgemini.paymentWallet.bean.CustomerDetails;


public class AccountDao implements IAccountDao {

	
	AccountDetails login = new AccountDetails();
	AccountDetails account = new AccountDetails();
	CustomerDetails customer = new CustomerDetails();
	ClientUtil conn = new ClientUtil();
	static ResultSet rs1;
	public boolean addAccountDetails(AccountDetails account, CustomerDetails customer) 
	{
		int n = 0,n1 = 0;
		
				
				
				PreparedStatement p,p1;
				
				try {
					try {
						String insert1 = "insert into account values(?,?,?,?,?)";
						p = conn.getConnection().prepareStatement(insert1);
						p.setLong(1, account.getAccountNumber());
						p.setString(2,account.getPassword());
						p.setDouble(3,account.getBalance());
						p.setDouble(4,account.getAmount());
						p.setLong(5,Long.parseLong(account.getCustomer().getAadhar()));
						n = p.executeUpdate();
						
						String insert = "insert into customer values(?,?,?,?,?,?,?,?)";
						p1 = conn.getConnection().prepareStatement(insert);
						p1.setString(1, account.customer.getName());
						p1.setString(2, account.customer.getGender());
						p1.setLong(3, account.customer.getAge());
						p1.setString(4, account.customer.getEmail());
						p1.setLong(5, Long.parseLong(account.customer.getPhoneNumber()));
						p1.setLong(6,Long.parseLong(account.customer.getAadhar()) );
						p1.setString(7, account.customer.getAddress());
						p1.setLong(8, account.customer.getAccountNumber());
						n1= p1.executeUpdate();
						
						
						return true;
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				return false;
	}

	public boolean signin(long accountNumber, String password) throws  SQLException 
	{
			
		
		try {
			PreparedStatement p;
			
			String select = "select * from account";
			p = conn.getConnection().prepareStatement(select);
			ResultSet s = p.executeQuery();
			while (s.next()) 
			{
				long acc = s.getLong("accountnumber");
				String pass = s.getString("password");
				if (accountNumber == acc) 
				{
					if (password.equals(pass)) 
					{
						login.setAccountNumber(accountNumber);
						rs1 = s;
						return true;
					}
					
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

		
			return false;
	}

	public double displayBalance() throws ClassNotFoundException, SQLException 
	{
		
			String select = "select balance from account where accountnumber = ?";
			PreparedStatement p;
			p = conn.getConnection().prepareStatement(select);
			p.setLong(1, login.getAccountNumber());
			rs1 = p.executeQuery();
			if(rs1.first())
			{
				return rs1.getDouble("balance");
			}
			return 0;	
	}

	public boolean addBalance(double amount) throws ClassNotFoundException
	{
		
		
		try {
			double balance = displayBalance();
			PreparedStatement p,p1;
			String update = "update account set balance =? where accountnumber = ?";
			p = conn.getConnection().prepareStatement(update);
			double b = balance + amount;
			p.setDouble(1, b);
			p.setLong(2, login.getAccountNumber());
			p.executeUpdate();
			long transId = (long) (Math.random() * 100000 + 9999);
			System.out.println("Transaction ID is : " + transId);
			String s1 = "Amount : "+amount+" is deposited to the account number "+login.getAccountNumber()+ ". Transaction ID is : "+transId ;
			String insert = "insert into transactions values (?,?)" ;
			p1 = conn.getConnection().prepareStatement(insert);
			p1.setLong(1, login.getAccountNumber());
			p1.setString(2, s1);
			p1.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeBalance(double amount) throws ClassNotFoundException 
	{
		double b = 0;
		try {
			double balance = displayBalance();
			PreparedStatement p,p1;
			String update1 = "update account set balance =? where accountnumber = ?";
			p = conn.getConnection().prepareStatement(update1);
			b = balance - amount;
			p.setDouble(1, b);
			p.setLong(2, login.getAccountNumber());
			p.executeUpdate();
			long transId = (long) (Math.random() * 100000 + 9999);
			System.out.println("Transaction ID is : " + transId);
			String s2 = "Amount : "+amount+" is debited from your account number "+login.getAccountNumber()+ ". Transaction ID is : "+transId ;
			String insert = "insert into transactions values (?,?)" ;
			p1 = conn.getConnection().prepareStatement(insert);
			p1.setLong(1, login.getAccountNumber());
			p1.setString(2, s2);
			p1.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean fundTransfer(long benificiary, double amount) throws ClassNotFoundException 
	{
		try {
			double balance = displayBalance();
			PreparedStatement p,p1;
			String update1 = "update account set balance =? where accountnumber = ?";
			p = conn.getConnection().prepareStatement(update1);
			double b = balance - amount;
			p.setDouble(1, b);
			p.setLong(2, login.getAccountNumber());
			p.executeUpdate();
			long transId = (long) (Math.random() * 100000 + 9999);
			System.out.println("Transaction ID is : " + transId);
			String s3 = "Amount : "+amount+" is transferred to the account number "+benificiary+ ". Transaction ID is : "+transId ;
			String insert = "insert into transactions values (?,?)" ;
			p1 = conn.getConnection().prepareStatement(insert);
			p1.setLong(1, login.getAccountNumber());
			p1.setString(2, s3);
			p1.executeUpdate();

			double balance1 = displayBalance();
			PreparedStatement p2;
			String update2 = "update account set balance =? where accountnumber = ?";
			p1 = conn.getConnection().prepareStatement(update2);
			b = balance + amount;
			p1.setDouble(1, b);
			p1.setLong(2, benificiary);
			p1.executeUpdate();
			String s4 = "Amount : "+amount+" is transferred to your account from Account Number "+login.getAccountNumber()+ ". Transaction ID is : "+transId ;
			String insert1 = "insert into transactions values (?,?)" ;
			p1 = conn.getConnection().prepareStatement(insert1);
			p1.setLong(1, benificiary);
			p1.setString(2, s4);
			p1.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean printTransaction() throws ClassNotFoundException
	{
		PreparedStatement p;
		String select = "select * from transactions where accountnumber = ?";
		try {
			p = conn.getConnection().prepareStatement(select);
			p.setLong(1, login.getAccountNumber());
			ResultSet rs = p.executeQuery();
			while(rs.next())			
			{
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return false;
	}
}
