package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import org.hibernate.annotations.Parameter;

//Pre steps:
//Generate CUSTOMERID as a primary key using the Hilo identifier.
//Create an additional table "hibernate_unique_key" with an integer type column "next_hi".
//Insert a value for next_hi as 1 into hibernate_unique_key table.
//If the "hbm2ddl.auto" property is enabled then the tables will be automatically generated.
//Modify Customer.java  with Hilo as key generation strategy as mentioned below:

@Data
@ToString
@Entity
@Table(name="CUSTOMER_ADVANCED")
@GenericGenerator(name = "hilo_gen",strategy = "hilo",parameters = {
        @Parameter(name = "max_lo",value = "2")})

//this above one will print
//    ________________________
//    |__HIBERNATE_UNIQUE_KEY_|
//    |  NEXT_HI              |
//    |  1                    |
//    _________________________


@GenericGenerator(name = "hilo_gen",strategy = "hilo",parameters = {
        @Parameter(name = "table",value = "table_name"),
        @Parameter(name = "column",value = "column_name"),
        @Parameter(name="max_lo",value = "2") })
public class Customer {

    @Id
    @GeneratedValue(generator = "hilo_gen")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String customerName;

    @Column(name="dob")
    private LocalDate dateOfBirth;
}
