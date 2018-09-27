package com.app.exception;

import java.time.LocalDateTime;

public class CustomerException extends Throwable {

    private String name;
    private LocalDateTime dateTime;

    public CustomerException(String name, LocalDateTime dateTime)
    {
        this.dateTime = dateTime;
        this.name = name;
    }

    @Override
    public String getMessage() {
        return "Validation customer, " + name + " " + dateTime;
    }
}
