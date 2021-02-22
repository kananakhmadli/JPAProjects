package com.jpa.inter;

import com.jpa.model.Brand;
import com.jpa.model.Category;
import com.jpa.model.Product;
import com.jpa.model.ProductDetails;
import java.util.List;

public interface ProductDAOInter {

    Product saveProduct(Product product);

    Brand saveBrand(Brand brand);

    Category saveCategory(Category category);

    List<Product> findProducts();

    List<Product> findProductsEntities(int min, int max);

    Product findProducttByID(int productId);

    List<ProductDetails> findProductDetails();

    ProductDetails findProductDetailsById(int productId);

    List<String> findProductName();

    List<Object[]> findProductNameAndPrice();

    List<Product> findGreatPrice(double unitPrice);

    List<Product> findBetweenPrice(double min, double max);

    List<Product> findLikeProductName(String name);

    List<Product> findInCategoryName(String name1, String name2);

    List<Object[]> findFunctiosPrice();

    List<Object[]> findGroupByCategory();

    List<Product> findOrderByPrice();
}
