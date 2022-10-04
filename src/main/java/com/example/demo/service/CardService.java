package com.example.demo.service;

import com.example.demo.dto.CardDTO;
import com.example.demo.entity.Card;

import java.util.List;

public interface CardService {
    List<Card> createCard(CardDTO cardDTO);

    List<Card> getAll();

    List<Card> getAllByDoctor(Long doctorId);

    List<Card> getAllByLastNameLike(String lastName);

    Card getById(Long id);

    List<Card> delete(Long id);
}
