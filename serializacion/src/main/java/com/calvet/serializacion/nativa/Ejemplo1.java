package com.calvet.serializacion.nativa;

import com.calvet.serializacion.modelo.Product;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author martacalgua
 */
public class Ejemplo1 {
    public static void main (String[] args){
        Product prod = new Product(1, "iPhone X", 300.75);
        System.out.println(prod.toString());
        System.out.println("Vamos a serializar el producto anterior");
        serializar(prod);
    }
    
    static void serializar(Product p){
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(".\\product.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            System.out.println("El producto ha sido serializado en Product.ser");
            out.writeObject(p);
            System.out.println(deserializar().toString());
            System.out.println("El producto ha sido deserializado");

        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra la ruta del fichero" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Ha surgido un error serializando" + ex.getMessage());
        } finally {
            try {
                fileOut.close();
            } catch (IOException ex) {
                Logger.getLogger(Ejemplo1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    static Product deserializar(){
        Product prod = null;
        try{
            FileInputStream fileIn = new FileInputStream(".\\product.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            prod = (Product) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c){
            System.out.println("Product class not found");
            c.printStackTrace();
        }
        
        return prod;
        
    }
}
