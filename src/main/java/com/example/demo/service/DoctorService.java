package com.example.demo.service;


import com.example.demo.dto.DoctorDTO;
import com.example.demo.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> create(DoctorDTO doctorDTO);

    Doctor update(DoctorDTO doctorDTO);

    List<Doctor> getAll();

    Doctor getById(Long id);

    List<Doctor> deleteById(Long id);
}
