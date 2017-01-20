package com.ihs.convergence.utils.exception;

public class ConvergenceDataAccessException extends ConvergenceException {
	
	private static final long serialVersionUID = 1L;
	
	public ConvergenceDataAccessException(int errorSubCode,String type, String message,Throwable e) {
		super(errorSubCode,type,message,e);
	}
}
