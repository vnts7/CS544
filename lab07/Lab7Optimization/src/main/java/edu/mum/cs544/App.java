package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        long start = System.nanoTime();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Owner> query = em.createQuery("from Owner", Owner.class);
        List<Owner> ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }

        em.getTransaction().commit();
        em.close();
        long stop = System.nanoTime();

        // stop time
        System.out.println("To fetch this data from the database took " + (stop - start) / 1000000 + " milliseconds.");
        
        //-----d: JOIN FETCH
        em = emf.createEntityManager();
        query = em.createQuery("from Owner o JOIN FETCH o.pets", Owner.class);
        start = System.nanoTime();
        ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }
        em.close();
        stop = System.nanoTime();
        System.out.println("JOIN FETCH took " + (stop - start) / 1000000 + " milliseconds.");

        //-----e: EntityGraph
        em = emf.createEntityManager();
        EntityGraph<Owner> graph = em.createEntityGraph(Owner.class);
        graph.addAttributeNodes("pets");
        query = em.createQuery("from Owner", Owner.class);
        query.setHint("javax.persistence.fetchgraph", graph);
        start = System.nanoTime();
        ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }
        em.close();
        stop = System.nanoTime();
        System.out.println("EntityGraph took " + (stop - start) / 1000000 + " milliseconds.");

        System.out.println("In this circumstance, the strategies will perform best are: SUBSELECT, JOIN FETCH and EntityGraph");

        System.exit(0);
    }

}
