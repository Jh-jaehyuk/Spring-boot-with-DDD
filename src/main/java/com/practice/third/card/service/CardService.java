package com.practice.third.card.service;

import com.practice.third.card.service.request.CardCreateRequest;
import com.practice.third.card.service.response.CardCreateResponse;

public interface CardService {
    CardCreateResponse create(CardCreateRequest cardCreateRequest);
}
