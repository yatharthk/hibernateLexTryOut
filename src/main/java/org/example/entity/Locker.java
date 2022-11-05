package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Locker")
public class Locker {

    @Id
    @Column(name = "locker_id")
    private String lockerId;

    @Column(name = "locker_type")
    private String lockerType;

    @Column(name = "rent")
    private double rent;

}
