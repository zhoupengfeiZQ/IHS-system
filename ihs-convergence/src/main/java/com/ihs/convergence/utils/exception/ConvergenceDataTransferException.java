package com.ihs.convergence.utils.exception;

public class ConvergenceDataTransferException extends ConvergenceException {
	
	private static final long serialVersionUID = 1L;
	
	public ConvergenceDataTransferException(int errorSubCode,String type,String message) {
		super(errorSubCode,type,message);
	}
	
	public ConvergenceDataTransferException(int errorSubCode,String type,String message,Throwable e) {
		super(errorSubCode,type,message,e);
	}
	
	public ConvergenceDataTransferException(String type, String message,Throwable e) {
		super(type,message,e);
	}
}
