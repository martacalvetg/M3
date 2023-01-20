/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.calvet.api.controller;

import com.calvet.api.product.Products;
import com.calvet.api.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author martacalgua
 */
@RestController
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService productService;
    
    @GetMapping("/product")
    public List<Products> listProducts(){
        return productService.listProducts();
    }
    
    @GetMapping("/product/{id}")
    public ResponseEntity<Products> obtainProduct (@PathVariable Integer Id){
        try{
            Products product = productService.obtainProductById(Id);
            return ResponseEntity.ok(product);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @PostMapping("/product")
    public void newProudct (@RequestBody Products product){
        productService.saveProduct(product);
    }
    
    @PutMapping("/product/{id}")
    public ResponseEntity<?> editProduct(@RequestBody Products product, @PathVariable Integer id){
        try{
            Products existentProduct = productService.obtainProductById(id);
            existentProduct.setName(product.getName());
            existentProduct.setPrice(product.getPrice());
            productService.saveProduct(existentProduct);
            return new ResponseEntity<Products>(product, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Products>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/product/(id)")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }
    
    
    
}
