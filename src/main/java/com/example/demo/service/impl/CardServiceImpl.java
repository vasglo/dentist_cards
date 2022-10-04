package com.example.demo.service.impl;


import com.example.demo.dto.CardDTO;
import com.example.demo.entity.Card;
import com.example.demo.repository.CardRepository;
import com.example.demo.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    @Override
    public List<Card> createCard(CardDTO cardDTO) {
        Card card = toEntity(cardDTO);
        if (isCardAlreadyExist(card)) {
            throw new EntityExistsException();
        }
        cardRepository.save(card);
        cardRepository.flush();
        return getAll();
    }

    @Override
    public List<Card> getAll() {
        return cardRepository.findAll();
    }

    @Override
    public List<Card> getAllByDoctor(Long doctorId) {
        return cardRepository.findAllByDoctor(doctorId);
    }

    @Override
    public List<Card> getAllByLastNameLike(String lastName) {
        return cardRepository.getAllByLastNameLike(lastName);
    }

    @Override
    public Card getById(Long id) {
        Optional<Card> optionalCard = cardRepository.findById(id);
        if (optionalCard.isPresent()) {
            return optionalCard.get();
        }
        throw new EntityNotFoundException();
    }

    @Override
    public List<Card> delete(Long id) {
        cardRepository.deleteById(id);
        return getAll();
    }

    private boolean isCardAlreadyExist(Card card) {
        return cardRepository.findByFirstNameAndLastNameAndMiddleNameAndAddressAndPhoneNumber(card.getFirstName(),
                card.getLastName(), card.getMiddleName(), card.getAddress(), card.getPhoneNumber()) != null;
    }


    private Card toEntity(CardDTO cardDTO) {
        Card card = new Card();
        card.setFirstName(cardDTO.getFirstName());
        card.setLastName(cardDTO.getLastName());
        card.setMiddleName(cardDTO.getMiddleName());
        card.setAddress(cardDTO.getAddress());
        card.setWorkPlace(cardDTO.getWorkPlace());
        card.setPhoneNumber(cardDTO.getPhoneNumber());
        return card;
    }
}
