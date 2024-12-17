package com.practice.third.graphic_texture.service;

import com.practice.third.graphic_texture.service.request.GraphicTextureCreateRequest;
import com.practice.third.graphic_texture.service.response.GraphicTextureCreateResponse;

public interface GraphicTextureService {
    GraphicTextureCreateResponse create(GraphicTextureCreateRequest graphicTextureCreateRequest);
}
