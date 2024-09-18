package com.fawry.task.courseregistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandeling {


    @ExceptionHandler(NoSuchEntityException.class)
    public ResponseEntity<?> noSuchEntityException(String message , WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                HttpStatus.NOT_FOUND.value() ,
                message ,
                new Date() ,
                webRequest.getDescription(false)
        );
        return new ResponseEntity<>(errorDetails , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalException(String message , WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                HttpStatus.INTERNAL_SERVER_ERROR.value() ,
                message ,
                new Date() ,
                webRequest.getDescription(false)
        );
        return new ResponseEntity<>(errorDetails , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
