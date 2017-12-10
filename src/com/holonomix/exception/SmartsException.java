package com.holonomix.exception;

public class SmartsException extends Exception{

	
	public static int CONNECTION_ERROR = 1;
	public static int DATA_ERROR = 0;
	public static int TIMEOUT = 3;
	int typeError =0;
	
	public int getTypeError() {
		return typeError;
	}



	public SmartsException(String message) {
		super(message);
		if (message.indexOf("server disconnected")!=-1 || message.indexOf("connection abort")!=-1)
			
			this.typeError = CONNECTION_ERROR;
		else 
			this.typeError = DATA_ERROR;
		
		
	}



	public SmartsException(int typeError) {
		this.typeError = typeError;
	}
	
	public String getMessage(){
		if (super.getMessage()==null){
			
			if (typeError==SmartsException.DATA_ERROR)
				return " data issue";
			else 
				return " connection issue";
		}
		else 
			return super.getMessage();
		
	}
	
	public SmartsException() {
	  }
	 
	
}
