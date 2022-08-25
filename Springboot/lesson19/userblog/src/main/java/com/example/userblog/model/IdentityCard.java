package com.example.userblog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class IdentityCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime expired;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime issued;


    @PrePersist
    public void prePersist() {
        issued=LocalDateTime.now().minusYears(2);
        expired=LocalDateTime.now().plusYears(2);

    }
}
