/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aze.com.jdbc.inter;

import aze.com.jdbc.model.User;
import java.util.List;

/**
 *
 * @author Kanan
 */
public interface UserDaoInter {

    public boolean addUser(User u);

    public boolean updateUser(User u);

    public boolean deletUser(int id);

    public User getUserById(int id);

    public List<User> getAllUser();

}
