package org.jfcmc.spring.ssh.chap08.ex05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import java.util.List;
import java.util.ArrayList;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // @RequestMapping("/products")
    @GetMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }

    // @RequestMapping(path = "/products",
    //                 method = RequestMethod.POST)
    @PostMapping("/products")
    public String addProduct(@RequestParam String name,
                             @RequestParam double price,
                             Model model) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productService.addProduct(product);

        var products = productService.findAll();

        model.addAttribute("products", products);

        return "products.html";
    }
}
