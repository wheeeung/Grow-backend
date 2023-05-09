package com.example.raisingjungsu.domain.skin.service;

import com.example.raisingjungsu.domain.skin.api.dto.request.SkinRequest;
import com.example.raisingjungsu.domain.skin.api.dto.response.SkinResponse;
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

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkinService {
    private final SkinRepository skinRepository;
    private final UserRepository userRepository;

    @Transactional
    public void buy(int skinId){
        Skin skin = skinRepository.findById(skinId).orElseThrow(SkinNotFoundException::new);
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);

        if(skin.getPrice() > user.getCoin() && user.getSkinList().get(skinId) != null)
            throw new SkinNotBuyException();

        user.editCoin(user.getCoin() - skin.getPrice());
        user.getSkinList().add(skin);
        userRepository.save(user);
    }

    @Transactional
    public void addSkin(SkinRequest request){
        Skin skin = Skin.builder()
                .skinImg(request.getImg())
                .price(request.getPrice())
                .build();
        skinRepository.save(skin);
    }

    @Transactional
    public void deleteSkin(int skinId){
        skinRepository.deleteById(skinId);
    }

    @Transactional
    public List<SkinResponse> getAllSkin(){
        List<Skin> skinList = skinRepository.findAll();
        return skinList.stream().map(s -> new SkinResponse(
                s.getId(),
                s.getSkinImg(),
                s.getPrice()
        )).collect(Collectors.toList());
    }

    @Transactional
    public SkinResponse getSkin(int skinId){
        Skin skin = skinRepository.findById(skinId).orElseThrow(SkinNotFoundException::new);
        return new SkinResponse(skin.getId(), skin.getSkinImg(), skin.getPrice());
    }
}
