package com.capgemini.paymentWallet.bean;

import com.capgemini.bean.AccountDetails;

import junit.framework.Assert;
import junit.framework.TestCase;

public class AccountDetailsTest extends TestCase {

	AccountDetails account = new AccountDetails();
	
	
	
	
	public void testGetPassword() {
		account.setPassword("asdasdasd");
		
		Assert.assertEquals("asdasd",account.getPassword());//fail case
		Assert.assertEquals("asdasdasd",account.getPassword());//pass case
		Assert.assertNotSame("asdas",account.getPassword());//pass case	
	}


	

	public void testGetAccountNumber() {
		
		account.setAccountNumber(12345);
		
		Assert.assertEquals(12345,account.getAccountNumber());//pass case
		Assert.assertEquals("k",account.getAccountNumber());//fail case
		Assert.assertNotSame(1234,account.getAccountNumber());//pass case
	}

	public void testGetBalance() {
		
		account.setBalance(1999);;
		
		Assert.assertEquals(1999,account.getBalance());//fail case
		Assert.assertEquals("k",account.getBalance());//fail case
		Assert.assertNotSame(1234,account.getBalance());//pass case
	}

	

	public void testGetAmount() {
		
		account.setAmount(1999);
		
		Assert.assertEquals(1999,account.getAmount());//fail case
		Assert.assertEquals(1234,account.getAmount());//fail case
		Assert.assertNotSame(1234,account.getAmount());//pass case
		
	}

	}


