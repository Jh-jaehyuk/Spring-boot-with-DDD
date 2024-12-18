package com.practice.third.graphic_texture.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class GraphicTexture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long positionX;
    private Long positionY;

    public GraphicTexture() {}

    public GraphicTexture(Long positionX, Long positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void setPositionX(Long positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(Long positionY) {
        this.positionY = positionY;
    }
}
