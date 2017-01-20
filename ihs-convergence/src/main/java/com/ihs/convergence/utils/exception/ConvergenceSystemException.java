package com.ihs.convergence.utils.exception;

public class ConvergenceSystemException extends ConvergenceException {
	
	private static final long serialVersionUID = 1L;
	
	public ConvergenceSystemException(String type,String message,Throwable e) {
		super(type,message,e);
	}
}
