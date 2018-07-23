package com.capgemini.paymentWallet.bean;


import com.capgemini.bean.CustomerDetails;

import junit.framework.Assert;

public class CustomerDetailsTest {
	
	CustomerDetails customer = new CustomerDetails();
	
public void testGetAadhar() {
		
		customer.setAadhar("123123123123");
		
		Assert.assertEquals("123123",customer.getAadhar());//fail case
		Assert.assertEquals("123123123123",customer.getAadhar());//pass case
		Assert.assertNotSame("12312312",customer.getAadhar());//pass case
	}


	
		public void testGetName() {
			customer.setName("Uday Kumar Budireddy");
			
			Assert.assertEquals("uday",customer.getName());//fail case
			Assert.assertEquals("Uday Kumar Budireddy",customer.getName());//pass case
			Assert.assertNotSame("Kumar", customer.getName());//pass case
		}

	public void testGetGender() {
		customer.setGender("male");
		
		Assert.assertEquals("male",customer.getGender());//pass case
		Assert.assertEquals("k",customer.getGender());//fail case
		Assert.assertNotSame("female",customer.getGender());//pass case
		
	}

	public void testGetAge() {
		customer.setAge(24);
		
		Assert.assertEquals(24,customer.getAge());//pass case
		Assert.assertEquals(12,customer.getAge());//fail case
		Assert.assertNotSame(12,customer.getAge());//pass case
	}

	public void testGetEmail() {
		customer.setEmail("abcxyz@jkl.com");
		
		Assert.assertEquals("abcxyz@jkl.com",customer.getEmail());//pass case
		Assert.assertEquals("abcxyz@jkl",customer.getEmail());//fail case
		Assert.assertNotSame("abc@jkl.com",customer.getEmail());//pass case
	}

	public void testGetPhoneNumber() {
		
		customer.setPhoneNumber("1231231231");
		
		Assert.assertEquals("1231231231",customer.getPhoneNumber());//pass case
		Assert.assertEquals("123123123",customer.getPhoneNumber());//fail case
		Assert.assertNotSame("123123123",customer.getPhoneNumber());//pass case
	}

}
