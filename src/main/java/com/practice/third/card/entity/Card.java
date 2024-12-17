package com.practice.third.card.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CardName cardName;

    @Enumerated(EnumType.STRING)
    private CardPlacement placement;

    @Enumerated(EnumType.STRING)
    private CardStatusEffect statusEffect;

    public Card() {}

    public Card(CardName cardName, CardPlacement placement, CardStatusEffect statusEffect) {
        this.cardName = cardName;
        this.placement = placement;
        this.statusEffect = statusEffect;
    }
}
