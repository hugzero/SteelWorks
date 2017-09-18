package com.xwtz.platform.steel.model;

public class BigDataDealException extends Exception{
	 public BigDataDealException(String message) {
	        super(message);
	    }

	    public BigDataDealException(Throwable e) {
	        super(e);
	    }

	    public BigDataDealException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
