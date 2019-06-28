package edu.mum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id")
    private List<Order> orders = new ArrayList<Order>();



    public void makeOrder(Order o){
        orders.add(o);
        o.setCustomer(this);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", orders=" + orders +
                '}';
    }
}
