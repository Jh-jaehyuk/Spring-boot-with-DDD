package com.practice.third.card.repository;

import com.practice.third.card.entity.CardPlacement;

public interface CardPlacementRepository {
    CardPlacement getCardPlacementByValue(Long value);
}
