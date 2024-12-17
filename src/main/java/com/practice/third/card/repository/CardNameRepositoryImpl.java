package com.practice.third.card.repository;

import com.practice.third.card.entity.CardName;
import org.springframework.stereotype.Repository;

@Repository
public class CardNameRepositoryImpl implements CardNameRepository {
    @Override
    public CardName getCardNameByValue(Long value) {
        return CardName.getCardNameByValue(value);
    }
}
