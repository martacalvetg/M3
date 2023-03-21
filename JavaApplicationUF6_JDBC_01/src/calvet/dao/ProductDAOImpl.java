/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calvet.dao;

import calvet.model.Product;
import java.sql.*;

/**
 *
 * @author martacalgua
 */
public class ProductDAOImpl implements ProductDAO{

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/products";
    static final String DB_USR = "root";
    static final String DB_PWD = "";

    public void registerDriver() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR: failed to load MYSQL JDBC Driver");
            ex.printStackTrace();
        }
    }

    public void insert(Product product) {
        Connection conn = null;
        try {
            registerDriver();
            conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into product values ("
                    + product.getId() + ",'"
                    + product.getName() + "',"
                    + product.getPrice() + ");");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        }
    }

    public void delete(Product product) {
        Connection conn = null;
        try {
            registerDriver();
            conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("delete from product where id = " + product.getId());

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        }

    }

    public void update(Product product) {
        Connection conn = null;
        try {
            registerDriver();
            conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("update product SET name ='" 
                    + product.getName()+ "', price='" 
                    + product.getPrice()+ "' where id="
                    + product.getId());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        }
        
    }
    public Product read(Integer id) {
        Connection conn = null;
        Product prod = null;

        try {
            registerDriver();

            conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);

            try ( PreparedStatement ps = conn.prepareStatement("Select * from product where id = ?")) {
                ps.setInt(1, id);

                try ( ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        prod = new Product(id, rs.getString("name"), rs.getDouble("price"));
                    }
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return prod;
    }
}