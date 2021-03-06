package com.jpa.model;

public class ProductDetails {

    private String productName;
    private double unitPrace;
    private int availabel;
    private String brandName;
    private String categoryName;

    public ProductDetails() {
    }

    public ProductDetails(String productName, double unitPrace, int availabel, String brandName, String categoryName) {
        this.productName = productName;
        this.unitPrace = unitPrace;
        this.availabel = availabel;
        this.brandName = brandName;
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrace() {
        return unitPrace;
    }

    public void setUnitPrace(double unitPrace) {
        this.unitPrace = unitPrace;
    }

    public int getAvailabel() {
        return availabel;
    }

    public void setAvailabel(int availabel) {
        this.availabel = availabel;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ProductDetails{" + "productName=" + productName + ", unitPrace=" + unitPrace + ", availabel=" + availabel + ", brandName=" + brandName + ", categoryName=" + categoryName + '}';
    }

}
