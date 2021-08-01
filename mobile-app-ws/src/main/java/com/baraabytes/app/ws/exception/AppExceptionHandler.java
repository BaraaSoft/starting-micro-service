package com.baraabytes.app.ws.exception;

import com.baraabytes.app.ws.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity handleAnyExceptions(Exception ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(ex.getLocalizedMessage());
        return new ResponseEntity(errorResponse,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity handleUserServiceException(UserServiceException ex,WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(ex.getLocalizedMessage());
        return  new ResponseEntity(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
