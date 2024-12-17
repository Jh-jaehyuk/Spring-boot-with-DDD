package com.practice.third.card.controller;

import com.practice.third.card.controller.request_form.CardCreateRequestForm;
import com.practice.third.card.controller.response_form.CardCreateResponseForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    @PostMapping("/create")
    public CardCreateResponseForm create(
            @RequestBody CardCreateRequestForm cardCreateRequestForm) {
        log.info("card controller -> create() called!");

        CardCreateResponse response = cardService.create(cardCreateRequestForm.toCardCreateRequest());

        return CardCreateResponseForm.from(response);
    }
}
