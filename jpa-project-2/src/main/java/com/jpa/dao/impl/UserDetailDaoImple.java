package com.jpa.dao.impl;

import com.jpa.dao.Inter.AbstractDAO;
import com.jpa.dao.Inter.UserDetailDaoInter;
import com.jpa.model.UserDetail;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserDetailDaoImple extends AbstractDAO implements UserDetailDaoInter {

    @Override
    public boolean saveUserDetail(UserDetail userDetail) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(userDetail);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            try {
                em.getTransaction().rollback();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;

        }
    }

    @Override
    public boolean updateUserDetail(UserDetail userDetail) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(userDetail);
            em.flush();
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            try {
                em.getTransaction().rollback();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;

        }
    }

    @Override
    public boolean removeUserDetail(UserDetail userDetail) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(userDetail);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            try {
                em.getTransaction().rollback();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;

        }
    }

    @Override
    public UserDetail findById(Integer id) {
        EntityManager em = em();
        try {

            return em.find(UserDetail.class, id);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserDetail findUserByUsername(String username) {
        EntityManager em = em();
        try {
            TypedQuery<UserDetail> typedQuery = em.createNamedQuery("UserDetail.findByUsername", UserDetail.class);
            typedQuery.setParameter("username", username);
            return typedQuery.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserDetail findWithAddressByUsername(String username) {
        EntityManager em = em();
        try {
            TypedQuery<UserDetail> typedQuery = em.createNamedQuery("UserDetail.findWithAdvertismentByUsername", UserDetail.class);
            typedQuery.setParameter("username", username);
            return typedQuery.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
