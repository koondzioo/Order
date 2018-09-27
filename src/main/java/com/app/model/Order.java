package com.app.model;

import com.app.exception.CustomerException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {

    private Customer customer;
    private Product product;
    private int quantity;
    private LocalDate orderDate;

    public Order(OrderBuilder orderBuilder) {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public static Order.OrderBuilder builder() {
        return new Order.OrderBuilder();
    }

    private static class OrderBuilder {

        private Customer customer;
        private Product product;
        private int quantity;
        private LocalDate orderDate;

        public OrderBuilder customer(Customer customer) throws CustomerException {
            if(customer == null)
            {
                throw new CustomerException("Customer null", LocalDateTime.now());
            }
            this.customer = customer;
            return this;
        }

        public OrderBuilder orderDate(LocalDate orderDate) throws CustomerException {

            if(orderDate.isBefore(LocalDate.now()))
            {
                throw new CustomerException("order date " + orderDate, LocalDateTime.now());
            }
            this.orderDate = orderDate;
            return this;
        }

        public OrderBuilder product(Product product) throws CustomerException {
            if(product == null)
            {
                throw new CustomerException("Product null", LocalDateTime.now());
            }
            this.product = product;
            return this;
        }

        public OrderBuilder quantity(int quantity) throws CustomerException {
            if(quantity < 0)
            {
                throw new CustomerException("quantity " + quantity, LocalDateTime.now());
            }
            this.quantity = quantity;
            return this;
        }

        public Order build()
        {
            return new Order(this);
        }
    }


}
