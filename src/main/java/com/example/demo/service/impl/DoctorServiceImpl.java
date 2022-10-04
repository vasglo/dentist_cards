package com.example.demo.service.impl;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> create(DoctorDTO doctorDTO) {
        Doctor doctor = toEntity(doctorDTO);
        if (isDoctorAlreadyExist(doctor)){
            throw new EntityExistsException();
        }
        doctorRepository.save(doctor);
        return doctorRepository.findAll();
    }

    @Override
    public Doctor update(DoctorDTO doctorDTO) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorDTO.getId());
        if (optionalDoctor.isPresent()){
            Doctor doctor = optionalDoctor.get();
            update(doctor,doctorDTO);
            doctorRepository.save(doctor);
            return doctor;
        }
        throw new EntityNotFoundException();
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getById(Long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()){
            return optionalDoctor.get();
        }
        throw new EntityNotFoundException();
    }

    @Override
    public List<Doctor> deleteById(Long id) {
        doctorRepository.deleteById(id);
        return getAll();
    }

    private boolean isDoctorAlreadyExist(Doctor doctor){
        return doctorRepository.findByFirstNameAndLastNameAndMiddleNameAndAddressAndPhoneNumber(
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getMiddleName(),
                doctor.getAddress(),
                doctor.getPhoneNumber())!= null;
    }

    private Doctor toEntity(DoctorDTO doctorDTO){
        return Doctor.builder()
                .address(doctorDTO.getAddress())
                .firstName(doctorDTO.getFirstName())
                .middleName(doctorDTO.getMiddleName())
                .lastName(doctorDTO.getLastName())
                .phoneNumber(doctorDTO.getPhoneNumber())
                .address(doctorDTO.getAddress())
                .build();
    }

    private void update(Doctor doctor,DoctorDTO doctorDTO){
        doctor.setAddress(doctorDTO.getAddress());
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setLastName(doctorDTO.getLastName());
        doctor.setMiddleName(doctorDTO.getMiddleName());
        doctor.setPhoneNumber(doctorDTO.getPhoneNumber());
    }
}
