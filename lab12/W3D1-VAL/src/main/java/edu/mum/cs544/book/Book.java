package edu.mum.cs544.book;

//import org.hibernate.validator.constraints.*;

import org.hibernate.validator.constraints.ISBN;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank
//  @SafeHtml
  private String title;
  @org.hibernate.validator.constraints.ISBN
  private String ISBN;
  @NotBlank
//  @SafeHtml
  private String author;
  @Positive
  private double price;

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getISBN() {
    return this.ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + id + "'" +
      ", title='" + title + "'" +
      ", ISBN='" + ISBN + "'" +
      ", author='" + author + "'" +
      ", price='" + price + "'" +
      "}";
  }
}
