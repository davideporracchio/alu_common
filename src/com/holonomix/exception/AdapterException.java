package com.holonomix.exception;

public class AdapterException extends Exception{

	public AdapterException() {
	  }
	
	public AdapterException(int categoryError) {
		//if (categoryError == 1)
		//	 System.out.println("SEVERE ERROR FAIL OVER");
		this.categoryError=categoryError;
	  }
	
	int categoryError = 0 ;
	
	public int getCategoryError() {
		return categoryError;
	}

	public void setCategoryError(int categoryError) {
		//if (categoryError == 1)
		//	 System.out.println("SEVERE ERROR FAIL OVER");
		this.categoryError = categoryError;
	}

	public AdapterException(String msg) {
		    super(msg);
	  }
	
}
