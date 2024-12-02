package com.practice.second.game.controller.response_form;

import com.practice.second.game.service.response.RecordGameWinnerResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RecordGameWinnerResponseForm {
    private final String message;

    public static RecordGameWinnerResponseForm from(RecordGameWinnerResponse response) {
        return new RecordGameWinnerResponseForm(response.getMessage());
    }
}
