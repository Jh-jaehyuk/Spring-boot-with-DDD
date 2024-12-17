package com.practice.third.card.repository;

import com.practice.third.card.entity.CardPlacement;

public class CardPlacementRepositoryImpl implements CardPlacementRepository {
    @Override
    public CardPlacement getCardPlacementByValue(Long value) {
        return CardPlacement.getCardPlacementByValue(value);
    }
}
