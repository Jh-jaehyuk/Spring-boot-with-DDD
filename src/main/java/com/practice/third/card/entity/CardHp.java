package com.practice.third.card.entity;

import com.practice.third.graphic_texture.entity.GraphicTexture;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class CardHp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long hp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "graphic_texture_id", nullable = false)
    private GraphicTexture graphicTexture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    public CardHp() {}

    public CardHp(Long hp, GraphicTexture graphicTexture, Card card) {
        this.hp = hp;
        this.graphicTexture = graphicTexture;
        this.card = card;
    }
}
