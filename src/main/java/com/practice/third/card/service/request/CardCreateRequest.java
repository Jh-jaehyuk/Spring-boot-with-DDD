package com.practice.third.card.service.request;

import com.practice.third.card.entity.Card;
import com.practice.third.card.entity.CardName;
import com.practice.third.card.entity.CardPlacement;
import com.practice.third.card.entity.CardStatusEffect;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CardCreateRequest {
    private final Long cardNumber;

    public Card toCard(CardName cardName, CardPlacement placement, CardStatusEffect effect) {
        return new Card(cardName, placement, effect);
    }
}
