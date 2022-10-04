package com.example.demo.service.impl;

import com.example.demo.dto.VisitDTO;
import com.example.demo.entity.Visit;
import com.example.demo.repository.VisitRepository;
import com.example.demo.service.CardService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VisitServiceImpl implements VisitService {

    private VisitRepository visitRepository;
    private DoctorService doctorService;
    private CardService cardService;

    @Override
    public Visit create(VisitDTO visitDTO) {
        return visitRepository.save(toEntity(visitDTO));
    }

    @Override
    public void update(VisitDTO visitDTO) {
        Optional<Visit> optionalVisit = visitRepository.findById(visitDTO.getId());
        if (optionalVisit.isPresent()){
            Visit visit = optionalVisit.get();
            update(visit,visitDTO);
            visitRepository.save(visit);
            return;
        }
        throw new EntityNotFoundException();
    }

    @Override
    public void delete(Long id) {
        Optional<Visit> optionalVisit = visitRepository.findById(id);
        if (optionalVisit.isPresent()){
            visitRepository.delete(optionalVisit.get());
            return;
        }
        throw new EntityNotFoundException();
    }

    @Override
    public List<Visit> getAllByCard(Long cardId) {
        return visitRepository.findAllByCard(cardService.getById(cardId));
    }

    private Visit toEntity(VisitDTO visitDTO){
        return Visit.builder()
                .card(cardService.getById(visitDTO.getCardId()))
                .date(visitDTO.getDate())
                .doctor(doctorService.getById(visitDTO.getDoctorId()))
                .sum(visitDTO.getSum())
                .workDesc(visitDTO.getWorkDesc())
                .teeth(visitDTO.getTeeth())
                .build();

    }

    private void update(Visit visit,VisitDTO visitDTO){
        visit.setCard(cardService.getById(visitDTO.getCardId()));
        visit.setDoctor(doctorService.getById(visitDTO.getDoctorId()));
        visit.setSum(visitDTO.getSum());
        visit.setTeeth(visitDTO.getTeeth());
        visit.setDate(visitDTO.getDate());
        visit.setWorkDesc(visitDTO.getWorkDesc());
    }
}
