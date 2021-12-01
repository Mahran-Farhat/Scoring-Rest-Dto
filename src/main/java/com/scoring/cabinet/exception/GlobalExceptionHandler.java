package com.scoring.cabinet.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // dans le cas ou l'exception déclenchée est de type ReourceNotFound
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<?> object_not_found(ResourceNotFound ex){
        return
    }
}
