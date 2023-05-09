package com.example.raisingjungsu.domain.user.api.dto.response;

import com.example.raisingjungsu.domain.skin.domain.Skin;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class InventoryResponse {
    private List<Skin> skinList;
}
