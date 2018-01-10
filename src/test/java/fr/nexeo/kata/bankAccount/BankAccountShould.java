package fr.nexeo.kata.bankAccount;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.nexeo.kata.bankAccount.business.BankAccountActions;
import fr.nexeo.kata.bankAccount.business.IBankAccountActions;
import fr.nexeo.kata.bankAccount.entities.BankAccount;
import fr.nexeo.kata.bankAccount.entities.DepositOperation;
import fr.nexeo.kata.bankAccount.entities.Operation;
import fr.nexeo.kata.bankAccount.entities.WithdrawOperation;
import fr.nexeo.kata.bankAccount.exceptions.UnauthorizedAmountException;

public class BankAccountShould {
	
	private static BankAccount account = new BankAccount();
	private static double delta_double = 0.01;
	
	static {
		account.setOverdraft(100.00);
	}
	
	@Test
	public void make_deposit_given_amount_and_date() {
		//Given
		double amount = 20.00;
		account.setBalance(33.90);
		Date date = new Date();
		
		//When
		IBankAccountActions accountActions = new BankAccountActions();
		accountActions.deposit(account, amount, date);
		
		//Then
		double expectedResult = 53.90;
		double actualResult = account.getBalance();
		assertEquals(expectedResult, actualResult, delta_double);
	}
	
	
	@Test
	public void retrieve_some_savings_given_amount_and_date() throws UnauthorizedAmountException {
		//Given
		double amount = 20.00;
		account.setBalance(33.00);
		Date date = new Date();
		
		//When
		IBankAccountActions accountActions = new BankAccountActions();
		accountActions.withdraw(account, amount, date);
		
		//Then
		double expectedResult = 13.00;
		double actualResult = account.getBalance();
		assertEquals(expectedResult, actualResult, delta_double);
	}
	
	@Test(expected = UnauthorizedAmountException.class)
	public void throw_exception_following_withdraw_attempt_under_authorized_overdraft() throws UnauthorizedAmountException {
		//Given
		double amount = 120.00;
		account.setBalance(10.00);
		Date date = new Date();
		
		//When
		IBankAccountActions accountActions = new BankAccountActions();
		accountActions.withdraw(account, amount, date);
	}
	
	@Test
	public void retrieve_all_savings() throws UnauthorizedAmountException {
		//Given
		Date date = new Date();
		account.setBalance(500.00);
		//When
		IBankAccountActions accountActions = new BankAccountActions();
		accountActions.withdrawAll(account, date);
		
		//Then
		double expectedResult = 0.00;
		double actualResult = account.getBalance();
		assertEquals(expectedResult, actualResult, delta_double);
	}
	
	@Test(expected = UnauthorizedAmountException.class)
	public void throw_exception_following_withdrawAll_attempt_under_authorized_overdraft() throws UnauthorizedAmountException {
		//Given
		account.setBalance(-10.00);
		Date date = new Date();
		
		//When
		IBankAccountActions accountActions = new BankAccountActions();
		accountActions.withdrawAll(account, date);
	}
	
	@Test
	public void check_operations_history() {
		//Given
		List<Operation> operations = new ArrayList<Operation>();
		
		Operation operation1 = new DepositOperation(10.00, new Date());
		operations.add(operation1);
		Operation operation2 = new WithdrawOperation(20.00, new Date());
		operations.add(operation2);
		Operation operation3 = new DepositOperation(70.00, new Date());
		operations.add(operation3);
		Operation operation4 = new WithdrawOperation(80.00, new Date());
		operations.add(operation4);
		
		//When
		account.setOperations(operations);
		
		//Then
		assertEquals(account.getOperations(), operations);
	}
}
