package com.app;

import com.app.exception.CustomerException;
import com.app.model.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws CustomerException {

        Customer customer = Customer.builder().name("zxc").build();


    }
}
