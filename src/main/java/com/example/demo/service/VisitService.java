package com.example.demo.service;


import com.example.demo.dto.VisitDTO;
import com.example.demo.entity.Visit;

import java.util.List;

public interface VisitService {

    Visit create(VisitDTO visitDTO);

    void update(VisitDTO visitDTO);

    void delete(Long id);

    List<Visit> getAllByCard(Long cardId);
}
