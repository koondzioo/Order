package com.app.exception;

import com.app.model.Product;

import java.time.LocalDateTime;

public class ProductException extends Throwable {

    private String name;
    private LocalDateTime dateTime;

    public ProductException(String name, LocalDateTime dateTime)
    {
        this.name = name;
        this.dateTime = dateTime;
    }

    @Override
    public String getMessage() {
        return "Validation product, " + name + " " + dateTime;
    }
}
