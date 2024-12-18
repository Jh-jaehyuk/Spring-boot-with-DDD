package com.practice.third.graphic_texture.entity;

import java.util.Objects;

public enum GraphicTextureName {
    FIRE_DRAGON_CARD_DAMAGE(1L),
    ICE_WARRIOR_CARD_DAMAGE(2L),
    LIGHTNING_MAGE_CARD_DAMAGE(3L),
    SHADOW_ASSASSIN_CARD_DAMAGE(4L),
    EARTH_GIANT_CARD_DAMAGE(5L),
    WIND_RANGER_CARD_DAMAGE(6L);

    private final Long value;

    GraphicTextureName(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public static String getNameByValue(Long value) {
        for (GraphicTextureName graphicTextureName: GraphicTextureName.values()) {
            if (Objects.equals(graphicTextureName.value, value)) {
                return graphicTextureName.name();
            }
        }

        return "UNKNOWN";
    }

    public static Long getValueByName(String name) {
        try {
            return GraphicTextureName.valueOf(name.toUpperCase()).value;
        } catch (IllegalArgumentException e) {
            return  -1L;
        }
    }
}
