package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name="CUSTOMER")
public class Customer {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String customerName;

    @Temporal(TemporalType.DATE)
    @Column(name="dob")
    private LocalDate dateOfBirth;

    @Transient
    private int age;

}
