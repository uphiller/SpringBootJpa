package com.example.demo.common.handler;

import com.example.demo.common.exception.ErrorCodes;
import com.example.demo.common.exception.HunetException;
import com.example.demo.common.exception.HunetExceptionVO;
import com.example.demo.common.exception.HunetNotFoundException;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


@ControllerAdvice("com.example.demo")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

	private final Logger log = LoggerFactory.getLogger(getClass());

    @SuppressWarnings("unchecked")
	@ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseEntity<HunetExceptionVO> bindException(BindException exception, Locale locale,
														  HttpServletResponse response, HttpServletRequest request) throws Exception {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        
        JSONObject jsonObj = new JSONObject();
		List<FieldError> list1 = exception.getFieldErrors();
		
		for (FieldError e : list1) {
			List<Object> list = new ArrayList<>();
			//다국어를 위한 메시지 처리			
			list.add(e.getDefaultMessage());
			list.add(e.getRejectedValue());            	
        	jsonObj.put(e.getField(), list);
        }		
		HunetExceptionVO heVO = new HunetExceptionVO();
		heVO.setTimestamp(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).getTime());
		heVO.setStatus(400);
		heVO.setMessage(jsonObj.toString());
		heVO.setPath(request.getRequestURI());
		heVO.setException(BindException.class.getName());
		heVO.setError("Validation Error");
	
        return new ResponseEntity<HunetExceptionVO>(heVO, HttpStatus.BAD_REQUEST);
    }
    
    
    @ExceptionHandler(HunetException.class)
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<HunetExceptionVO> hunetException(HunetException exception, Locale locale,
														   HttpServletResponse response, HttpServletRequest request) {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        
		HunetExceptionVO heVO = new HunetExceptionVO();
		heVO.setTimestamp(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).getTime());
		heVO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		heVO.setMessage(exception.getMessage());
		heVO.setPath(request.getRequestURI());
		heVO.setException(HunetException.class.getName());
		heVO.setError("Internal Server Error");
		log.info(heVO.toString());		
		
        return new ResponseEntity<HunetExceptionVO>(heVO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<HunetExceptionVO> Exception(Exception exception, Locale locale,
                                                      HttpServletResponse response, HttpServletRequest request) {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        
		HunetExceptionVO heVO = new HunetExceptionVO();
		heVO.setTimestamp(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).getTime());
		heVO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		heVO.setMessage(exception.getMessage());
		heVO.setPath(request.getRequestURI());
		heVO.setException(Exception.class.getName());
		heVO.setError("Internal Server Error");		
		exception.printStackTrace();
        return new ResponseEntity<HunetExceptionVO>(heVO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(HunetNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<HunetExceptionVO> hunetNotFoundException(HunetNotFoundException exception, Locale locale,
																   HttpServletResponse response, HttpServletRequest request) {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        
		HunetExceptionVO heVO = new HunetExceptionVO();
		heVO.setTimestamp(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).getTime());
		heVO.setStatus(HttpStatus.NOT_FOUND.value());
		
		heVO.setMessage(exception.getMessage());
		heVO.setPath(request.getRequestURI());
		heVO.setException(HunetNotFoundException.class.getName());
		heVO.setError(ErrorCodes.ERROR_NOTFOUND_INFO.getMsg());
		log.info(heVO.toString());		
		
        return new ResponseEntity<HunetExceptionVO>(heVO, HttpStatus.NOT_FOUND);
    }

}
