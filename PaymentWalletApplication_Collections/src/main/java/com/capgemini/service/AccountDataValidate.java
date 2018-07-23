package com.capgemini.service;

public class AccountDataValidate {

	public boolean validatePhoneNumber(String phoneNumber) {
		
		if(phoneNumber.length()==10)
		{
			return true;
		}
		else
		{
			System.out.println("Enter valid Phone Number : ");
			return false;	
		}
		
	}

	public boolean validateAadhar(String aadhar) {
		if(aadhar.length()==12)
		{
			return true;
		}
		else
		{
			System.out.println("Enter Valid Aadhar Number : ");
			return false;
		}
		
	}

	public boolean validatebalance(double balance) {

		if(balance>=500)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	
	}

	public boolean validatepassword(String password) {
		if(password.length()>=8)
		{
			return true;
		}
		else
		{
			return false;	
		}
		
	}

	public boolean validateemail(String email) {
		if(email.contains("@") && email.contains(".com"))
		{
			return true;
		}
		else
		{
			
		}
		return false;
	}

	
}
