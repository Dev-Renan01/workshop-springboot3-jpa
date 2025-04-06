package com.devRenan01.corse.resouces.excepitions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devRenan01.corse.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExcepitionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardardError> resourceNotFound
	(ResourceNotFoundException e, HttpServletRequest request){
		String Error = "resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardardError err = new StandardardError(Instant.now(), status.value(), Error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
