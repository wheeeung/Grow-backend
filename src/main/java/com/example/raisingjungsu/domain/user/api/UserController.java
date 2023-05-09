package com.example.raisingjungsu.domain.user.api;

import com.example.raisingjungsu.domain.user.api.dto.request.EditProfileRequest;
import com.example.raisingjungsu.domain.user.api.dto.response.InventoryResponse;
import com.example.raisingjungsu.domain.user.api.dto.response.UserResponse;
import com.example.raisingjungsu.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/mypage")
    public UserResponse getUser(){
        return userService.getUser();
    }

    @PatchMapping("/mypage")
    public void editProfile(EditProfileRequest request){
        userService.editUser(request);
    }
    
    @GetMapping("/inventory")
    public InventoryResponse getMySkin(){
        return userService.getMySkin();
    }
}
