package exercise.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Driver_License")
@GenericGenerator(name = "hilo_gen",strategy = "hilo",parameters = {@Parameter(name = "max_lo",value = "15")})
public class DrivingLicense {
    @Id
    @GeneratedValue(generator = "hilo_gen")
    @Setter(AccessLevel.NONE)
    Integer licenseNumber;
    String name;
    Integer age;
    String gender;
    String address;
    LocalDate licenseIssueDate;
    LocalDate licenseExpiryDate;
    String licenseIssueZone;
}
