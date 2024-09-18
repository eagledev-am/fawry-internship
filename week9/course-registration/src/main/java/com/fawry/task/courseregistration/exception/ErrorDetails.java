package com.fawry.task.courseregistration.exception;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorDetails {

    private int code;
    private String message;
    private Date timeStamp;

    private String desc;

    public ErrorDetails(int code, String message, Date timeStamp, String desc) {
        this.code = code;
        this.message = message;
        this.timeStamp = timeStamp;
        this.desc = desc;
    }


}
