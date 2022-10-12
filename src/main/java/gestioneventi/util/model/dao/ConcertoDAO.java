package gestioneventi.util.model.dao;

import gestioneventi.util.JpaUtil;
import gestioneventi.util.model.Concerto;
import gestioneventi.util.model.Genere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.List;

public class ConcertoDAO {

    private static final Logger logger = LoggerFactory.getLogger(ConcertoDAO.class);

    public static void save(Concerto object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.persist(object);

            transaction.commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();

            logger.error("Error saving object: " + object.getClass().getSimpleName(), ex);
            throw ex;

        } finally {
            em.close();
        }

    }

    public static void refresh(Concerto object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            em.refresh(object);

        } finally {
            em.close();
        }

    }

    public static Concerto getById(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.find(Concerto.class, id);

        } finally {
            em.close();
        }

    }

    public static void delete(Concerto object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(object);

            transaction.commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            logger.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
            throw ex;

        } finally {
            em.close();
        }
    }

    public static void getConcertiInStreaming(boolean n){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        Query q = em.createQuery(
                "SELECT c FROM Concerto c Where c.streaming = :n "
        );

        q.setParameter("n", n);

        List<Concerto> r = q.getResultList();
        for (Concerto p : r) {
            System.out.println(p);
        }
        em.close();
    }

    public static void getConcertiPerGenere(Genere n){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        Query q = em.createQuery(
                "SELECT c FROM Concerto c Where c.genere = :n "
        );

        q.setParameter("n", n);

        List<Concerto> r = q.getResultList();
        for (Concerto p : r) {
            System.out.println(p);
        }
        em.close();
    }

}