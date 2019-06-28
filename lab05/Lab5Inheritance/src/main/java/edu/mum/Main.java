package edu.mum;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {
    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Product cd = new CD("CD name", "Why need description", "Artist Handsome");
        Product dvd = new DVD("DVD name", "Why need description", "Action");
        Product book = new Book("DVD name", "Why need description", "How handsome is Mohamed?");

        em.persist(cd);
        em.persist(dvd);
        em.persist(book);

        OrderLine orderLine = new OrderLine(1, cd);
        OrderLine orderLine2 = new OrderLine(2, book);

        Order order = new Order();
        order.addOrderLine(orderLine);
        order.addOrderLine(orderLine2);

        Customer handsome = new Customer("Handsome");
        handsome.makeOrder(order);

        em.persist(handsome);

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Customer> query = em.createQuery("from Customer", Customer.class);
        List<Customer> list = query.getResultList();
        for (Customer i : list) {
            System.out.println(i);
        }
        em.getTransaction().commit();
        em.close();
    }
}
