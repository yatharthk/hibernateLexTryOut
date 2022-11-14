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
@GenericGenerator(name = "idGen",strategy = "native")
//native strategy for mysql will work with auto increment enabled
// and if db supports sequence,it will be  using sequence.
public class Customer {

    @Id
    @GeneratedValue(generator = "idGen")
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

    @Transient
    private int age;

    public Customer(String name, Date dob, String address, Long phone) {
        this.customerName = name;
        this.dateOfBirth = dob;
        this.address = address;
        this.phoneNo = phone;
    }
}
