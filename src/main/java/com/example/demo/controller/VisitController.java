package com.example.demo.controller;

import com.example.demo.dto.VisitDTO;
import com.example.demo.dvo.CardDVO;
import com.example.demo.dvo.DoctorDVO;
import com.example.demo.entity.Visit;
import com.example.demo.service.CardService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/visit")
@AllArgsConstructor
public class VisitController {

    private VisitService visitService;
    private DoctorService doctorService;
    private CardService cardService;
    private CardController cardController;

    @GetMapping(value = "/new")
    public String createVisitView(@RequestParam Long cardId, Model model){
        model.addAttribute("visit", new VisitDTO());
        model.addAttribute("doctors", DoctorDVO.mapList(doctorService.getAll()));
        model.addAttribute("card", new CardDVO(cardService.getById(cardId)));
        return "add-visit";
    }

    @PostMapping
    public String createVisit(@ModelAttribute VisitDTO visitDTO, Model model){
        Visit visit = visitService.create(visitDTO);
        model.addAttribute("visit",visit);
        return cardController.getById(visit.getCard().getId(),model);
    }

    @GetMapping("/delete")
    public String deleteVisit(@RequestParam Long cardId,
                              @RequestParam Long visitId,
                              Model model){
        visitService.delete(visitId);
        return cardController.getById(cardId,model);
    }
}
