/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alamo.api.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author paulaalafil
 */

@Entity
@Table(name = "Motos")
@Data @NoArgsConstructor @AllArgsConstructor

public class Moto {
    @Id @GeneratedValue
    private Integer id;
    private String modelo;
    private float precio;
    private String img_url;
    private String categoria;

    
}
