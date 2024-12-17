package com.practice.third.card.controller.request_form;

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
