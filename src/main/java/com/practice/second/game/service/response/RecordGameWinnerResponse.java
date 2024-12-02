package com.practice.second.game.service.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RecordGameWinnerResponse {
    private final String message;

    public static RecordGameWinnerResponse winner(String winnerName) {
        return new RecordGameWinnerResponse("승자: " + winnerName);
    }

    public static RecordGameWinnerResponse draw() {
        return new RecordGameWinnerResponse("무승부!");
    }

    public static RecordGameWinnerResponse gameNotFound() {
        return new RecordGameWinnerResponse("게임을 찾을 수 없습니다!");
    }

    public static RecordGameWinnerResponse noPlayers() {
        return new RecordGameWinnerResponse("플레이어가 없습니다!");
    }
}
