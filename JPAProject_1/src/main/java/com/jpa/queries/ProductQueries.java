package com.jpa.queries;

public class ProductQueries {

    public static final String findProducts = "SELECT p FROM Product p";
    public static final String findProductById = "SELECT p FROM Product p where p.productId=:productId";
    public static final String findProducDetails = "SELECT new com.jpa.model.ProductDetails( p.name,p.unitPrace,p.available,b.name,c.name)"
            + " FROM Product p LEFT JOIN p.brand b LEFT JOIN p.category c";
    public static final String findProducDetailsById = "SELECT new com.jpa.model.ProductDetails( p.name,p.unitPrace,p.available,b.name,c.name)"
            + " FROM Product p LEFT JOIN p.brand b LEFT JOIN p.category c WHERE p.productId=:productId";
    public static final String findProductNames = "SELECT p.name FROM Product p";
    public static final String findProductNameAndPrice = "SELECT p.name,p.unitPrace FROM Product p";
    public static final String findGreatPrice = "SELECT p FROM Product p WHERE p.unitPrace >:unitPrace";
    public static final String findBtweenPrice = "SELECT p FROM Product p WHERE p.unitPrace BETWEEN :min AND :max";
    public static final String findLikeProductName = "SELECT p FROM Product p WHERE p.name like :name";//???????
    public static final String findInCategoryName = "SELECT p FROM Product p LEFT JOIN p.category c WHERE c.name in (:name1,:name2)";
    public static final String findFunctionsPrice = "SELECT AVG(p.unitPrace),SUM(p.unitPrace),MAX(p.unitPrace),MIN(p.unitPrace),COUNT(p.productId)FROM Product p";
    public static final String findGroupByCategory = "SELECT p.category.name,AVG(p.unitPrace) FROM Product p GROUP BY p.category.name";
    public static final String findGroupByCategoryHaving = "";//????
    public static final String findOrderByPrice = "SELECT p FROM Product p ORDER BY p.unitPrace DESC";

}
