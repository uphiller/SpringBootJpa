/* 
 * Copyright 2017 Hunet
 * EULA 라이센스에 의거하여 라이센스가 부여됩니다.
 * 귀하는 라이센스를 준수하는 경우를 제외하고는 이 파일을 사용할 수 없습니다.
 * 귀하는 라이센스의 사본을 다음의 주소에서 확인 가능합니다.
 * 
 * 	http://www.trusteer.com/en/support/end-user-license-agreement
 */
package com.example.demo.common.exception;


/**
 * Hunet Exception Class
 * 
 * @author 	sjc0502
 * @since 	2017. 7. 20.
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *   
 *   수정일			수정자				수정내용
 *  ---------------------------------------------------------------------------------
 *   2017. 7. 20.		sjc0502				최초생성
 * 
 * </pre>
 */

public class HunetException extends BaseException {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public HunetException() {		
		this(ErrorCodes.ERROR_GLOBAL.getMsg());
	}
	
	
	//Message만 담는 Exception을 담당하는 메서드
	public HunetException(String msg) {		
		super(msg);		
		
	}	

}
