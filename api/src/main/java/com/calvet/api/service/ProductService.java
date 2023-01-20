/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.calvet.api.service;

import com.calvet.api.productRepository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.calvet.api.product.Products;


/**
 *
 * @author martacalgua
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    
    public List<Products>listProducts(){
        return repository.findAll();
    }
    
    public void saveProduct(Products product){
        repository.save(product);
    }
    
    public Products obtainProductById(Integer id){
        return repository.findById(id).get();
    }
    
    public void deleteProduct (Integer id){
        repository.deleteById(id);
    }
}
