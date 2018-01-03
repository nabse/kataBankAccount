package fr.nexeo.kata.bankAccount.entities;

import java.util.Date;

public class WithdrawOperation extends Operation{

	public WithdrawOperation(double amount, Date date) {
		super(amount, date);
	}

	@Override
	public String toString() {
		return "WithdrawOperation [amount=" + getAmount() + ", date=" + getDate() + "]";
	}

}
