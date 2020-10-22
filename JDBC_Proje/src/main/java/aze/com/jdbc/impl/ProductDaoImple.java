package aze.com.jdbc.impl;

import aze.com.jdbc.connection.DBConnection;
import aze.com.jdbc.inter.ProductDaoInter;
import aze.com.jdbc.model.Brand;
import aze.com.jdbc.model.Category;
import aze.com.jdbc.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProductDaoImple extends DBConnection implements ProductDaoInter {

    @Override
    public boolean addProduct(Product p) {
        try {
            Connection con = connect();
            String sql1 = "INSERT INTO product ( productId, productName, unitPrace, available, addDate, updateDate, categoryId, brandId )\n"
                    + "VALUES\n"
                    + "	(?,?,?,?,?,?,?,?);";

            Calendar calendar = Calendar.getInstance();
            Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

            PreparedStatement pstmt = con.prepareStatement(sql1);
            pstmt.setInt(1, p.getProductId());
            pstmt.setString(2, p.getProductName());
            pstmt.setDouble(3, p.getUintPrace());
            pstmt.setInt(4, p.getAvailabel());
            pstmt.setTimestamp(5, timestamp);
            pstmt.setTimestamp(6, null);
            pstmt.setInt(7, p.getCategory().getCategoryId());
            pstmt.setInt(8, p.getBrand().getBrandId());
            pstmt.execute();
            con.close();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product p) {
        try {
            Connection con = connect();
            String sql2 = "UPDATE product p \n"
                    + "SET p.productName =?,\n"
                    + "p.unitPrace =?,\n"
                    + "p.available=?,\n"
                    + "p.addDate =?,\n"
                    + "p.updateDate =?,\n"
                    + "p.categoryId =?,\n"
                    + "p.brandId =? \n"
                    + "WHERE\n"
                    + "	p.productId =?;";
            Calendar calendar = Calendar.getInstance();
            Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

            PreparedStatement pstmt = con.prepareStatement(sql2);
            pstmt.setString(1, p.getProductName());
            pstmt.setDouble(2, p.getUintPrace());
            pstmt.setInt(3, p.getAvailabel());
            pstmt.setTimestamp(4, p.getAddDate());
            pstmt.setTimestamp(5, timestamp);
            pstmt.setInt(6, p.getCategory().getCategoryId());
            pstmt.setInt(7, p.getBrand().getBrandId());
            pstmt.setInt(8, p.getProductId());

            pstmt.execute();
            con.close();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deltateProduct(int productId) {

        try {
            Connection con = connect();
            String sql3 = "DELETE FROM user_product  WHERE productId=?;";
            PreparedStatement pstmt = con.prepareStatement(sql3);
            pstmt.setInt(1, productId);
            pstmt.execute();

            String sql33 = "DELETE FROM product WHERE productId=?;";
            PreparedStatement pstmt2 = con.prepareStatement(sql33);
            pstmt2.setInt(1, productId);
            pstmt2.execute();

            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Product getProductById(int productId) {

        try {
            Connection con = connect();
            String sql3 = "SELECT\n"
                    + "p.productId,\n"
                    + "p.productName,\n"
                    + "p.unitPrace,\n"
                    + "p.available,\n"
                    + "p.addDate,\n"
                    + "p.updateDate,\n"
                    + "c.*,\n"
                    + "b.*\n"
                    + "	\n"
                    + "FROM\n"
                    + "	product p\n"
                    + "	LEFT JOIN category c ON p.categoryId = c.categoryId\n"
                    + "	LEFT JOIN brand b on p.brandId=b.brandId WHERE p.productId=?;";
            PreparedStatement pstmt = con.prepareStatement(sql3);
            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();
            Product product = null;
            while (rs.next()) {
                Category category = new Category(rs.getInt(7), rs.getString(8));
                Brand brand = new Brand(rs.getInt(9), rs.getString(10));
                product = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getTimestamp(5), rs.getTimestamp(6), brand, category);

            }
            con.close();
            return product;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> getAllProduct() {
        try {
            Connection con = connect();
            String sql3 = "SELECT\n"
                    + "p.productId,\n"
                    + "p.productName,\n"
                    + "p.unitPrace,\n"
                    + "p.available,\n"
                    + "p.addDate,\n"
                    + "p.updateDate,\n"
                    + "c.*,\n"
                    + "b.*\n"
                    + "	\n"
                    + "FROM\n"
                    + "	product p\n"
                    + "	LEFT JOIN category c ON p.categoryId = c.categoryId\n"
                    + "	LEFT JOIN brand b on p.brandId=b.brandId ;";
            PreparedStatement pstmt = con.prepareStatement(sql3);
            ResultSet rs = pstmt.executeQuery();
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                Category category = new Category(rs.getInt(7), rs.getString(8));
                Brand brand = new Brand(rs.getInt(9), rs.getString(10));
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getTimestamp(5), rs.getTimestamp(6), brand, category);
                list.add(product);
            }
            con.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

}
