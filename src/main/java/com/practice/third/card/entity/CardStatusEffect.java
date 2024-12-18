package com.practice.third.card.entity;

import java.util.Arrays;
import java.util.Objects;

public enum CardStatusEffect {
    NORMAL((long) 0),
    BURN((long) 1),
    FREEZE((long) 2),
    STUN((long) 3),
    POISON((long) 4),
    SLEEP((long) 5),
    PARALYSIS((long) 6),
    SHIELD((long) 7),
    CURSE((long) 8),
    REGENERATION((long) 9);

    private final Long value;

    CardStatusEffect(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public static String getNameByValue(Long value) {
        for (CardStatusEffect effect: CardStatusEffect.values()) {
            if (Objects.equals(effect.value, value)) {
                return effect.name();
            }
        }

        return "UNKNOWN";
    }

    public static Long getValueByName(String name) {
        try {
            return CardStatusEffect.valueOf(name.toUpperCase()).value;
        } catch (IllegalArgumentException e) {
            return (long) -1;
        }
    }
}
