package com.example.demo.dvo;

import com.example.demo.entity.Card;
import com.example.demo.entity.Doctor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DoctorDVO {
    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String phoneNumber;

    public DoctorDVO(Doctor doctor){
        this.id = doctor.getId();
        this.lastName = doctor.getLastName();
        this.firstName = doctor.getFirstName();
        this.middleName = doctor.getMiddleName();
        this.address = doctor.getAddress();
        this.phoneNumber = doctor.getPhoneNumber();
    }

    public static List<DoctorDVO> mapList(List<Doctor> doctors){
        if (doctors==null||doctors.isEmpty()){
            return null;
        }
        return doctors.stream().map(DoctorDVO::new).collect(Collectors.toList());
    }
}
