package com.practice.third.graphic_texture.controller.request_form;

import com.practice.third.graphic_texture.controller.response_form.GraphicTextureCreateResponseForm;
import com.practice.third.graphic_texture.service.request.GraphicTextureCreateRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GraphicTextureCreateRequestForm {
    private final Long graphicTextureKindsNumber;
    private final Long cardNumber;

    public GraphicTextureCreateRequest toGraphicTextureCreateRequest() {
        return new GraphicTextureCreateRequest(this.graphicTextureKindsNumber, this.cardNumber);
    }
}
