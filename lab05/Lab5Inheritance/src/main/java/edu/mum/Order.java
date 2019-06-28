package edu.mum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date = new Date();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLines = new ArrayList<OrderLine>();

    public void addOrderLine(OrderLine ol) {
        orderLines.add(ol);
    }

    @ManyToOne
    private Customer customer;
    public void setCustomer(Customer c){
        customer = c;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer.getName() +
                ", date=" + date +
                ", orderLines=" + orderLines +
                '}';
    }
}
