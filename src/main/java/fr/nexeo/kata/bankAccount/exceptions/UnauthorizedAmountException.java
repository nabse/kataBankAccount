package fr.nexeo.kata.bankAccount.exceptions;

import org.apache.log4j.Logger;

public class UnauthorizedAmountException extends Exception {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(UnauthorizedAmountException.class);
	
	public UnauthorizedAmountException(String message) {
		logger.warn(message);
	}
}
