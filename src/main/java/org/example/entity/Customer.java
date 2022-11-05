package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

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

    //ASSOCIATE LOCKER WITH CUSTOMER -> CUSTOMER HAS A LOCKER .
    // DB MAPPINGS SHOULD BE PRESENT.
    //TYPE -> ONE TO ONE MAPPING
    //IDENTIFIER FOR LOCKER  = LOCKER iD -> FOREIGN KEY
    //Cascade -> which operations should affect locker table.->
        // all=(persist,update,delete,insert)
    //COLUMNS JOINING BASED ON "lockerId"
        // this should be same as we defined in our entity class in java.


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lockerId",unique = true)
    private Locker locker;

}
