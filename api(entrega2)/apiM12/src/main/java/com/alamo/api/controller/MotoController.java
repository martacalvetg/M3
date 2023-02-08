/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alamo.api.controller;

import com.alamo.api.product.Moto;
import com.alamo.api.service.MotoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;



/**
 *
 * @author paulaalafil
 */

@RestController
@RequiredArgsConstructor

public class MotoController {
    
    private final MotoService motoService;
    
   @GetMapping("/motos")
    public List<Moto> listMotos(){
        return motoService.listMotos();
    }

    
    
    @GetMapping("/motos/{id}")
    public ResponseEntity<Moto> obtainMotos (@PathVariable Integer id){
    
    try{
        Moto moto = motoService.obtainMotoById(id);
        return ResponseEntity.ok(moto);
        
        
    }catch(Exception e){
        return ResponseEntity.notFound().build();
    }
}

    
 @PostMapping("/motos")
    public void newMoto (@RequestBody Moto moto){
        motoService.saveMoto(moto);
    }
    
    
 @PutMapping("/motos/{id}")
 public ResponseEntity<?> editarMoto(@RequestBody Moto moto, @PathVariable Integer id) {
    try{
         Moto existentMoto = motoService.obtainMotoById(id);
         existentMoto.setModelo(moto.getModelo());
         existentMoto.setPrecio(moto.getPrecio());
         motoService.saveMoto(existentMoto);
         return new ResponseEntity<Moto>(HttpStatus.OK);
    }catch (Exception e){
        return new ResponseEntity<Moto>(HttpStatus.NOT_FOUND);
        
        }
    
 }
    
    
    
    
    
    @DeleteMapping("/motos/{id}")
    public void deleteMoto(@PathVariable Integer id){
        motoService.deleteMoto(id);
    }
    
}
