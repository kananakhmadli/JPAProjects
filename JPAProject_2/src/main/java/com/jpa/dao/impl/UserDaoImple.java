package com.jpa.dao.impl;

import com.jpa.dao.Inter.AbstractDAO;
import com.jpa.dao.Inter.UserDaoInter;
import com.jpa.model.User;
import com.jpa.model.UserInfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserDaoImple extends AbstractDAO implements UserDaoInter {

    @Override
    public boolean saveUser(User user) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(user);
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
    public boolean updateUser(User user) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(user);
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
    public boolean removeUser(User user) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(user);
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
    public User findById(Integer id) {
        EntityManager em = em();
        try {
            TypedQuery<User> typedQuery = em.createNamedQuery("User.findById", User.class);
            typedQuery.setParameter("userId", id);
            return typedQuery.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findUserByUsername(String username) {
        EntityManager em = em();
        try {
            TypedQuery<User> typedQuery = em.createNamedQuery("User.findByUsername", User.class);
            typedQuery.setParameter("username", username);
            return typedQuery.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> findUsers() {
        EntityManager em = em();
        try {
            TypedQuery<User> typedQuery = em.createNamedQuery("User.findUsers", User.class);
            return typedQuery.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int findUserCount() {
        EntityManager em = em();
        try {
            TypedQuery<Integer> typedQuery = em.createNamedQuery("User.count", Integer.class);
            return typedQuery.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public UserInfo findUserInfoByUsername(String username) {
        EntityManager em = em();
        try {
            TypedQuery<UserInfo> typedQuery = em.createNamedQuery("User.findUserInfoByUsername", UserInfo.class);
            typedQuery.setParameter("username", username);
            return typedQuery.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
