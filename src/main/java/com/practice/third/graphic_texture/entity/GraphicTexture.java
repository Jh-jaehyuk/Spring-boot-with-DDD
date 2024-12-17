package com.practice.third.graphic_texture.entity;

import com.practice.third.card.entity.Card;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class GraphicTexture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private GraphicTextureName graphicTextureName;

    private Long positionX;
    private Long positionY;

    private Long cardNumber;

    public GraphicTexture() {}

    public GraphicTexture(GraphicTextureName graphicTextureName, Long positionX, Long positionY, Long cardNumber) {
        this.graphicTextureName = graphicTextureName;
        this.positionX = positionX;
        this.positionY = positionY;
        this.cardNumber = cardNumber;
    }

    public void setPositionX(Long positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(Long positionY) {
        this.positionY = positionY;
    }

    public static GraphicTexture from(
            GraphicTextureName graphicTextureName, Long positionX, Long positionY, Long cardNumber) {
        return new GraphicTexture(
                graphicTextureName,
                positionX,
                positionY,
                cardNumber
        );
    }
}
