package com.example.demo.repository;

import com.example.demo.entity.Card;
import com.example.demo.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> findAllByCard(Card card);
}
