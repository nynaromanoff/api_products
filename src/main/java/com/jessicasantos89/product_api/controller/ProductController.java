package com.jessicasantos89.product_api.controller;

import com.jessicasantos89.product_api.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/produtos")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @PostMapping
    public Product save(@RequestBody Product product) {
        LOG.info("Salvou product: " + product);
        return product;
    }
}
