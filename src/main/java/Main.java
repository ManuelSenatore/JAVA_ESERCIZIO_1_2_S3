import models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main( String[] args ) {
        insertEvento();
        insertLocation();
        insertPersona();



        System.out.println(findEvento(5));
        System.out.println(findPerson(1));

        insertPartecipazione(1, 3);


    }

    public static void insertEvento() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();

        Evento e = new Evento("Fiesta con i 4 Pagliacci", "1/12/2022", "Fiesta de fuego", TipoEvento.PUBBLICO, 500);

        em.persist(e);
        et.commit();

        em.close();
        emf.close();
    }

    public static void insertPersona() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();

        Persona p = new Persona("gigi", "finizio", "123@123.it", "10/10/90", Sesso.MASCHIO);

        em.persist(p);
        et.commit();

        em.close();
        emf.close();
    }

    public static void insertLocation() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();

        Location e = new Location("Citta","Milano");

        em.persist(e);
        et.commit();

        em.close();
        emf.close();
    }

    public static Persona findPerson(int id) {
        Persona personaFind = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");
        EntityManager em = emf.createEntityManager();

        Persona p = em.find(Persona.class, id);

        if(p != null) {
            personaFind = p;
        }

        em.close();
        emf.close();
        return personaFind;
    }

    public static Evento findEvento(int id) {
        Evento eventoFind = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");
        EntityManager em = emf.createEntityManager();

        Evento p = em.find(Evento.class, id);

        if(p != null) {
            eventoFind = p;
        }

        em.close();
        emf.close();
        return eventoFind;
    }

    public static Location findLocation(int id) {
        Location locationFind = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");
        EntityManager em = emf.createEntityManager();

        Location p = em.find(Location.class, id);

        if(p != null) {
            locationFind = p;
        }

        em.close();
        emf.close();
        return locationFind;
    }
    public static void insertPartecipazione(int idP, int idE) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();

        Partecipazione e = new Partecipazione(findPerson(idP), findEvento(idE), Stato.DA_CONFERMARE);

        em.persist(e);
        et.commit();

        em.close();
        emf.close();
    }

    public void delete(Evento object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");
        EntityManager em = emf.createEntityManager();
        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(object);

            transaction.commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("Errore nell'eliminazione");
            throw ex;

        } finally {
            em.close();
        }
    }

}
