package edu.mum.cs544;

import java.util.List;

import edu.mum.cs544.model.Airline;
import edu.mum.cs544.model.Flight;
import java.text.DateFormat;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

public class App {

  private static EntityManagerFactory emf;

  public static void main(String[] args) throws Exception {
    emf = Persistence.createEntityManagerFactory("cs544");

    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();

    // a) TODO: Flights leaving USA capacity > 500
    System.out.println("Question A:");
    List<Flight> flights = em
        .createQuery("from Flight f where f.origin.country=:origin and f.destination.country!=:origin and f.airplane.capacity>500", Flight.class)
        .setParameter("origin", "USA").getResultList();

    System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:", "Arrives:");
    for (Flight flight : flights) {
      System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n", flight.getFlightnr(), flight.getOrigin().getCity(),
          flight.getDepartureDate(), flight.getDepartureTime(), flight.getDestination().getCity(),
          flight.getArrivalDate(), flight.getArrivalTime() + ", capacity: " + flight.getAirplane().getCapacity());
    }
    System.out.println();

    em.getTransaction().commit();
    em.close();

    // if (true)
    // return;

    em = emf.createEntityManager();
    em.getTransaction().begin();

    // b) TODO: All airlines that use A380 airplanes
    System.out.println("Question B:");
    List<Airline> airlines = em
        .createQuery("select distinct a from Airline a JOIN a.flights f JOIN f.airplane ap where ap.model=:model",
            Airline.class)
        .setParameter("model", "A380").getResultList();
    System.out.println("Airlines that use A380s:");
    for (Airline airline : airlines) {
      System.out.println(airline.getName());
    }
    System.out.println();

    em.getTransaction().commit();
    em.close();

    // if (true)
    // return;

    em = emf.createEntityManager();
    em.getTransaction().begin();

    // c) TODO: Flights using 747 planes that don't belong to Star Alliance
    System.out.println("Question C:");
    flights = em.createQuery("from Flight f where f.airplane.model=:model and f.airline.name!=:airline", Flight.class)
        .setParameter("model", "747").setParameter("airline", "Star Alliance").getResultList();
    System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:", "Arrives:");
    for (Flight flight : flights) {
      System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n", flight.getFlightnr(), flight.getOrigin().getCity(),
          flight.getDepartureDate(), flight.getDepartureTime(), flight.getDestination().getCity(),
          flight.getArrivalDate(), flight.getArrivalTime());
    }
    System.out.println();

    em.getTransaction().commit();
    em.close();

    // if (true)
    //   return;

    em = emf.createEntityManager();
    em.getTransaction().begin();

    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
    DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.US);

    // d) TODO: All flights leaving before 12pm on 08/07/2009
    System.out.println(tf.parse("12:00 PM"));
    System.out.println("Question D:");
    TypedQuery<Flight> query = em.createQuery("from Flight f where f.departureDate<=:date and f.departureTime<:time",
        Flight.class);
    query.setParameter("date", df.parse("8/7/2009"), TemporalType.DATE)
    .setParameter("time", tf.parse("12:00 PM"), TemporalType.TIME);
    
    flights = query.getResultList();
    System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:", "Arrives:");
    for (Flight flight : flights) {
      System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n", flight.getFlightnr(), flight.getOrigin().getCity(),
          flight.getDepartureDate(), flight.getDepartureTime(), flight.getDestination().getCity(),
          flight.getArrivalDate(), flight.getArrivalTime());
    }
    System.out.println();
    em.getTransaction().commit();
    em.close();
  }
}
