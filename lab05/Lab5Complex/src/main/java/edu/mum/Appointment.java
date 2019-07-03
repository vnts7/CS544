package edu.mum;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String appdate;

    @ManyToOne
    @JoinColumn(name = "patient")
    private Patient patient;

    @Embedded
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "doctor")
    private Doctor doctor;


    public Appointment() {
    }

    public Appointment(Patient patient, Payment payment, Doctor doctor) {
        this.patient = patient;
        this.payment = payment;
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + id + "'" +
            ", patient='" + patient + "'" +
            ", payment='" + payment + "'" +
            ", doctor='" + doctor + "'" +
            "}";
    }

}
