/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aze.com.jdbc.inter;

import aze.com.jdbc.model.Product;
import java.util.List;

/**
 *
 * @author Kanan
 */
public interface ProductDaoInter {

    public boolean addProduct(Product p);

    public boolean updateProduct(Product p);

    public boolean deltateProduct(int productId);

    public Product getProductById(int productId);

    public List<Product> getAllProduct();

}
