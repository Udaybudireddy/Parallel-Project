package com.capgemini.paymentWallet.Service;

public class AccountDataValidate 
{

	public boolean validatePhoneNumber(String phoneNumber) 
	{
		
		if(phoneNumber.length()==10)
		{
			return true;
		}
		else
		{
			return false;	
		}
		
	}

	public boolean validateAadhar(String aadhar) 
	{
		if(aadhar.length()==12)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public boolean validatebalance(double balance)
	{

		if(balance>=500)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	
	}

	public boolean validatepassword(String password) 
	{
		if(password.length()>=8)
		{
			return true;
		}
		else
		{
			return false;	
		}
		
	}

	public boolean validateemail(String email) 
	{
		if(email.contains("@") && email.contains(".com"))
		{
			return true;
		}
		else
		{
			
		}
		return false;
	}

	public boolean validateName(String name) 
	{
		char[] n = name.toCharArray();
		for(int i=0;i<n.length;i++)
		{
			if( (n[i] >= 'a' && n[i] <= 'z') || (n[i] >= 'A' && n[i] <= 'Z'))
			{
				return true;
			}
		}
		
		return false;
	}

	public boolean validateGender(String gender) 
	{
		
		if(gender.equalsIgnoreCase("male")|| gender.equalsIgnoreCase("female"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}

	
