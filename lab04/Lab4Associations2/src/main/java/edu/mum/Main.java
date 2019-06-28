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

        Student student = new Student(1, "Handsome");
        Student student2 = new Student(2, "Mohamed");

        Course course = new Course("EA");
        Course course2 = new Course("MWA");

        student.addCourse(course);
        student.addCourse(course2);

        em.persist(student);

        em.getTransaction().commit();
        em.close();

//        em = emf.createEntityManager();
//        em.getTransaction().begin();
//        em.find(Course.class, course).addStudent(student2);
//        em.getTransaction().commit();
//        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Student> query2 = em.createQuery("from Student", Student.class);
        List<Student> list2 = query2.getResultList();
        for (Student i : list2) {
            System.out.println(i);
        }


        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        Book book = new Book("How to die?", null);
        em.persist(book);

        em.getTransaction().commit();
        em.close();
    }
}
