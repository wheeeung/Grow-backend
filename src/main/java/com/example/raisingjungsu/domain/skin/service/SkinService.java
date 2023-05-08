package com.example.raisingjungsu.domain.skin.service;

import com.example.raisingjungsu.domain.skin.domain.Skin;
import com.example.raisingjungsu.domain.skin.exception.SkinNotBuyException;
import com.example.raisingjungsu.domain.skin.exception.SkinNotFoundException;
import com.example.raisingjungsu.domain.skin.repository.SkinRepository;
import com.example.raisingjungsu.domain.user.domain.User;
import com.example.raisingjungsu.domain.user.exception.UserNotFoundException;
import com.example.raisingjungsu.domain.user.repository.UserRepository;
import com.example.raisingjungsu.global.util.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkinService {
    private final SkinRepository skinRepository;
    private final UserRepository userRepository;

    @Transactional
    public void buy(int skinId){
        Skin skin = skinRepository.findById(skinId).orElseThrow(SkinNotFoundException::new);
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);

        if(skin.getPrice() > user.getCoin())
            throw new SkinNotBuyException();

        user.editCoin(user.getCoin() - skin.getPrice());
        user.getSkinList().add(skin);
        userRepository.save(user);
    }
}
