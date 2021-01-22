package br.com.CRUDrestful.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UsuarioNotFoundAdvice {
	
	
		@ResponseBody
		@ExceptionHandler(UsuarioNotFoundException.class)
		@ResponseStatus(HttpStatus.NOT_FOUND)
		String UsuarioNotFoundAdvice(UsuarioNotFoundException ex) {
			return ex.getMessage();
	}
	
	
	
}
