package com.jpa.main;

import com.jpa.model.Address;
import com.jpa.model.Advertisment;
import com.jpa.model.Education;
import com.jpa.model.User;
import com.jpa.model.UserDetail;
import com.jpa.model.util.PhoneType;
import com.jpa.service.impl.AdvertismentServiceImpl;
import com.jpa.service.impl.EducationServiceImpl;
import com.jpa.service.impl.UserDetailServiceImpl;
import com.jpa.service.impl.UserServiceImpl;
import com.jpa.service.inter.AdvertismentServiceInter;
import com.jpa.service.inter.EducationServiceInter;
import com.jpa.service.inter.UserDetailServiceInter;
import com.jpa.service.inter.UserServiceInter;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        foo4();

    }

    public static void foo() {
        User user1 = new User("kah.kan", "sjsj", new Date());
        UserDetail userDetail = new UserDetail("Kana", "Akhmaldi", new Date());
        user1.setUserDetail(userDetail);

        Advertisment advertisment = new Advertisment("Java", "tecili axarilir", "Web developer");

        UserServiceInter userServiceInter = new UserServiceImpl();
        userServiceInter.saveUser(user1);
//
//        UserDetailServiceInter detailServiceInter = new UserDetailServiceImpl();
//        detailServiceInter.saveUserDetail(userDetail);
//
        AdvertismentServiceInter advertismentServiceInter = new AdvertismentServiceImpl();
        advertismentServiceInter.saveAdvertisment(advertisment);
/////
    }

    public static void foo2() {
        Education education = new Education("ADNSU", 4);
        Education education2 = new Education("BDU", 2);
        Education education3 = new Education("ASS", 5);

        EducationServiceInter educationServiceInter = new EducationServiceImpl();
        educationServiceInter.saveEducation(education);
        educationServiceInter.saveEducation(education2);
        educationServiceInter.saveEducation(education3);

    }

    public static void foo3() {
        User u = new User("hell", "123455", new Date());
        UserDetail userDetail = new UserDetail("Taleh", "Memmedov", new Date());
        Address address = new Address("Nizami street", "55", 1777, "Baku");
        userDetail.getPhoneNamber().put(PhoneType.CELL, "9999999");
        userDetail.getPhoneNamber().put(PhoneType.WORK, "4444444");
        userDetail.getAddresses().add(address);
        u.setUserDetail(userDetail);

        UserServiceInter userServiceInter = new UserServiceImpl();
        userServiceInter.saveUser(u);

    }

    public static void foo4() {
        UserDetailServiceInter userDetailServiceInter = new UserDetailServiceImpl();
        UserDetail userDetail = userDetailServiceInter.findById(2);

        EducationServiceInter educationServiceInter = new EducationServiceImpl();
        Advertisment advertisment1 = new Advertisment("Python", "Full time", "Backend");
        advertisment1.getEducations().add(educationServiceInter.findById(1));
        advertisment1.getEducations().add(educationServiceInter.findById(2));
        advertisment1.setUserDetail(userDetail);

        Advertisment advertisment2 = new Advertisment("PHP", "Part time", "Full Stack");
        advertisment2.getEducations().add(educationServiceInter.findById(1));
        advertisment2.getEducations().add(educationServiceInter.findById(2));
        advertisment2.getEducations().add(educationServiceInter.findById(3));
        advertisment2.setUserDetail(userDetail);

        AdvertismentServiceInter advertismentServiceInter = new AdvertismentServiceImpl();
        advertismentServiceInter.saveAdvertisment(advertisment1);
        advertismentServiceInter.saveAdvertisment(advertisment2);

    }

}
