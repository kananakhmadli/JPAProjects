package aze.com.jdbc.main;

import aze.com.jdbc.impl.ProductDaoImple;
import aze.com.jdbc.impl.UserDaoImpl;
import aze.com.jdbc.inter.ProductDaoInter;
import aze.com.jdbc.inter.UserDaoInter;
import aze.com.jdbc.model.Brand;
import aze.com.jdbc.model.Category;
import aze.com.jdbc.model.Product;
import aze.com.jdbc.model.User;
import java.sql.Date;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        ProductDaoInter daoInter = new ProductDaoImple();
//        Brand b=new Brand(3, "Samsung");
//        Category c=new Category(1, "TELFON");
//        Product p=new Product(3, "A3", 2500, 3, b, c);
        Product p=daoInter.getProductById(3);
        System.out.println(p);
        p.setProductName("A3333333");
        System.out.println(daoInter.updateProduct(p));
//        System.out.println(daoInter.addProduct(p));
//        System.out.println(daoInter.deltateProduct(2));
//                System.out.println(daoInter.getAllProduct());
//        System.out.println(daoInter.getProductById(1));
    }

}
/*
        UserDaoInter userDao = new UserDaoImpl();

Calendar calendar =Calendar.getInstance();
        calendar.set(2002, Calendar.MARCH, 1);
        Date date=new Date(calendar.getTimeInMillis());
        User u=new User(12, "Taleh", "Hetemov", date, "sjsj");
        System.out.println(userDao.updateUser(u));
//        System.out.println(userDao.addUser(u));
//        System.out.println(userDao.deletUser(102));
//        System.out.println(userDao.getUserById(100));
//        System.out.println(userDao.getAllUser());



 */
