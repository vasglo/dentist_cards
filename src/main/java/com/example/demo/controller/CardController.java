package com.example.demo.controller;

import com.example.demo.dto.CardDTO;
import com.example.demo.dvo.CardDVO;
import com.example.demo.dvo.DoctorDVO;
import com.example.demo.entity.Card;
import com.example.demo.service.CardService;
import com.example.demo.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cards")
@AllArgsConstructor
public class CardController {

    private CardService cardService;
    private DoctorService doctorService;

    @GetMapping("/create")
    public String addCardView(Model model) {
        model.addAttribute("card", new CardDTO());
        return "add-card";
    }

    @PostMapping("/create")
    public String createCard(@ModelAttribute("card") CardDTO cardDTO, Model model) {
        try {
            model.addAttribute("cardsList", CardDVO.mapList(cardService.createCard(cardDTO)));
            return "cards";
        } catch (Exception e) {
            model.addAttribute("exceptionMassage", e.getMessage());
            return "exception-page";
        }
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("cardsList", CardDVO.mapList(cardService.getAll()));
        model.addAttribute("doctors", DoctorDVO.mapList(doctorService.getAll()));
        return "cards";
    }

    @GetMapping("/all_by_doctor")
    public String getAllByDoctor(@RequestParam Long doctorId, Model model) {
        model.addAttribute("cardsList", CardDVO.mapList(cardService.getAllByDoctor(doctorId)));
        model.addAttribute("doctors", DoctorDVO.mapList(doctorService.getAll()));
        model.addAttribute("doctorId", doctorId);
        return "cards";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute("cardById", new CardDVO(cardService.getById(id)));
        return "card";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long cardId, Model model) {
        model.addAttribute("cardsList", CardDVO.mapList(cardService.delete(cardId)));
        model.addAttribute("doctors", DoctorDVO.mapList(doctorService.getAll()));
        return "cards";
    }

    @GetMapping("/all-by-last-name")
    public String findByLastName(@RequestParam String lastName, Model model) {
        List<Card> allByLastNameLike = cardService.getAllByLastNameLike(lastName);
        model.addAttribute("cardsList", CardDVO.mapList(allByLastNameLike));
        model.addAttribute("searchParam", lastName);
        return "cards";
    }
}
