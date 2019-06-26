package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();

        TypedQuery<Students> query = em.createQuery("from edu.mum.cs544.Students", Students.class);
        List<Students> list = query.getResultList();
        for (Students i : list) {
            System.out.println("Student name= " + i.getName());
        }
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        Students student = new Students(999,"Handsome Mohamed");
        em.persist(student);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        query = em.createQuery("from edu.mum.cs544.Students", Students.class);
        list = query.getResultList();
        for (Students i : list) {
            System.out.println("Student name= " + i.getName());
        }
        em.close();
    }
}
