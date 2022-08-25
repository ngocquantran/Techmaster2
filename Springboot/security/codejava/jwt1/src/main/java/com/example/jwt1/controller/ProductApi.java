package com.example.jwt1.controller;

import com.example.jwt1.model.Product;
import com.example.jwt1.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductApi {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping
    @RolesAllowed({"ROLE_CUSTOMER","ROLE_EDITOR"})
    public List<Product> getList(){
        return productRepo.findAll();
    }

    @PostMapping
    @RolesAllowed("ROLE_EDITOR")
    public ResponseEntity<Product> create(@RequestBody @Valid Product product){
        Product savedProduct=productRepo.save(product);
        URI productURI=URI.create("/products/"+savedProduct.getId());
        return ResponseEntity.created(productURI).body(savedProduct);
    }
}
