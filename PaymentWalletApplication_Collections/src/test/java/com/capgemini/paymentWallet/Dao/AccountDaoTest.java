package com.capgemini.paymentWallet.Dao;

import java.sql.SQLException;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.CustomerDetails;
import com.capgemini.service.AccountService;

import junit.framework.Assert;
import junit.framework.TestCase;

public class AccountDaoTest extends TestCase {

	AccountDetails account = new AccountDetails();
	AccountService service = new AccountService();
	CustomerDetails customer = new CustomerDetails();

	public void testAddAccountDetails() {
		Assert.assertEquals(false, service.addAccountDetails(account, customer));// fail case
		Assert.assertNull(account);// fail case
		Assert.assertTrue(true);// pass case

	}


	public void testSignin() throws SQLException {
		
		Assert.assertEquals(false, service.signin(12345, "asdasdasd"));//pass case
		}




	public void testDisplayBalance() throws ClassNotFoundException, SQLException {
		
		Assert.assertEquals(false, service.displayBalance());//fail case

	}
	public void testAddBalance() throws ClassNotFoundException {
		Assert.assertNull(account);//fail case
		Assert.assertTrue(service.addBalance(10000));//fail case
		Assert.assertTrue(true);//pass case
	}

	public void testRemoveBalance() throws ClassNotFoundException {
		
		Assert.assertEquals(0, service.removeBalance(1000));//fail case
		Assert.assertTrue(true);//pass case
		Assert.assertNull(account);//fail case


	}


	public void testFundTransfer() throws ClassNotFoundException {
		
		Assert.assertEquals(0, service.fundTransfer(12345,1000));//fail case
		Assert.assertNotNull(account);//pass case


	}


	public void testPrintTransaction() throws ClassNotFoundException {
	
		Assert.assertEquals(0, service.printTransaction());//fail case
		Assert.assertNull(account);//fail case
		



	}

}
