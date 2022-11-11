package org.example.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="desktop")
public class DesktopEntity {

    @Id
    @Column(name = "assetId")
    private String machineEntity;

    @Column(name = "makeYear")
    private int make;
}
