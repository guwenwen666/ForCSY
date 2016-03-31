package com.csy.util.exception.account;

public class UserNotUniqueException extends Exception{

	private static final long serialVersionUID = 1L;

	public UserNotUniqueException(String account,Throwable t){
		super(account, t);
	}
	
	public UserNotUniqueException(String account){
		super(account);
	}
}
