package fr.nexeo.kata.bankAccount.entities;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

	private String number;
	private String holderName;
	private double balance;
	private double overdraft;
	List<Operation> operations;
	
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}
	public List<Operation> getOperations() {
		return new ArrayList<Operation>(operations);
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
}
