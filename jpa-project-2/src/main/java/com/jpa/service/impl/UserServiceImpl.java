/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.service.impl;

import com.jpa.dao.Inter.UserDaoInter;
import com.jpa.dao.impl.UserDaoImple;
import com.jpa.model.User;
import com.jpa.model.UserInfo;
import com.jpa.service.inter.UserServiceInter;
import java.util.List;

/**
 *
 * @author Kanan
 */
public class UserServiceImpl implements UserServiceInter {

    private UserDaoInter userDaoInter = new UserDaoImple();

    @Override
    public boolean saveUser(User user) {
        return this.userDaoInter.saveUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return this.userDaoInter.updateUser(user);
    }

    @Override
    public boolean removeUser(User user) {
        return this.userDaoInter.removeUser(user);
    }

    @Override
    public User findById(Integer id) {
        return this.userDaoInter.findById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return this.userDaoInter.findUserByUsername(username);
    }

    @Override
    public List<User> findUsers() {
        return this.userDaoInter.findUsers();
    }

    @Override
    public int findUserCount() {
        return this.userDaoInter.findUserCount();
    }

    @Override
    public UserInfo findUserInfoByUsername(String username) {
        return this.userDaoInter.findUserInfoByUsername(username);
    }

}
