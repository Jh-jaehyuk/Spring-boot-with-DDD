package com.practice.third.card.entity;

import java.util.Objects;

public enum CardName {
    FIRE_DRAGON((long) 1),
    ICE_WARRIOR((long) 2),
    LIGHTNING_MAGE((long) 3),
    SHADOW_ASSASSIN((long) 4),
    EARTH_GIANT((long) 5),
    WIND_RANGER((long) 6);

    private final Long value;

    CardName(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public static CardName getCardNameByValue(Long value) {
        for (CardName cardName: CardName.values()) {
            if (Objects.equals(cardName.value, value)) {
                return cardName;
            }
        }

        return CardName.FIRE_DRAGON;
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
            return (long) -1;
        }
    }
}
