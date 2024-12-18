package com.practice.third.card.entity;

import java.util.Objects;

public enum CardName {
    FIRE_DRAGON(1L),
    ICE_WARRIOR(2L),
    LIGHTNING_MAGE(3L),
    SHADOW_ASSASSIN(4L),
    EARTH_GIANT(5L),
    WIND_RANGER(6L);

    private final Long value;

    CardName(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public static String getNameByValue(Long value) {
        for (CardName cardName: CardName.values()) {
            if (Objects.equals(cardName.value, value)) {
                return cardName.name();
            }
        }

        return "UNKNOWN";
    }

    public static Long getValueByName(String name) {
        try {
            return CardName.valueOf(name.toUpperCase()).value;
        } catch (IllegalArgumentException e) {
            return -1L;
        }
    }
}
