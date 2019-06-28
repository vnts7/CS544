package edu.mum;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    private Office office;

    @ManyToOne
    private Department department;

    public Employee() {
    }

    public Employee(String name, Office office) {
        this.name = name;
        this.office = office;
    }
}
