package com.practice.third.card.controller.request_form;

import com.practice.third.card.service.request.CardCreateRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CardCreateRequestForm {
    private final Long cardNumber;

    public CardCreateRequest toCardCreateRequest() {
        return new CardCreateRequest(this.cardNumber);
    }
}
