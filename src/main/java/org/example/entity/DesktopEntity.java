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
@Table(name="desktops")
public class DesktopEntity {

    @Id
    @Column(name = "asset_id")
    private String machineEntity;

    @Column(name = "makeYear")
    private int make;
}
