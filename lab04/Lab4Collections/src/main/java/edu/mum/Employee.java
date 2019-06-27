package edu.mum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "employee", cascade = {CascadeType.ALL})
    private Set<Laptop> laptops = new HashSet<Laptop>();

    public void addLaptop(Laptop laptop) {
        this.laptops.add(laptop);
        laptop.setEmployee(this);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", laptops=" + laptops +
                '}';
    }
}
