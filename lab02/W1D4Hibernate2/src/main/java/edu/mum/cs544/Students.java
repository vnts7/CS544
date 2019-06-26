package edu.mum.cs544;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;


@Entity(name = "edu.mum.cs544.Students")
@Table(name = "students")
public class Students {
  public  Students(){
  }
  public  Students(Integer id, String name){
    this.id = id;
    this.name = name;
  }

  @Id
  @Column(name = "\"id\"", nullable = false)
  private Integer id;
  @Column(name = "\"name\"", nullable = true)
  private String name;
  @Column(name = "\"email\"", nullable = true)
  private String email;
  @Column(name = "\"password\"", nullable = true)
  private String password;

  public String getName(){
    return this.name;
  }
}