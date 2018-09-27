package com.app.model;

import com.app.exception.ProductException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product {
    private String name;
    private BigDecimal price;
    private Category category;

    public Product(ProductBuilder productBuilder)
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static class ProductBuilder{

        private String name;
        private BigDecimal price;
        private Category category;

        public ProductBuilder category(Category category) throws ProductException {
            if(category == null)
            {
                throw new ProductException("category null", LocalDateTime.now());
            }
            this.category = category;
            return this;
        }

        public ProductBuilder name(String name) throws ProductException {
            if(!checkField(name, "[A-Z]+"))
            {
                throw new ProductException("name", LocalDateTime.now());
            }
            this.name = name;
            return this;
        }

        public ProductBuilder price(BigDecimal price) throws ProductException {
            if(price.compareTo(BigDecimal.ZERO) > 0)
            {
                throw new ProductException("price " + price, LocalDateTime.now());
            }
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    private static boolean checkField(String str, String regex)
    {
        return str.matches(regex);
    }


}
