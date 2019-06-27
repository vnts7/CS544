package edu.mum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Flight() {
    }

    public Flight(String name) {
        this.name = name;
    }

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "flight_id")
    @OrderColumn
    private List<Passenger> passengers = new ArrayList<Passenger>();

    public void addPassenger(Passenger p) {
        passengers.add(p);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passengers=" + passengers +
                '}';
    }
}
