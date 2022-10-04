package com.example.demo.repository;

import com.example.demo.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardRepository extends JpaRepository<Card,Long> {
    Card findByFirstNameAndLastNameAndMiddleNameAndAddressAndPhoneNumber(String firstName,
                                                                         String lastName,
                                                                         String middleName,
                                                                         String address,
                                                                         String phoneNumber);

    @Query(value = "SELECT DISTINCT c.*" +
            " FROM card c" +
            " LEFT JOIN visit v on c.id = v.card_id" +
            " WHERE v.doctor_id = :doctorId",nativeQuery = true)
    List<Card>findAllByDoctor(Long doctorId);

    @Query("SELECT c FROM Card c WHERE c.lastName LIKE %:lastName%")
    List<Card> getAllByLastNameLike(@Param("lastName") String lastName);
}
