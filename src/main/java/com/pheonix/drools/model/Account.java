package com.pheonix.drools.model;

import java.io.Serializable;

/**
 * 
 * This class is used to check the account balance
 * 
 * @author Vikas.Sharma1
 * 
 */
public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer accountBalance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Integer accountBalance) {
		this.accountBalance = accountBalance;
	}

	public boolean withdrawMoney(Integer money) {
		accountBalance = accountBalance - money;

		System.out
				.println("You have withdrawn amount of Rs : "
						+ money
						+ " from your account. Current Account balance after withdrawl is :"
						+ accountBalance);
		return true;
	}
	
	@Override
	public String toString() {
		return "Account [name=" + name + ", accountBalance=" + accountBalance
				+ "]";
	}

}
