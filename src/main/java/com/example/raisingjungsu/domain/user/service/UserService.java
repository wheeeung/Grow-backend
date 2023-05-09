package com.example.raisingjungsu.domain.user.service;

import com.example.raisingjungsu.domain.user.api.dto.request.EditProfileRequest;
import com.example.raisingjungsu.domain.user.api.dto.response.InventoryResponse;
import com.example.raisingjungsu.domain.user.api.dto.response.UserResponse;
import com.example.raisingjungsu.domain.user.domain.User;
import com.example.raisingjungsu.domain.user.exception.UserNotFoundException;
import com.example.raisingjungsu.domain.user.repository.UserRepository;
import com.example.raisingjungsu.global.util.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse getUser(){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        return UserResponse.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .coin(user.getCoin())
                .image(user.getImage())
                .questionList(user.getQuestionList())
                .answerList(user.getAnswerList())
                .build();
    }

    @Transactional
    public void editUser(EditProfileRequest request){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        user.editProfile(request.getNickname(), request.getImage());
        userRepository.save(user);
    }

    @Transactional
    public InventoryResponse getMySkin(){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        return new InventoryResponse(user.getSkinList());
    }
}
