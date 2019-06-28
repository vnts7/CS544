package edu.mum;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @MapKey(name = "studentId")
    @JoinColumn(name = "school_id")
    private Map<Integer, Student> students = new HashMap<Integer, Student>();

    public void addStudent(Student s){
        students.put(s.getStudentId(), s);
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
