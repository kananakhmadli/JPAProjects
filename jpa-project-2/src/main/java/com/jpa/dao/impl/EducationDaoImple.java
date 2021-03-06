package com.jpa.dao.impl;

import com.jpa.dao.Inter.AbstractDAO;
import com.jpa.dao.Inter.EducationDaoInter;
import com.jpa.model.Education;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EducationDaoImple extends AbstractDAO implements EducationDaoInter {

    @Override
    public boolean saveEducation(Education education) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(education);
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
    public boolean updateEducation(Education education) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(education);
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
    public boolean removeEducation(Education education) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(education);
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
    public Education findById(Integer id) {
        EntityManager em = em();
        try {
            TypedQuery<Education> typedQuery = em.createNamedQuery("Education.findEducationById", Education.class);
            typedQuery.setParameter("educationId", id);
            return typedQuery.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Education> findEducations() {
        EntityManager em = em();
        try {
            TypedQuery<Education> typedQuery = em.createNamedQuery("Education.findEducation", Education.class);
            return typedQuery.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Education findWithAdvertismentById(Integer id) {
        EntityManager em = em();
        try {
            TypedQuery<Education> typedQuery = em.createNamedQuery("Education.findWithAdvertismetnById", Education.class);
            typedQuery.setParameter("educationId", id);
            return typedQuery.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
