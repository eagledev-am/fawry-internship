package com.fawry.task.courseregistration.exception;

import lombok.Data;

public class NoSuchEntityException extends RuntimeException{

    public NoSuchEntityException(String message){
        super(message);
    }
}
