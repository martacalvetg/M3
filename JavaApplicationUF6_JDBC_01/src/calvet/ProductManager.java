/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calvet;

import calvet.dao.ProductDAO;
import calvet.dao.ProductDAOImpl;
import calvet.model.Product;

/**
 *
 * @author martacalgua
 */
public class ProductManager {
    public static void main(String[] args) {
        ProductDAO product = new ProductDAOImpl();        
        //product.insert(new Product(300, "cabeza", 10.0));         
        product.update(new Product(200, "cabeza al horno", 25.0));  
        
        //product.delete(new Product(200, "Pollo", 10.0));

        
        Product p= product.read(200);
        System.out.println(p);
    }
}
