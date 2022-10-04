package com.example.demo.dvo;

import com.example.demo.entity.Visit;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class VisitDVO {
    private Long id;
    private LocalDate date;
    private int teeth;
    private String workDesc;
    private double sum;
    private Long cardId;
    private String doctorName;

    public VisitDVO(Visit visit) {
        this.id = visit.getId();
        this.date = visit.getDate();
        this.teeth = visit.getTeeth();
        this.workDesc = visit.getWorkDesc();
        this.sum = visit.getSum();
        this.cardId = visit.getCard().getId();
        this.doctorName = visit.getDoctor().getFullName();

    }

    public static List<VisitDVO> mapList(List<Visit> visit) {
        if (visit==null||visit.isEmpty()){
            return null;
        }
        return visit.stream().map(VisitDVO::new).collect(Collectors.toList());
    }
}
