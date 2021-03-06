package com.jpa.main;

import com.jpa.impl.ProductDAOImple;
import com.jpa.inter.ProductDAOInter;
import com.jpa.model.Brand;
import com.jpa.model.Category;
import com.jpa.model.Product;
import java.util.Date;
import java.util.List;

public class Main {

    private static ProductDAOInter dAOInter = new ProductDAOImple();

    public static void main(String[] args) {

    }

    public static void foo() {
        List<Object[]> list = dAOInter.findProductNameAndPrice();
        for (Object[] objects : list) {
            System.out.println(objects[0] + "  " + objects[1]);

        }

        List<Object[]> list2 = dAOInter.findFunctiosPrice();
        for (Object[] objects : list2) {
            System.out.println(objects[0] + " " + objects[1] + " " + objects[2] + " " + objects[3] + " " + objects[4] + " ");

        }

    }

    public static void inserDate() {
        Brand brand1 = new Brand("APPLE");
        Brand brand2 = new Brand("LG");
        Brand brand3 = new Brand("SONY");
        Brand brand4 = new Brand("SAMSUNG");
        Brand brand5 = new Brand("ASUS");

        Category category1 = new Category("PC");
        Category category2 = new Category("TBLET");
        Category category3 = new Category("PHONE");

        Product product1 = new Product("Iphone 7", 3500, 2, brand1, category3, new Date());
        Product product2 = new Product("LG G3", 2500, 1, brand2, category3, new Date());
        Product product3 = new Product("SONY EXPEI", 2700, 1, brand3, category3, new Date());

        Product product4 = new Product("Mc i5", 1700, 1, brand1, category1, new Date());
        Product product5 = new Product("ASSUS i7", 4100, 1, brand5, category1, new Date());
        Product product6 = new Product("Samsung Z500", 3100, 2, brand4, category1, new Date());

        dAOInter.saveBrand(brand1);
        dAOInter.saveBrand(brand2);
        dAOInter.saveBrand(brand3);
        dAOInter.saveBrand(brand4);
        dAOInter.saveBrand(brand5);

        dAOInter.saveCategory(category1);
        dAOInter.saveCategory(category2);
        dAOInter.saveCategory(category3);

        dAOInter.saveProduct(product1);
        dAOInter.saveProduct(product2);
        dAOInter.saveProduct(product3);
        dAOInter.saveProduct(product4);
        dAOInter.saveProduct(product5);
        dAOInter.saveProduct(product6);

    }

}
