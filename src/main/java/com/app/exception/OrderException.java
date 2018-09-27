package com.app.exception;

import java.time.LocalDateTime;

public class OrderException extends MyExceptions {
    private String name;
    private LocalDateTime dateTime;

    public OrderException(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    @Override
    public String getMessage() {
        return "Validation order, " + name + " " + dateTime;
    }
}
