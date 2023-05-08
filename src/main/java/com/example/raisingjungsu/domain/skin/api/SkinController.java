package com.example.raisingjungsu.domain.skin.api;

import com.example.raisingjungsu.domain.skin.api.dto.request.SkinRequest;
import com.example.raisingjungsu.domain.skin.api.dto.response.SkinResponse;
import com.example.raisingjungsu.domain.skin.service.SkinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SkinController {
    private final SkinService skinService;

    @PostMapping("/skin/buy/{skinId}")
    public void buy(@PathVariable int skinId){
        skinService.buy(skinId);
    }

    @PostMapping("/skin")
    public void addSkin(@RequestBody SkinRequest request){
        skinService.addSkin(request);
    }

    @DeleteMapping("/skin/{skinId}")
    public void deleteSkin(@PathVariable int skinId){
        skinService.deleteSkin(skinId);
    }

    @GetMapping("/skin/all")
    public List<SkinResponse> getAllSkin(){
        return skinService.getAllSkin();
    }

    @GetMapping("/skin/{skinId}")
    public SkinResponse getSkin(@PathVariable int skinId){
        return skinService.getSkin(skinId);
    }
}
