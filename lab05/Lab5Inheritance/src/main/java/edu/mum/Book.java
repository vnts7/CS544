package edu.mum;

import javax.persistence.Entity;

@Entity
public class Book extends Product {
    private String title;

    public Book() {
    }

    public Book(String name, String description, String title) {
        super(name, description);
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + getName() + '\'' +
                ", title='" + title + '\'' +
                "} ";
    }
}
