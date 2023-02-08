/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alamo.api.service;
import com.alamo.api.product.Moto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alamo.api.repository.motoRepository;

/**
 *
 * @author paulaalafil
 */
@Service
public class MotoService {
    @Autowired
    private motoRepository repository;
    
    public List<Moto>listMotos(){
        return repository.findAll();
    }
    
    public void saveMoto(Moto moto){
    repository.save(moto);
        
    }
    
    public Moto obtainMotoById(Integer id){
        return repository.findById(id).get();
    }
    
    public void deleteMoto(Integer id){
    
        repository.deleteById(id);
    }
    
    
    
}
