package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    public  Owner(){}
    public Owner(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public String toString(){
        return "Id: "+id + ", Name: " + name;
    }
}