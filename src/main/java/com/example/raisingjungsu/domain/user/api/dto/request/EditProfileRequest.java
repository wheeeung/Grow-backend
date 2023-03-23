package com.example.raisingjungsu.domain.user.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EditProfileRequest {
    private String nickname;
    private String image;
}
