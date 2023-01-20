/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.calvet.api.productRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.calvet.api.product.Products;

/**
 *
 * @author martacalgua
 */
public interface ProductRepository extends JpaRepository<Products, Integer>{
    
}
