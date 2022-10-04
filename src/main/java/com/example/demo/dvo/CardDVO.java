package com.example.demo.dvo;

import com.example.demo.entity.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CardDVO {
    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String phoneNumber;
    private String workPlace;
    private List<VisitDVO> visitList;

    public CardDVO(Card card){
        this.id = card.getId();
        this.lastName = card.getLastName();
        this.firstName = card.getFirstName();
        this.middleName = card.getMiddleName();
        this.address = card.getAddress();
        this.phoneNumber = card.getPhoneNumber();
        this.workPlace = card.getWorkPlace();
        this.visitList = VisitDVO.mapList(card.getVisitList());
    }

    public static List<CardDVO> mapList(List<Card> card){
        return card.stream().map(CardDVO::new).collect(Collectors.toList());
    }
}
