/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.service.impl;

import com.jpa.dao.Inter.AdvertismentDaoInter;
import com.jpa.dao.impl.AdvertismentDaoImpl;
import com.jpa.model.Advertisment;
import com.jpa.service.inter.AdvertismentServiceInter;
import java.util.List;

/**
 *
 * @author Kanan
 */
public class AdvertismentServiceImpl implements AdvertismentServiceInter {

    private AdvertismentDaoInter advertismentDaoInter = new AdvertismentDaoImpl();

    @Override
    public boolean saveAdvertisment(Advertisment advertisment) {
        return this.advertismentDaoInter.saveAdvertisment(advertisment);
    }

    @Override
    public boolean updateAdvertisment(Advertisment advertisment) {
        return this.advertismentDaoInter.updateAdvertisment(advertisment);
    }
 
    @Override
    public boolean removeAdvertisment(Advertisment advertisment) {
        return this.advertismentDaoInter.removeAdvertisment(advertisment);
    }

    @Override
    public Advertisment findById(Integer id) {
        return this.advertismentDaoInter.findById(id);
    }

    @Override
    public List<Advertisment> findByUsername(String username) {
        return this.advertismentDaoInter.findByUsername(username);
    }

    @Override
    public List<Advertisment> findAdvertisment() {
        return this.advertismentDaoInter.findAdvertisment();
    }
}
