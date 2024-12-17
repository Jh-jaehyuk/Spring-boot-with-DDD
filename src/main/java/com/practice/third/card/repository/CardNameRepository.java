package com.practice.third.card.repository;

import com.practice.third.card.entity.CardName;

public interface CardNameRepository {
    CardName getCardNameByValue(Long value);
}
