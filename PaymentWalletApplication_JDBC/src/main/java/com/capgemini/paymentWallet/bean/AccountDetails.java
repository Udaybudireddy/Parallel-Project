package com.capgemini.paymentWallet.bean;

import java.util.List;

public class AccountDetails {

	
	private double amount;
	private long accountNumber;
	private double balance;
	private long transId;
	private String password;
	private long benificiary;
	public CustomerDetails customer;
	private List<String> transID;
	
	public long getBenificiary() {
		return benificiary;
	}
	public void setBenificiary(long benificiary) {
		this.benificiary = benificiary;
	}
	public CustomerDetails getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getTransID() {
		return transID;
	}
	public void setTransID(List<String> transID) {
		this.transID = transID;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "AccountDetails [amount=" + amount + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", transId=" + transId + ", password=" + password + ", benificiary=" + benificiary + "]";
	}
	
	
	
}
