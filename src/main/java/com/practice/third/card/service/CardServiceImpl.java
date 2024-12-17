package com.practice.third.card.service;

import com.practice.third.card.entity.*;
import com.practice.third.card.repository.CardNameRepository;
import com.practice.third.card.repository.CardPlacementRepository;
import com.practice.third.card.repository.CardRepository;
import com.practice.third.card.repository.CardStatusEffectRepository;
import com.practice.third.card.service.request.CardCreateRequest;
import com.practice.third.graphic_texture.entity.GraphicTexture;
import com.practice.third.graphic_texture.entity.GraphicTextureName;
import com.practice.third.graphic_texture.repository.GraphicTextureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final GraphicTextureRepository graphicTextureRepository;
    private final CardNameRepository cardNameRepository;
    private final CardPlacementRepository cardPlacementRepository;
    private final CardStatusEffectRepository cardStatusEffectRepository;

    @Override
    public CardCreateResponse create(CardCreateRequest cardCreateRequest) {
        GraphicTexture graphicTexture = graphicTextureRepository.findByCardNumber(
                cardCreateRequest.getCardNumber());
        GraphicTextureName graphicTextureName = graphicTexture.getGraphicTextureName();
        Long value = graphicTextureName.getValue();
        String textureName = GraphicTextureName.getNameByValue(value);

        CardName cardName = cardNameRepository.getCardNameByValue(value);
//        CardPlacement placement = cardPlacementRepository.getCardPlacementByValue((long) 1);
//        CardPlacement placement = CardPlacement.HAND;
//        CardStatusEffect effect = cardStatusEffectRepository.getCardStatusEffectByValue((long) 0);
//        CardStatusEffect effect = CardStatusEffect.NORMAL;

        Card card = cardCreateRequest.toCard(cardName, CardPlacement.HAND, CardStatusEffect.NORMAL);
        Card createdCard = cardRepository.save(card);

        CardHp cardHp = new CardHp((long) 10, graphicTexture, card);
        CardDamage cardDamage = new CardDamage((long) 3, graphicTexture, card);

        return null;
    }
}
