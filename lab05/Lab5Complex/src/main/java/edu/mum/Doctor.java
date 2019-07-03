package edu.mum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String doctortype;

    private String firstname;

    private String lastname;


    public Doctor() {
    }

    public Doctor(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + id + "'" +
            ", firstname='" + firstname + "'" +
            "}";
    }

}
