package org.jfcmc.spring.ssh.chap08.ex05;

public class Product {
    private String name;
    private double price;

    // public Product(String name, double price) {
    //     this.name = name;
    //     this.price = price;
    // }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
