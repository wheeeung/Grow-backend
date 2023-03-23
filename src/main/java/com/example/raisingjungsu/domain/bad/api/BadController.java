package com.example.raisingjungsu.domain.bad.api;

import com.example.raisingjungsu.domain.bad.service.BadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BadController {
    private final BadService badService;

    @PostMapping("/bad/{answer_id}")
    public void insertBad(@PathVariable int answer_id){
        badService.insertBad(answer_id);
    }

    @DeleteMapping("/bad/{answer_id}")
    public void deleteBad(@PathVariable int answer_id){
        badService.deleteBad(answer_id);
    }
}
