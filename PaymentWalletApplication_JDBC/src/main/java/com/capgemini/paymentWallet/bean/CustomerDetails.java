package com.capgemini.paymentWallet.bean;

public class CustomerDetails {
	
	private String name;
	private String gender;
	private int age;
	private String email;
	private String phoneNumber;
	private String aadhar;
	private String address;
	private long accountNumber;
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "CustomerDetails [name=" + name + ", gender=" + gender + ", age=" + age + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", aadhar=" + aadhar + ", address=" + address + "]\n";
	}
	
	

}
