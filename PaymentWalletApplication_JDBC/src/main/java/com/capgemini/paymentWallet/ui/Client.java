package com.capgemini.paymentWallet.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.paymentWallet.Exception.AccountNotCreated;
import com.capgemini.paymentWallet.Exception.NotNumberException;
import com.capgemini.paymentWallet.Exception.NotValidAgeException;
import com.capgemini.paymentWallet.Exception.NotValidGenderException;
import com.capgemini.paymentWallet.Exception.NumberException;
import com.capgemini.paymentWallet.Service.AccountDataValidate;
import com.capgemini.paymentWallet.Service.AccountService;
import com.capgemini.paymentWallet.bean.AccountDetails;
import com.capgemini.paymentWallet.bean.CustomerDetails;

public class Client {
	static AccountDetails account = new AccountDetails();
	static AccountService service = new AccountService();
	static boolean b;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		

		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int i;
		
		try {
			
			do
			{	
				System.out.println("\n====================================\r\n" + 
						"\\  \\  /  X  \\  /  /|       /  \\  \\  \\  \r\n" + 
						" \\  \\/  / \\  \\/  / |___   /    \\  \\  \\ \r\n" + 
						"  \\    /   \\    /     /  /      \\  \\  \\  \r\n" + 
						"  /    \\    |  |     /  /___    /  /  /  \r\n" + 
						" /  /\\  \\   |  |    /       |  /  /  /  \r\n" + 
						"/__/  \\__\\  |  |   /________| /  /  /  \r\n" + 
						"============|==|====================\r\n" + 
						"");
				System.out.println("              @@@@@@@@ WELCOME TO XYZ BANK @@@@@@@@\n");
				System.out.println("1. NEW USER / REGISTER");
				System.out.println("2. SIGN IN");
				System.out.println("3. EXIT");
				System.out.print("ENTER YOUR CHOICE : ");
				 i = Integer.parseInt(br.readLine());
			
				switch(i)
				{
				case 1:
				{
					account();
					break;
				}
				case 2:
				{
					signin();
					break;
				}
				case 3:
				{
					exit();
					break;
				}
				}
			}while(i!=4);
			
			
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void exit() {
		System.out.println("                      @@@@@@@@ THNAK YOU FOR USING XYZ BANK APP @@@@@@@@");
		System.exit(0);
		
	}

	private static void signin() throws NumberFormatException, SQLException, ClassNotFoundException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("ENTER YOUR ACCOUNT NUMBER -----> ");
			long accountNumber = Long.parseLong(br.readLine());
			
			System.out.println("ENTER PASSWORD -----> ");
			String password = br.readLine();
			
			if(service.signin(accountNumber, password))
			{
	
			int i;
				
				do
				{	
					System.out.println("1. ACCOUNT BALANCE");
					System.out.println("2. DEPOSIT THE MONEY");
					System.out.println("3. WITHDRAW THE MONEY");
					System.out.println("4. TRANSFER");
					System.out.println("5. PRINT TRANSACTIONS");
					System.out.println("6. SIGN OUT");
					System.out.println("ENTER YOUR CHOICE : ");
					 i = Integer.parseInt(br.readLine());
				
					switch(i)
					{
					case 1:
					{
						balance();
						break;
					}
					case 2:
					{
						deposit();
						break;
					}
					case 3:
					{
						withdraw();
						break;
					}
					case 4:
					{
						fundTransfer();
						break;
					}
					case 5:
					{
						print();
						break;
					}
					case 6:
					{
						break;
					}
					}
				}while(i!=6);
			}
				else
				{
					System.err.println("?????? ACCOUNT NUMBER / PASSWORD DOES NOT MATCH ??????");
				}
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

	private static void account() 
	{
		int j=0;
		long transId = 0;
		AccountDetails account = new AccountDetails();
		CustomerDetails customer = new CustomerDetails();
		AccountDataValidate validate = new AccountDataValidate();
		AccountService service = new AccountService();
		 List<String> details = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println(" ENTER YOUR NAME -----> ");
			do
			{
				String name = br.readLine();
				
				boolean isValidName = validate.validateName(name);
				
				if(isValidName)
				{
					
					customer.setName(name);
					j=1;	
				}else
				{
					try {
						throw new NumberException();
					} catch (NumberException e) {
						System.err.println("????? ENTER VALID NAME -----> ");
					}
				}
				
			}while(j!=1);
			
			System.out.println(" ENTER GENDER (MALE/FEMALE) -----> ");
			
			do
			{
				String gender = br.readLine();
				
				boolean isValidGender = validate.validateGender(gender);
				
				if(isValidGender)
				{
					
					customer.setGender(gender);
					j=2;	
				}else
				{
					try {
						throw new NotValidGenderException();
					} catch (NotValidGenderException e) {
						System.err.println("????? ENTER VALID GENDER -----> ");
					}
				}
				
			}while(j!=2);
			
			System.out.println(" ENTER AGE -----> ");
			Integer age = Integer.parseInt(br.readLine());
			
			
			
			System.out.println(" ENTER EMAIL-ID -----> ");
			
			do
			{
				String email = br.readLine();
				boolean isValidEmail = validate.validateemail(email);
				
				if(isValidEmail)
				{
					
					customer.setEmail(email);
					j=3;	
				}
				
			}while(j!=3);
			
			
			 
			System.out.println(" ENTER YOUR PHONE NUMBER -----> ");
			do
			{
				String phoneNumber = br.readLine();
				boolean isValidPhoneNumber = validate.validatePhoneNumber(phoneNumber);
				
				if(isValidPhoneNumber)
				{
					
					customer.setPhoneNumber(phoneNumber);
					j=4;	
				}else
				{
					try {
						throw new NotNumberException();
					} catch (NotNumberException e) {
						System.err.println("????? ENTER VALID PHONE NUMBER -----> ");
						
					}
				}
				
			}while(j!=4);
			
			System.out.println(" ENTER YOUR AADHAR NUMBER -----> ");
			do
			{
				String aadhar = br.readLine();
				boolean isValidAadhar = validate.validateAadhar(aadhar);
				if(isValidAadhar)
				{
					customer.setAadhar(aadhar);
					j=5;	
				}
				else
				{
					try {
						throw new NotNumberException();
					} catch (NotNumberException e) {
						System.err.println("????? ENTER VALID AADHAR NUMBER -----> ");
						
					}
				}
			}while(j!=5);
			
			System.out.println(" ENTER YOUR ADDRESS -----> ");
			String address = br.readLine();
			
			
			System.out.println(" ENTER THE INITIAL BALANCE('MINIMUM BALANCE SHOULD BE 500 RUPEES') -----> ");
			do
			{
				double balance = Double.parseDouble(br.readLine());
				boolean isValidBalance = validate.validatebalance(balance);
				if(isValidBalance)
				{
					account.setBalance(balance);
					j=6;	
				}
				else
				{
					System.out.println("????? ENTER VALID BALANCE -----> ");
				}
				
			}while(j!=6);
			
			long accountNumber = (long)(Math.random()*100000 + 9999);
			
			

			
			//customer.setName(name);
			//customer.setGender(gender);

			customer.setAge(age);
			customer.setAddress(address);
			customer.setAccountNumber(accountNumber);
			account.setAccountNumber(accountNumber);
			account.setCustomer(customer);
			
			System.out.println(" SET UP LOGIN PASSWORD FOR YOUR ACCOUNT -----> ");
			do
			{
				String password = br.readLine();
				
				boolean isValidPassword = validate.validatepassword(password);
				if(isValidPassword)
				{
					account.setPassword(password);
					System.out.println("@@@@@@@ PASSWORD SET SUCCESSFULLY @@@@@@@");
					
					j=7;	
				}
				else
				{
					System.out.println("????? ENTER VALID PASSWORD -----> ");
				}
				
			}while(j!=7);
				
						
			if(service.addAccountDetails(account,customer))
			{
				
				System.out.println("@@@@@@  REGISTERED SUCCESSFULLY @@@@@@");
				System.out.println(" YOUR ACCOUNT NUMBER IS : "+account.getAccountNumber());
				
			}
			else
			{
				try
				{
					throw new AccountNotCreated(); 
				}
				catch(AccountNotCreated e)
				{
					System.err.println("?????? ACCOUNT IS NOT CREATED ??????");
				}
			}
			
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void balance() throws ClassNotFoundException, SQLException 
	{
		
			System.out.println(service.displayBalance());	
	}

	private static void deposit() throws ClassNotFoundException, SQLException 
	{
		System.out.println(" ENTER THE AMOUNT TO DEPOSIT -----> ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			double amount = Double.parseDouble(br.readLine());
		
			service.addBalance(amount);
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}

	private static void withdraw() throws ClassNotFoundException 
	{
		System.out.println(" ENTER THE AMOUNT TO WITHDRAW -----> ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			double amount = Double.parseDouble(br.readLine());
			service.removeBalance(amount);
		} catch (NumberFormatException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}

	private static void fundTransfer() throws ClassNotFoundException 
	{
		
		System.out.println(" ENTER THE BENIFICIARY ACCOUNT NUMBER -----> ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			long benificiary = Long.parseLong(br.readLine());
			System.out.println(" ENTER THE AMOUNT TO TRANSFER -----> ");
			double amount = Double.parseDouble(br.readLine());
			service.fundTransfer(benificiary, amount);
		} catch (NumberFormatException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	private static void print() throws ClassNotFoundException
	{
		
		service.printTransaction();
		
		
	}

}
