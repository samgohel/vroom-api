package com.carportal.exceptions;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CutomExceptionHandler extends ResponseEntityExceptionHandler {

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request";
		return buildResponseEntity(new ApiError(BAD_REQUEST, error, ex));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleEntityNotFound(Exception ex, WebRequest req) {
		ApiError apiError = new ApiError(NOT_FOUND);
		apiError.setMessage(ex.getMessage());
		apiError.setDebugMessage(req.getDescription(false));

		return new ResponseEntity<>(apiError, NOT_FOUND);
	}

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ApiError> handleServiceException(ServiceException ex, WebRequest req) {
		ApiError apiError = new ApiError(INTERNAL_SERVER_ERROR);
		apiError.setMessage(ex.getMessage());
		apiError.setMessage(ex.getMessage());
		apiError.setDebugMessage(req.getDescription(false));
		return new ResponseEntity<>(apiError, INTERNAL_SERVER_ERROR);
	}

}
