/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.jpaFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Kanan
 */
public abstract class AbstractDAO {

    private EntityManagerFactory emf = null;

    public EntityManager em() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("pu");

        }
        EntityManager entityManager = emf.createEntityManager();
        return entityManager;

    }

    public void closeEmf() {
        emf.close();
    }

}
