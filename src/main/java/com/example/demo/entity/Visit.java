package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "visit",schema = "dentist_cards")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "teeth")
    private int teeth;
    @Column(name = "work_desc",length = 1000)
    private String workDesc;
    @Column(name = "sum")
    private double sum;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

}
