/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.alamo.api.repository;

import com.alamo.api.product.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author paulaalafil
 */
public interface motoRepository extends JpaRepository<Moto,Integer>{
    
}
