package com.example.raisingjungsu.domain.question.api;

import com.example.raisingjungsu.domain.question.api.dto.request.QuestionRequest;
import com.example.raisingjungsu.domain.question.api.dto.response.QuestionResponse;
import com.example.raisingjungsu.domain.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("/question")
    public void save(@RequestBody QuestionRequest request){
        questionService.save(request);
    }

    @GetMapping("/question/{question_Id}")
    public QuestionResponse getQuestion(@PathVariable int question_Id){
        return questionService.getQuestion(question_Id);
    }

    @GetMapping("/question")
    public List<QuestionResponse> search(@RequestParam("keyword") String keyword){
        return questionService.search(keyword);
    }

    @DeleteMapping("/question/{question_id}")
    public void delete(@PathVariable int question_id){
        questionService.delete(question_id);
    }
}
