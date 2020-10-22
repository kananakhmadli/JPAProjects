/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aze.com.jdbc.impl;

import aze.com.jdbc.connection.DBConnection;
import aze.com.jdbc.inter.UserDaoInter;
import aze.com.jdbc.model.Brand;
import aze.com.jdbc.model.Category;
import aze.com.jdbc.model.Product;
import aze.com.jdbc.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kanan
 */
public class UserDaoImpl extends DBConnection implements UserDaoInter {

    @Override
    public boolean addUser(User u) {

        try {
            Connection con = connect();
            String sql1 = "insert into user (userId,firstName,lastName,birthOfDate ,username) values (?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql1);
            pstmt.setInt(1, u.getUserId());
            pstmt.setString(2, u.getFirstName());
            pstmt.setString(3, u.getLastName());
            pstmt.setDate(4, u.getBirthOfDate());
            pstmt.setString(5, u.getUsername());
            pstmt.execute();
            con.close();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User u) {
        try {
            Connection con = connect();
            String sql2 = "update user set firstName=?,lastName=?,birthOfDate=?,username=? where userId=?";
            PreparedStatement pstmt = con.prepareStatement(sql2);
            pstmt.setString(1, u.getFirstName());
            pstmt.setString(2, u.getLastName());
            pstmt.setDate(3, u.getBirthOfDate());
            pstmt.setString(4, u.getUsername());
            pstmt.setInt(5, u.getUserId());
            pstmt.execute();
            con.close();

            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean deletUser(int id) {
        try {
            Connection con = connect();
            String sql3 = "delete from user_product where userId=?;";
            PreparedStatement pstmt = con.prepareStatement(sql3);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            String sql33 = "delete from user where userId=?;";
            PreparedStatement pstmt2 = con.prepareStatement(sql33);
            pstmt2.setInt(1, id);
            pstmt2.executeUpdate();
            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserById(int id) {
        try {
            Connection con = connect();
            String sql4 = "SELECT\n"
                    + "	u.*,\n"
                    + "	p.productId,\n"
                    + "	p.productName,\n"
                    + "	p.unitPrace,\n"
                    + "	p.available ,\n"
                    + "	p.updateDate,\n"
                    + "	p.addDate ,\n"
                    + "	b.*,\n"
                    + "	c.*\n"
                    + "FROM\n"
                    + "	`user` u\n"
                    + "	LEFT JOIN user_product up ON u.userId = up.userId\n"
                    + "	LEFT JOIN product p ON up.productId = p.productId\n"
                    + "	LEFT JOIN brand b ON p.brandId = b.brandId\n"
                    + "	LEFT JOIN category c ON p.categoryId = c.categoryId \n"
                    + "WHERE\n"
                    + "	u.userId = ?;";
            PreparedStatement pstmt = con.prepareStatement(sql4);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            boolean b = true;
            List<Product> list = new ArrayList<>();
            User user = null;
            while (rs.next()) {
                if (b == true) {
                    user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
                    b = false;
                }
                Brand brand = new Brand(rs.getInt(12), rs.getString(13));
                Category category = new Category(rs.getInt(14), rs.getString(15));
                Product product = new Product(rs.getInt(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getTimestamp(10), rs.getTimestamp(11), brand, category);
                list.add(product);
            }
            user.setProducts(list);
            con.close();
            return user;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public List<User> getAllUser() {
        try {
            Connection con = connect();
            String sql5 = "select* from user;";
            PreparedStatement pstmt = con.prepareStatement(sql5);
            ResultSet rs = pstmt.executeQuery();
            List<User> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5)));
            }
            con.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
