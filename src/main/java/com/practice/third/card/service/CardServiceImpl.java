package com.practice.third.card.service;

import com.practice.third.card.entity.Card;
import com.practice.third.card.entity.CardDamage;
import com.practice.third.card.entity.CardHp;
import com.practice.third.card.entity.CardName;
import com.practice.third.card.repository.CardRepository;
import com.practice.third.card.service.request.CardCreateRequest;
import com.practice.third.card.service.response.CardCreateResponse;
import com.practice.third.graphic_texture.entity.GraphicTexture;
import com.practice.third.graphic_texture.entity.GraphicTextureName;
import com.practice.third.graphic_texture.repository.GraphicTextureRepository;

public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final GraphicTextureRepository graphicTextureRepository;
    private final CardHpRepository cardHpRepository;
    private final CardDamageRepository cardDamageRepository;

    @Override
    public CardCreateResponse create(CardCreateRequest cardCreateRequest) {
        Long cardNumber = cardCreateRequest.getCardNumber();
        String name = CardName.getNameByValue(cardNumber);
        Card card = cardCreateRequest.toCard(name);
        Card createdCard = cardRepository.save(card);

        String graphicTextureName = GraphicTextureName.getNameByValue(cardNumber);
        GraphicTexture graphicTexture = graphicTextureRepository.findById(graphicTextureId);

        CardHp cardHp = new CardHp(10L, graphicTexture, card);
        CardHp createdCardHp = cardHpRepository.save(cardHp);

        CardDamage cardDamage = new CardDamage(3L, graphicTexture, card);
        CardDamage createdCardDamage = cardDamageRepository.save(cardDamage);

        return null;
    }
}
