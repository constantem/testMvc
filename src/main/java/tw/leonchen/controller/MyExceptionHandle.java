package tw.leonchen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandle {
	
	@ExceptionHandler(Exception.class)
    public Object exceptHandle(Exception e) {
    	String msg1 = "error:Exception";
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg1);
    }
	
}
