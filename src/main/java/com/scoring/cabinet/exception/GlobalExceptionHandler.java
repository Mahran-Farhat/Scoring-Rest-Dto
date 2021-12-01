package com.scoring.cabinet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // dans le cas ou l'exception déclenchée est de type ReourceNotFound
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<?> object_not_found(ResourceNotFound ex){
        // envoyer un email/sms à un responsable
        return ResponseEntity.ok().body(
                new ResponseMessage(ex.getMessage())
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> internal_error(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ResponseMessage("Internal Server Error")
        );
    }
}
