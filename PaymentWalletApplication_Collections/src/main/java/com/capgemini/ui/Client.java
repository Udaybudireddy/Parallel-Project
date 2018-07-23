package com.capgemini.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.CustomerDetails;
import com.capgemini.exception.AccountNotCreated;
import com.capgemini.exception.NotNumberException;
import com.capgemini.service.AccountDataValidate;
import com.capgemini.service.AccountService;
public class Client {
	static AccountDetails account = new AccountDetails();
	static AccountService service = new AccountService();
	static boolean b;

	public static void main(String[] args) {
		

		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int i;
		
		try {
			
			do
			{	
				System.out.println("*****Welcome to XYZ Bank*****");
				System.out.println("1.  Create a New Account");
				System.out.println("2. Sign in");
				System.out.println("3. Exit");
				System.out.println("Enter your choice : ");
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
					System.exit(0);
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

	private static void signin() {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Enter Your AccountNumber : ");
			long accountNumber = Long.parseLong(br.readLine());
			
			System.out.println("Enter Password : ");
			String password = br.readLine();
			
			if(service.signin(accountNumber, password))
			{
	
			int i;
				
				do
				{	
					System.out.println("1. Show Account Balance");
					System.out.println("2. Deposit the money");
					System.out.println("3. Withdraw the money");
					System.out.println("4. Transfer Funds");
					System.out.println("5. Print transactions");
					System.out.println("6. Exit");
					System.out.println("Enter your choice : ");
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
					System.err.println("AccountNumber/Password does not match");
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
			System.out.println("Enter your Name : ");
			String name = br.readLine();
		
			System.out.println("Enter Gender(Male/Female) : ");
			String gender = br.readLine();
			
			System.out.println("Enter age : ");
			Integer age = Integer.parseInt(br.readLine());
			
			System.out.println("Enter EmailID : ");
			
			do
			{
				String email = br.readLine();
				boolean isValidEmail = validate.validateemail(email);
				
				if(isValidEmail)
				{
					
					customer.setEmail(email);
					j=8;	
				}
				
			}while(j!=8);
			
			System.out.println("Enter your Address : ");
			String address = br.readLine();
			
			System.out.println("Enter Your Phone Number : ");
			do
			{
				String phoneNumber = br.readLine();
				boolean isValidPhoneNumber = validate.validatePhoneNumber(phoneNumber);
				
				if(isValidPhoneNumber)
				{
					
					customer.setPhoneNumber(phoneNumber);
					j=1;	
				}else
				{
					try {
						throw new NotNumberException();
					} catch (NotNumberException e) {
						System.err.println("Enter valid Phone Number : ");
						e.printStackTrace();
					}
				}
				
			}while(j!=1);
			
			System.out.println("Enter Your Aadhar Number : ");
			do
			{
				String aadhar = br.readLine();
				boolean isValidAadhar = validate.validateAadhar(aadhar);
				if(isValidAadhar)
				{
					customer.setAadhar(aadhar);
					j=2;	
				}
				else
				{
					try {
						throw new NotNumberException();
					} catch (NotNumberException e) {
						System.err.println("Enter valid Aadhar Number : ");
						e.printStackTrace();
					}
				}
			}while(j!=2);
			
			
			System.out.println("Enter the amount for account initiation(Minimum balance should be 500): ");
			do
			{
				double balance = Double.parseDouble(br.readLine());
				boolean isValidBalance = validate.validatebalance(balance);
				if(isValidBalance)
				{
					account.setBalance(balance);
					j=3;	
				}
				else
				{
					System.out.println("Enter valid Balance : ");
				}
				
			}while(j!=3);
			
			long accountNumber = (long)(Math.random()*100000 + 9999);
			System.out.println(transId);
			
			
			
			customer.setName(name);
			/*customer.setGender(gender);
			customer.setAge(age);
			customer.setAddress(address);*/
			account.setTransID(details);
			account.setAccountNumber(accountNumber);
			System.out.println("Set up login password for your account : ");
			do
			{
				String password = br.readLine();
				
				boolean isValidPassword = validate.validatepassword(password);
				if(isValidPassword)
				{
					account.setPassword(password);
					System.out.println("Password set successfully....");
					
					j=4;	
				}
				else
				{
					System.out.println("Enter valid Password : ");
				}
				
			}while(j!=4);
				
						
			if(service.addAccountDetails(account,customer))
			{
				
				System.out.println("Account Successfully created....");
				System.out.println("Your Account Number is : "+account.getAccountNumber());
				
			}
			else
			{
				try
				{
					throw new AccountNotCreated(); 
				}
				catch(AccountNotCreated e)
				{
					System.err.println("Account is not created.......");
				}
			}
			
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void balance() 
	{
			System.out.println(service.displayBalance());	
	}

	private static void deposit() 
	{
		System.out.println("Enter the amount to deposit : ");
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

	private static void withdraw() 
	{
		System.out.println("Enter the amount to withdraw : ");
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

	private static void fundTransfer() 
	{
		
		System.out.println("Enter the Benificiary Account Number : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			long benificiary = Long.parseLong(br.readLine());
			System.out.println("Enter the amount to transfer : ");
			double amount = Double.parseDouble(br.readLine());
			service.fundTransfer(benificiary, amount);
		} catch (NumberFormatException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	private static void print() 
	{
		
		service.printTransaction();
		
		
	}

}
