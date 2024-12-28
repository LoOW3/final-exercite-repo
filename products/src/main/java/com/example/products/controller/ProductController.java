package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    IProductService pS;

    @Value("${server.port}")
    private int portService;
    @GetMapping("/list")
    public List<Product> listAllProducts(){
        System.out.println("Llamada en el puerto ------- " + portService);
        return pS.listProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return pS.getProduct(id);
    }

}
