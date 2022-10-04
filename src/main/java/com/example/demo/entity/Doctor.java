package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "doctor",schema = "dentist_cards")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "doctor")
    private List<Visit> visit;


    public String getFullName(){
        return "".concat(lastName).concat(" ").concat(firstName).concat(" ").concat(middleName);
    }
}
