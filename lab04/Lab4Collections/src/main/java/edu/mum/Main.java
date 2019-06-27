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

        Employee employee = new Employee("Handsome");
        Laptop l1 = new Laptop("Macbook pro");
        Laptop l2 = new Laptop("Macbook air");
        employee.addLaptop(l1);
        employee.addLaptop(l2);
        em.persist(employee);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();


        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
        List<Employee> list = query.getResultList();
        for (Employee i : list) {
            System.out.println(i);
        }
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        Flight flight = new Flight("To America");
        Passenger p1 = new Passenger("Handsome");
        Passenger p2 = new Passenger("Mohamed");
        flight.addPassenger(p1);
        flight.addPassenger(p2);
        em.persist(flight);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();


        TypedQuery<Flight> query2 = em.createQuery("from Flight", Flight.class);
        List<Flight> list2 = query2.getResultList();
        for (Flight i : list2) {
            System.out.println(i);
        }
        em.getTransaction().commit();
        em.close();
    }
}
