package org.jfcmc.spring.ssh.chap08.ex05;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class ProductService {
    private List<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> findAll() {
        return products;
    }
}
