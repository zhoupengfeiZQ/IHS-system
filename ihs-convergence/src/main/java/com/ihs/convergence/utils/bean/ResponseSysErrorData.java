package com.ihs.convergence.utils.bean;

import java.io.Serializable;



public class ResponseSysErrorData implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	//descr about some error message
    private String message;
    //exception type
    private String type;
    //error  code
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

   
}
