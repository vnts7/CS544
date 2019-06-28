package edu.mum;

import javax.persistence.*;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;

    public OrderLine() {
    }

    public OrderLine(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    @ManyToOne
    private Product product;

    @Override
    public String toString() {
        return "OrderLine{" +
                "quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
