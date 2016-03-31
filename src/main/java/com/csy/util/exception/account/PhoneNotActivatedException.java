package com.csy.util.exception.account;

public class PhoneNotActivatedException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public PhoneNotActivatedException(String account,Throwable t){
		super(account, t);
	}
	
	public PhoneNotActivatedException(String account){
		super(account);
	}
}
