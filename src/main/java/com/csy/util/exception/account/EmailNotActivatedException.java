package com.csy.util.exception.account;

public class EmailNotActivatedException extends Exception{
	private static final long serialVersionUID = 1L;

	public EmailNotActivatedException(String account,Throwable t){
		super(account, t);
	}
	
	public EmailNotActivatedException(String account){
		super(account);
	}
}
