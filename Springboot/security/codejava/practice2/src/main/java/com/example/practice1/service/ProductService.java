package com.example.practice1.service;

import com.example.practice1.model.Product;
import com.example.practice1.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    public List<Product> listAll(){
        return productRepo.findAll();
    }

    public void save(Product product){
        productRepo.save(product);
    }

    public Product get(Long id) {
        return productRepo.findById(id).get();
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }
}
