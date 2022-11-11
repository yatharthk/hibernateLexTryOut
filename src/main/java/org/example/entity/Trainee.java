package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Trainee")
public class Trainee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "trainee_id")
    private Integer id;

    @Column(name = "trainee_name")
    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE})
    @JoinColumn(name = "trainee_asset")
    private DesktopEntity desktop;
}
