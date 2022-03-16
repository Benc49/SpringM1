package com.example.demo.flight;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Flight {
    @Id
    @SequenceGenerator(
            name = "flight_sequence",
            sequenceName= "flight_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "flight_sequence"
    )
    private Long id;
    private String pname;
    private String destination;
    private LocalDate date;

    public Flight() {
    }

    public Flight(Long id,
                  String pname,
                  String destination,
                  LocalDate date) {
        this.id = id;
        this.pname = pname;
        this.destination = destination;
        this.date = date;
    }

    public Flight(String pname,
                  String destination,
                  LocalDate date) {
        this.pname = pname;
        this.destination = destination;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                '}';
    }
}
