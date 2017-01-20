package com.ihs.convergence.utils.exception;

public class ConvergenceApplicationException extends ConvergenceException {
private static final long serialVersionUID = 1L;
	
	
	public ConvergenceApplicationException(int code,int errorSubCode,String type,String message){
		super(code,errorSubCode,type,message);
	}
}
