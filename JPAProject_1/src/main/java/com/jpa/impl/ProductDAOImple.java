/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.impl;

import com.jpa.inter.ProductDAOInter;
import com.jpa.jpaFactory.AbstractDAO;
import com.jpa.model.Brand;
import com.jpa.model.Category;
import com.jpa.model.Product;
import com.jpa.model.ProductDetails;
import com.jpa.queries.ProductQueries;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Kanan
 */
public class ProductDAOImple extends AbstractDAO implements ProductDAOInter {

    public void namedQueries() {
        TypedQuery<Product> typedQuery = em().createNamedQuery("Product.X", Product.class);
        List<Product> list = typedQuery.getResultList();
        System.out.println(list);
    }

    @Override
    public Product saveProduct(Product product) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        return product;
    }

    @Override
    public Brand saveBrand(Brand brand) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(brand);
        em.getTransaction().commit();
        return brand;
    }

    @Override
    public Category saveCategory(Category category) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
        return category;
    }

    @Override
    public List<Product> findProducts() {
        Query query = em().createQuery(ProductQueries.findProducts);
        return query.getResultList();
    }

    @Override
    public List<Product> findProductsEntities(int min, int max) {
//        TypedQuery typedQuery=em().createQuery(ProductQueries., resultClass)

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product findProducttByID(int productId) {
        TypedQuery<Product> typedQuery = em().createQuery(ProductQueries.findProductById, Product.class);
        typedQuery.setParameter("productId", productId);
        return typedQuery.getSingleResult();
    }

    @Override
    public List<ProductDetails> findProductDetails() {
        TypedQuery<ProductDetails> typedQuery = em().createQuery(ProductQueries.findProducDetails, ProductDetails.class);
        return typedQuery.getResultList();
    }

    @Override
    public ProductDetails findProductDetailsById(int productId) {
        TypedQuery<ProductDetails> typedQuery = em().createQuery(ProductQueries.findProducDetailsById, ProductDetails.class);
        typedQuery.setParameter("productId", productId);
        return typedQuery.getSingleResult();
    }

    @Override
    public List<String> findProductName() {

        TypedQuery<String> typedQuery = em().createQuery(ProductQueries.findProductNames, String.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Object[]> findProductNameAndPrice() {
        Query query = em().createQuery(ProductQueries.findProductNameAndPrice);
        return query.getResultList();
    }

    @Override
    public List<Product> findGreatPrice(double unitPrice) {
        TypedQuery<Product> typedQuery = em().createQuery(ProductQueries.findGreatPrice, Product.class);
        typedQuery.setParameter("unitPrace", unitPrice);
        return typedQuery.getResultList();
    }

    @Override
    public List<Product> findBetweenPrice(double min, double max) {
        TypedQuery<Product> typedQuery = em().createQuery(ProductQueries.findBtweenPrice, Product.class);
        typedQuery.setParameter("min", min);
        typedQuery.setParameter("max", max);
        return typedQuery.getResultList();
    }

    @Override
    public List<Product> findLikeProductName(String name) {
        TypedQuery<Product> typedQuery = em().createQuery(ProductQueries.findLikeProductName, Product.class);
        typedQuery.setParameter("name", "%" + name + "%");
        return typedQuery.getResultList();
    }

    @Override
    public List<Product> findInCategoryName(String name1, String name2) {
        TypedQuery<Product> typedQuery = em().createQuery(ProductQueries.findInCategoryName, Product.class);
        typedQuery.setParameter("name1", name1);
        typedQuery.setParameter("name2", name2);
        return typedQuery.getResultList();

    }

    @Override
    public List<Object[]> findFunctiosPrice() {
        Query query = em().createQuery(ProductQueries.findFunctionsPrice);
        return query.getResultList();

    }

    @Override
    public List<Object[]> findGroupByCategory() {
        Query query = em().createQuery(ProductQueries.findGroupByCategory);
        return query.getResultList();
    }

    @Override
    public List<Product> findOrderByPrice() {
        TypedQuery<Product> typedQuery = em().createQuery(ProductQueries.findOrderByPrice, Product.class);
        return typedQuery.getResultList();

    }

}
