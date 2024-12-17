package com.practice.third.card.service;

import com.practice.third.card.service.request.CardCreateRequest;

public interface CardService {
    CardCreateResponse create(CardCreateRequest cardCreateRequest);
}
