package com.axiom.mobileshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request) {
        return new ResponseEntity("Exception occurred while processing the request", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidParameterException.class)
    public final ResponseEntity<Object> handleInvalidParameterExceptions(Exception e, WebRequest request) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
