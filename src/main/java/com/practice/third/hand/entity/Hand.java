package com.practice.third.hand.entity;

import com.practice.third.card.entity.Card;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Hand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<Card> cardList;

    public Hand(List<Card> cardList) {
        this.cardList = cardList;
    }

    public Hand() {}
}
