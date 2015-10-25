package br.com.map.marcelo.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcelo
 */
public class JPAUtil {
    private static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("MAPPU");
    
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    private JPAUtil(){
    }
}
