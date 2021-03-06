package com.jpa.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

@NamedQueries({
    @NamedQuery(name = "Product.X", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findProductById", query = "SELECT p FROM Product p WHERE p.productId=:productId"),
    @NamedQuery(name = "Product.findAddDateLate", query = "SELECT p FROM Product p WHERE p.addDate > :addDate"),})
public class Product implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String name;
    private double unitPrace;
    private int available;

    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public Product() {
    }

    public Product(String name, double unitPrace, int available, Brand brend, Category catgory, Date addDate) {
        this.name = name;
        this.unitPrace = unitPrace;
        this.available = available;
        this.brand = brend;
        this.category = catgory;
        this.addDate = addDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrace() {
        return unitPrace;
    }

    public void setUnitPrace(double unitPrace) {
        this.unitPrace = unitPrace;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
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

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", name=" + name + ", unitPrace=" + unitPrace + ", available=" + available + ", brend=" + brand + ", catgory=" + category + ", addDate=" + addDate + ", updateDate=" + updateDate + '}';
    }

}
