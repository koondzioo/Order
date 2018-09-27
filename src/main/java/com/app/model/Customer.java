package com.app.model;

import com.app.exception.CustomerException;

import java.time.LocalDateTime;

public class Customer {

    private String name;
    private String surname;
    private int age;
    private String email;


    public Customer(CustomerBuilder customerBuilder) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Customer.CustomerBuilder builder() {
        return new Customer.CustomerBuilder();
    }

    public static class CustomerBuilder{

        private String name;
        private String surname;
        private int age;
        private String email;

        public CustomerBuilder age(int age) throws CustomerException {
            if(age < 18)
            {
                throw new CustomerException("age", LocalDateTime.now());
            }
            this.age = age;
            return this;
        }

        public CustomerBuilder email(String email) throws CustomerException {
            if(!checkField(email, "^(.+)@(.+)$"))
            {
                throw new CustomerException(name, LocalDateTime.now());
            }
            this.email = email;
            return this;
        }

        public CustomerBuilder surname(String surname) throws CustomerException {
            if(!checkField(surname, "[A-Z]+"))
            {
                throw new CustomerException(name, LocalDateTime.now());
            }
            this.surname = surname;
            return this;
        }

        public CustomerBuilder name(String name) throws CustomerException {
            if(!checkField(name, "[A-Z]+"))
            {
                throw new CustomerException(name, LocalDateTime.now());
            }
            this.surname = surname;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    private static boolean checkField(String str, String regex)
    {
        return str.matches(regex);
    }




}
