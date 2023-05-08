package com.example.raisingjungsu.domain.skin.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SkinRequest {
    private String img;
    private int price;
}
