package com.example.demo.controller;

import com.example.demo.dto.CardDTO;
import com.example.demo.dto.DoctorDTO;
import com.example.demo.dvo.DoctorDVO;
import com.example.demo.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctors")
@AllArgsConstructor
public class DoctorController {

    private DoctorService doctorService;

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("doctors", DoctorDVO.mapList(doctorService.getAll()));
        return "doctors";
    }

    @GetMapping("/create")
    public String addDoctorView(Model model) {
        model.addAttribute("doctor", new CardDTO());
        return "add-doctor";
    }

    @PostMapping("/create")
    public String createDoctor(@ModelAttribute("card")DoctorDTO doctorDTO, Model model) {
        try {
            model.addAttribute("doctors", DoctorDVO.mapList(doctorService.create(doctorDTO)));
            return "doctors";
        } catch (Exception e) {
            model.addAttribute("exceptionMassage", e.getMessage());
            return "exception-page";
        }
    }

    @GetMapping("/{id}")
    public String getDoctorView(@PathVariable Long id,Model model){
        model.addAttribute("doctor", new DoctorDVO(doctorService.getById(id)));
        model.addAttribute("doctorDTO", new DoctorDTO());
        return "doctor";
    }

    @PostMapping("/update")
    public String updateDoctor(@ModelAttribute DoctorDTO doctorDTO, Model model){
        model.addAttribute("doctor", new DoctorDVO(doctorService.update(doctorDTO)));
        return getDoctorView(doctorDTO.getId(),model);
    }

    @GetMapping("/delete")
    public String deleteVisit(@RequestParam Long doctorId,
                              Model model){
        model.addAttribute("doctors", DoctorDVO.mapList(doctorService.deleteById(doctorId)));
        return "doctors";
    }
}
