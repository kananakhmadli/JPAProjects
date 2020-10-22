/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aze.com.jdbc.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Kanan
 */
public class Product {

    private int productId;
    private String productName;
    private double uintPrace;
    private int availabel;//available
    private Timestamp addDate;
    private Timestamp upateDate;
    private Brand brand;
    private Category category;

    public Product() {
    }

    public Product(int productId, String productName, double uintPrace, int availabel, Timestamp addDate, Timestamp upateDate, Brand brand, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.uintPrace = uintPrace;
        this.availabel = availabel;
        this.addDate = addDate;
        this.upateDate = upateDate;
        this.brand = brand;
        this.category = category;
    }

    public Product(int productId, String productName, double uintPrace, int availabel, Brand brand, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.uintPrace = uintPrace;
        this.availabel = availabel;
        this.brand = brand;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUintPrace() {
        return uintPrace;
    }

    public void setUintPrace(double uintPrace) {
        this.uintPrace = uintPrace;
    }

    public int getAvailabel() {
        return availabel;
    }

    public void setAvailabel(int availabel) {
        this.availabel = availabel;
    }

    public Timestamp getAddDate() {
        return addDate;
    }

    public void setAddDate(Timestamp addDate) {
        this.addDate = addDate;
    }

    public Timestamp getUpateDate() {
        return upateDate;
    }

    public void setUpateDate(Timestamp upateDate) {
        this.upateDate = upateDate;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", uintPrace=" + uintPrace + ", availabel=" + availabel + ", addDate=" + addDate + ", upateDate=" + upateDate + ", brand=" + brand + ", category=" + category + '}';
    }

}
