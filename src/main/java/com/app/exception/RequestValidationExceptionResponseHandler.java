package com.app.exception;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.dto.ErrorResponseEntity;

@ControllerAdvice
public class RequestValidationExceptionResponseHandler extends ResponseEntityExceptionHandler {

	private static final Logger log = Logger.getLogger(RequestValidationExceptionResponseHandler.class);

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			errors.add(error.getObjectName() + " " + error.getDefaultMessage());
		}
		ErrorResponseEntity errorResponseEntity = new ErrorResponseEntity();
		errorResponseEntity.setDescription("Bad Request");
		errorResponseEntity.setStatus("400");
		errorResponseEntity.setErrors(errors);
		return new ResponseEntity(errorResponseEntity, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = RecordNotFoundException.class)
	public ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException exception) {
		log.info("Exception ->     {}  ", exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleDatabaseOperationFailedException(Exception exception) {
		log.info("Exception ->     {}  ", exception);
		
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
