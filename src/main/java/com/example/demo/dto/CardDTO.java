package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDTO {
    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String phoneNumber;
    private String workPlace;
}
