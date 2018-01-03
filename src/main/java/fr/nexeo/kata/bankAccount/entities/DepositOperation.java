package fr.nexeo.kata.bankAccount.entities;

import java.util.Date;

public class DepositOperation extends Operation{

	public DepositOperation(double amount, Date date) {
		super(amount, date);
	}

	@Override
	public String toString() {
		return "DepositOperation [amount=" + getAmount() + ", date=" + getDate() + "]";
	}

}
