package com.example.raisingjungsu.domain.skin.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SkinResponse {
    private int skinId;
    private String img;
    private int price;
}
