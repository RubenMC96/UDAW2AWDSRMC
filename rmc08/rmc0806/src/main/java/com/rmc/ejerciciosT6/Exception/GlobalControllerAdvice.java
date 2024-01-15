package com.rmc.ejerciciosT6.Exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice

public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EmpleadoNotFoundException.class)
    public ResponseEntity<?> handleEmpleadoNotFound(EmpleadoNotFoundException e, WebRequest request){
        ExceptionBody body = new ExceptionBody(LocalDateTime.now(),HttpStatus.NOT_FOUND, e.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI());
        
        return new ResponseEntity<Object>(body,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmptyListEmpleadosException.class)
    public ResponseEntity<?> handleEmptyListEmpleados(EmptyListEmpleadosException e, WebRequest request){
        ExceptionBody body = new ExceptionBody(LocalDateTime.now(),HttpStatus.NOT_FOUND, e.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI());
        
        return new ResponseEntity<Object>(body,HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
    Exception ex, @Nullable Object body, HttpHeaders headers, //(*)
    HttpStatusCode status, WebRequest request) {
    ExcepcionBody myBody =
    new ExcepcionBody(LocalDateTime.now(),
    status, ex.getMessage(),
    ((ServletWebRequest) request).getRequest().getRequestURI());
    return ResponseEntity.status(status).headers(headers).body(myBody);
    }
    
}
