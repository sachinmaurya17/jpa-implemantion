package com.jpa.revisonjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "t_students",
        uniqueConstraints = @UniqueConstraint(
                name = "email_id",
                columnNames = {"email_id"}
        )
)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Student {
    @Id
    @SequenceGenerator(
            sequenceName = "students_details",
            name = "students_details",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "students_details"
    )
    private Long id;
    private String name;

    @Column(
            name = "email_id",
            nullable = false
    )
    private String email;

    @Column(name = "mobile_number")
    private String phone;

    @Embedded
    private Guardian guardian;
}
