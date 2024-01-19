package com.rmc.app.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestController
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(CategoriaNotFoundException.class)
    public ResponseEntity<?> handleCategoriaNotFound(CategoriaNotFoundException c, WebRequest request){
        ExceptionBody body = new ExceptionBody(LocalDateTime.now(), HttpStatus.NOT_FOUND, c.getMessage(), ((ServletWebRequest)request).getRequest().getRequestURI());
        return new ResponseEntity<Object>(body,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<?> handleProductoNotFound(ProductoNotFoundException p, WebRequest request){
        ExceptionBody body = new ExceptionBody(LocalDateTime.now(), HttpStatus.NOT_FOUND, p.getMessage(), ((ServletWebRequest)request).getRequest().getRequestURI());
        return new ResponseEntity<Object>(body,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<?> handleUsuarioNotFound(UsuarioNotFoundException u, WebRequest request){
        ExceptionBody body = new ExceptionBody(LocalDateTime.now(), HttpStatus.NOT_FOUND, u.getMessage(), ((ServletWebRequest)request).getRequest().getRequestURI());
        return new ResponseEntity<Object>(body,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<?> handleValoracionNotFound(ValoracionNotFoundException v, WebRequest request){
        ExceptionBody body = new ExceptionBody(LocalDateTime.now(), HttpStatus.NOT_FOUND, v.getMessage(), ((ServletWebRequest)request).getRequest().getRequestURI());
        return new ResponseEntity<Object>(body,HttpStatus.NOT_FOUND);
    }
    
}
