package edu.mum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name = "Address", pkJoinColumns = {
    @PrimaryKeyJoinColumn(name="patient_id", referencedColumnName = "id" )
})
public class Patient {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(table = "Address")
    private String street;

    @Column(table = "Address")
    private String zip;

    @Column(table = "Address")
    private String city;

    public Patient() {
    }

    public Patient(String name, String street) {
        this.name = name;
        this.street = street;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + id + "'" +
            ", name='" + name + "'" +
            ", street='" + street + "'" +
            "}";
    }


}
