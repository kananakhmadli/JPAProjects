package com.jpa.dao.impl;

import com.jpa.dao.Inter.AbstractDAO;
import com.jpa.dao.Inter.AdvertismentDaoInter;
import com.jpa.model.Advertisment;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AdvertismentDaoImpl extends AbstractDAO implements AdvertismentDaoInter {

    @Override
    public boolean saveAdvertisment(final Advertisment advertisment) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(advertisment);
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
    public boolean updateAdvertisment(final Advertisment advertisment) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.merge(advertisment);
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
    public boolean removeAdvertisment(final Advertisment advertisment) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.remove(advertisment);
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
    public Advertisment findById(final Integer id) {
        EntityManager em = em();
        try {
            TypedQuery<Advertisment> typedQuery = em.createNamedQuery("Advertisment.findById", Advertisment.class);
            typedQuery.setParameter("adervtismentId", id);
            return typedQuery.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Advertisment> findByUsername(final String username) {
        EntityManager em = em();
        try {
            TypedQuery<Advertisment> typedQuery = em.createNamedQuery("Advertisment.findByUsername", Advertisment.class);
            typedQuery.setParameter("username", username);
            return typedQuery.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Advertisment> findAdvertisment() {
        EntityManager em = em();
        try {
            TypedQuery<Advertisment> typedQuery = em.createNamedQuery("Advertisment.findAdvertisments", Advertisment.class);
            return typedQuery.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
