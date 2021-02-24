/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.service.impl;

import com.jpa.dao.Inter.UserDetailDaoInter;
import com.jpa.dao.impl.UserDetailDaoImple;
import com.jpa.model.UserDetail;
import com.jpa.service.inter.UserDetailServiceInter;

/**
 *
 * @author Kanan
 */
public class UserDetailServiceImpl implements UserDetailServiceInter {

    private UserDetailDaoInter userDetailDaoInter = new UserDetailDaoImple();

    @Override
    public boolean saveUserDetail(UserDetail userDetail) {
        return this.userDetailDaoInter.saveUserDetail(userDetail);
    }

    @Override
    public boolean updateUserDetail(UserDetail userDetail) {
        return this.userDetailDaoInter.updateUserDetail(userDetail);
    }

    @Override
    public boolean removeUserDetail(UserDetail userDetail) {
        return this.userDetailDaoInter.removeUserDetail(userDetail);

    }

    @Override
    public UserDetail findById(Integer id) {
        return this.userDetailDaoInter.findById(id);
    }

    @Override
    public UserDetail findUserByUsername(String username) {
        return this.userDetailDaoInter.findUserByUsername(username);
    }

    @Override
    public UserDetail findWithAddressByUsername(String username) {
        return this.userDetailDaoInter.findWithAddressByUsername(username);
    }

}
