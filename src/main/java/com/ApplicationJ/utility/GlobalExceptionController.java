package com.ApplicationJ.utility;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ApplicationJ.config.Response;

@ControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {

	@Autowired
	SupportUtility supportUtility;
	
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(HttpServletRequest request, Exception e) throws IOException {
    	Response response = supportUtility.responseBuilder(e.getMessage(), null, "exception");
    	e.printStackTrace();
    	SupportUtility.logger.debug("got error "+e.getMessage());
		return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
    
}