package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="CUSTOMER_HQL")
public class Customer {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String customerName;


}
