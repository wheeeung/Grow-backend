package com.example.raisingjungsu.domain.answer.api;

import com.example.raisingjungsu.domain.answer.api.dto.AnswerRequest;
import com.example.raisingjungsu.domain.answer.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping("/answer")
    public void save(@RequestBody AnswerRequest request){
        answerService.save(request);
    }

    @DeleteMapping("/answer/{answer_id}")
    public void delete(@PathVariable int answer_id){
        answerService.delete(answer_id);
    }
}
