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
        Doctor doctor = new Doctor("Handsome");
        Patient patient = new Patient("Mohamed", "Fairfield");
        em.persist(doctor);
        em.persist(patient);
        Payment payment = new Payment("12/06/08", 100);

        Appointment appointment = new Appointment(patient, payment, doctor);
        em.persist(appointment);

        

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        List<Appointment> list = em.createQuery("from Appointment", Appointment.class).getResultList();
        for(Appointment i: list){
          System.out.println(i);
        }
        em.close();
    }
}
