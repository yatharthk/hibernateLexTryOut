package org.myBank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "MOVIE")
@GenericGenerator(name = "generatorName",strategy = "assigned")
public class Movie {

    @Id
    @Column(name="id")
    @GeneratedValue(generator = "generatorName")
    private String movieId;


    @Column(name="name")
    private String movieName;

    @Column(name = "language")
    private String language;

    @Column(name = "released_in")
    private Integer releasedIn;

    @Column(name = "revenue_in_dollars")
    private Integer revenueInDollars;
}
