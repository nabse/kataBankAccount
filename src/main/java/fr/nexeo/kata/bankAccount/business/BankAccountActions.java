package fr.nexeo.kata.bankAccount.business;

import java.util.Date;
import java.util.List;

import fr.nexeo.kata.bankAccount.entities.BankAccount;
import fr.nexeo.kata.bankAccount.entities.DepositOperation;
import fr.nexeo.kata.bankAccount.entities.Operation;
import fr.nexeo.kata.bankAccount.entities.WithdrawOperation;
import fr.nexeo.kata.bankAccount.exceptions.UnauthorizedAmountException;

public class BankAccountActions implements IBankAccountActions{
	
	/**
	 * 
	 * @param bankAccounts
	 * @param accountNumber
	 * @param amountToDebit
	 * @throws AccountNotExistingException
	 * @throws UnauthorizedAmountException
	 */
	public void withdraw(BankAccount account,double amount, Date date) throws UnauthorizedAmountException {
		Operation operation = new WithdrawOperation(amount, date);
		double newBalance = account.getBalance() - amount;
		if(newBalance < -account.getOverdraft()) {
			throw new UnauthorizedAmountException("ACCOUNT_BALANCE_INSUFFICIENT_FOR_SUCH_WITHDRAW");
		}
		account.getOperations().add(operation);
		account.setBalance(newBalance);
	}

	/**
	 * 
	 * @param account
	 * @throws UnauthorizedAmountException 
	 */
	public void withdrawAll(BankAccount account, Date date) throws UnauthorizedAmountException {
		if(account.getBalance() < ZERO) {
			throw new UnauthorizedAmountException("ACCOUNT_BALANCE_INSUFFICIENT_TO_WITHDRAW_ALL_SAVINGS");
		}
		Operation operation = new WithdrawOperation(account.getBalance(), date);
		account.getOperations().add(operation);
		account.setBalance(ZERO);
	}

	/**
	 * 
	 * @param bankAccounts
	 * @param accountNumber
	 * @param amountToCredit
	 * @throws AccountNotExistingException
	 */
	public void deposit(BankAccount account, double amount, Date date) {
		Operation operation = new DepositOperation(amount, date);
		double newBalance = account.getBalance() + amount;
		account.setBalance(newBalance);
		account.getOperations().add(operation);
	}

	/**
	 * @param operations
	 */
	public void checkOperationsHistory(BankAccount account, List<Operation> operations) {
		account.setOperations(operations);
	}
}

