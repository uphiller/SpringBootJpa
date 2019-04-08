package com.example.demo.common.exception;

public class HunetNotFoundException extends BaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public HunetNotFoundException() {		
		this(ErrorCodes.ERROR_NOTFOUND_INFO.getMsg());
	}
	
	
	//Message만 담는 Exception을 담당하는 메서드
	public HunetNotFoundException(String msg) {		
		super(msg);		
		
	}	

}
