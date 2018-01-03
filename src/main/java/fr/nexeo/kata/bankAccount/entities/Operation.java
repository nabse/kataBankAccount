package fr.nexeo.kata.bankAccount.entities;

import java.util.Date;

public class Operation {

	private double amount;
	private Date date;
	
	
	public Operation(double amount, Date date) {
		this.amount = amount;
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return new Date(date.getTime());
	}
	public void setDate(Date date) {
		this.date = date;
	}
}