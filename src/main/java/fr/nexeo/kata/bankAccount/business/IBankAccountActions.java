package fr.nexeo.kata.bankAccount.business;

import java.util.Date;

import fr.nexeo.kata.bankAccount.entities.BankAccount;
import fr.nexeo.kata.bankAccount.exceptions.UnauthorizedAmountException;

public interface IBankAccountActions {
	
	public final static String ACCOUNT_BALANCE_INSUFFICIENT_FOR_SUCH_WITHDRAW = "Account balance insufficient for such withdraw";
	public final static String ACCOUNT_BALANCE_INSUFFICIENT_TO_WITHDRAW_ALL_SAVINGS = "Account balance insufficient to withdraw all savings";
	public final static double ZERO = 0.00;
	
	/**
	 * 
	 * @param account
	 * @param amount
	 * @param date
	 * @throws UnauthorizedAmountException
	 */
	public void withdraw(BankAccount account, double amount, Date date) throws UnauthorizedAmountException;
	
	/**
	 * 
	 * @param account
	 * @param date 
	 * @throws UnauthorizedAmountException 
	 */
	public void withdrawAll(BankAccount account, Date date) throws UnauthorizedAmountException;
	
	/**
	 * 
	 * @param account
	 * @param accountNumber
	 * @param amountToCredit
	 */
	public void deposit(BankAccount account, double amount, Date date);
}
