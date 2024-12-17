package com.practice.third.graphic_texture.entity;

import java.util.Objects;

public enum GraphicTextureName {
    FIRE_DRAGON_CARD_DAMAGE((long) 1),
    ICE_WARRIOR_CARD_DAMAGE((long) 2),
    LIGHTNING_MAGE_CARD_DAMAGE((long) 3),
    SHADOW_ASSASSIN_CARD_DAMAGE((long) 4),
    EARTH_GIANT_CARD_DAMAGE((long) 5),
    WIND_RANGER_CARD_DAMAGE((long) 6);

    private final Long value;

    GraphicTextureName(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public static GraphicTextureName getGraphicTextureNameByValue(Long value) {
        for (GraphicTextureName graphicTextureName: GraphicTextureName.values()) {
            if (Objects.equals(graphicTextureName.value, value)) {
                return graphicTextureName;
            }
        }

        return GraphicTextureName.FIRE_DRAGON_CARD_DAMAGE;
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
            return (long) -1;
        }
    }
}
