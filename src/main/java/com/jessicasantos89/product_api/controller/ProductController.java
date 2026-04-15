package com.jessicasantos89.product_api.controller;

import com.jessicasantos89.product_api.model.Product;
import com.jessicasantos89.product_api.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/produtos")
public class ProductController {

    private final ProductRepository productRepository;

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        productRepository.save(product);
        LOG.info("Salvou product: " + product);
        return product;
    }

    @GetMapping("{id}")
    public  Product findById(@PathVariable("id") String id) {
        return productRepository.findById(id).orElse(null);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") String id,
                       @RequestBody Product product) {
        product.setId(id);
        productRepository.save(product);

        LOG.info("Product Uptade: " + product);
    }

    @GetMapping
    public List<Product> findByName(@RequestParam String name) {
        return  productRepository.findByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id) {
        productRepository.deleteById(id);
    }
}
