package org.myBank.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer")
//@GenericGenerator(name = "idGen",strategy = "increment")
public class Customer {

    @Id
    //@GeneratedValue(generator = "idGen")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //THIS WORKS WITH AUTO INCREMENT PROPERTY (MYSQL-YES /ORACLE -NO)
    @Column(name = "ID")
    private int customerId;

    @Column(name = "NAME")
    private String customerName;

    @Temporal(TemporalType.DATE)
    @Column(name = "DOB")
    Date dateOfBirth;

    @Column(name = "ADDRESS")
    String address;

    @Column(name = "PHONE_NO")
    Long phoneNo;

    public Customer(String name, Date dob, String address, Long phone) {
        this.customerName = name;
        this.dateOfBirth = dob;
        this.address = address;
        this.phoneNo = phone;
    }
}
