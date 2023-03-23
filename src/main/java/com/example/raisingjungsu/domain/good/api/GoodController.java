package com.example.raisingjungsu.domain.good.api;

import com.example.raisingjungsu.domain.good.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GoodController {
    private final GoodService goodService;

    @PostMapping("/good/{answer_id}")
    public void insertGood(@PathVariable int answer_id){
        goodService.insertGood(answer_id);
    }

    @DeleteMapping("/good/{answer_id}")
    public void deleteGood(@PathVariable int answer_id){
        goodService.deleteGood(answer_id);
    }
}
