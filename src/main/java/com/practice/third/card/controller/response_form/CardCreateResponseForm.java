package com.practice.third.card.controller.response_form;

import com.practice.third.card.service.response.CardCreateResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CardCreateResponseForm {
    private final Long cardId;
    private final String cardName;
    private final String cardPlacement;
    private final String cardStatusEffect;
    private final String graphicTextureName;
    private final Long damage;
    private final Long hp;

    public static CardCreateResponseForm from(CardCreateResponse cardCreateResponse) {
        return new CardCreateResponseForm(
                cardCreateResponse.getCardId(),
                cardCreateResponse.getCardName(),
                cardCreateResponse.getCardPlacement(),
                cardCreateResponse.getCardStatusEffect(),
                cardCreateResponse.getGraphicTextureName(),
                cardCreateResponse.getDamage(),
                cardCreateResponse.getHp());
    }
}
