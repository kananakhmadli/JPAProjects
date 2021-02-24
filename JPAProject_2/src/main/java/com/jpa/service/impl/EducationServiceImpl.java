/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.service.impl;

import com.jpa.dao.Inter.EducationDaoInter;
import com.jpa.dao.impl.EducationDaoImple;
import com.jpa.model.Education;
import com.jpa.service.inter.EducationServiceInter;
import java.util.List;

/**
 *
 * @author Kanan
 */
public class EducationServiceImpl implements EducationServiceInter {

    private EducationDaoInter educationDaoInter = new EducationDaoImple();

    @Override
    public boolean saveEducation(Education education) {
        return this.educationDaoInter.saveEducation(education);
    }

    @Override
    public boolean updateEducation(Education education) {
        return this.educationDaoInter.updateEducation(education);
    }

    @Override
    public boolean removeEducation(Education education) {
        return this.educationDaoInter.removeEducation(education);
    }

    @Override
    public Education findById(Integer id) {
        return this.educationDaoInter.findById(id);
    }

    @Override
    public List<Education> findEducations() {
        return this.educationDaoInter.findEducations();
    }

    @Override
    public Education findWithAdvertismentById(Integer id) {
        return this.educationDaoInter.findWithAdvertismentById(id);
    }

}
