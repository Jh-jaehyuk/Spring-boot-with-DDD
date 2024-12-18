package com.practice.third.card.service.response;

import com.practice.third.card.entity.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CardCreateResponse {
    private final Long cardId;
    private final String cardName;
    private final String cardPlacement;
    private final String cardStatusEffect;
    private final String graphicTextureName;
    private final Long damage;
    private final Long hp;

    public static CardCreateResponse from(
            Card card, String cardName, CardPlacement placement, CardStatusEffect effect,
            String textureName, CardHp cardHp, CardDamage damage) {
        return new CardCreateResponse(
                card.getId(),
                cardName.getName(),
                placement.getName(),
                effect.getName(),
                textureName,
                damage.getDamage(),
                cardHp.getHp()
        );
    }
}
