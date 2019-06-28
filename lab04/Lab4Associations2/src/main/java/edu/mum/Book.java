package edu.mum;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne()
    @JoinTable(name="book_publisher")
    private  Publisher publisher;

    public Book(String name, Publisher publisher) {
        this.name = name;
        this.publisher = publisher;
    }
}
