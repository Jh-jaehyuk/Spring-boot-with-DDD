package com.practice.third.card.repository;

import com.practice.third.card.entity.CardStatusEffect;

public interface CardStatusEffectRepository {
    CardStatusEffect getCardStatusEffectByValue(Long value);
}
