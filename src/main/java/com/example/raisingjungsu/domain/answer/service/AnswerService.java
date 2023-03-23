package com.example.raisingjungsu.domain.answer.service;

import com.example.raisingjungsu.domain.answer.api.dto.AnswerRequest;
import com.example.raisingjungsu.domain.answer.domain.Answer;
import com.example.raisingjungsu.domain.answer.repository.AnswerRepository;
import com.example.raisingjungsu.domain.question.domain.Question;
import com.example.raisingjungsu.domain.question.exception.QuestionNotFoundException;
import com.example.raisingjungsu.domain.question.repository.QuestionRepository;
import com.example.raisingjungsu.domain.user.domain.User;
import com.example.raisingjungsu.domain.user.exception.UserNotFoundException;
import com.example.raisingjungsu.domain.user.repository.UserRepository;
import com.example.raisingjungsu.global.util.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Transactional
    public void save(AnswerRequest request){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Question question = questionRepository.findById(request.getQuestion_id()).orElseThrow(QuestionNotFoundException::new);
        Answer answer = Answer.builder()
                .answer(request.getAnswer())
                .user(user)
                .question(question)
                .build();

        answerRepository.save(answer);
    }

    public void delete(int answer_id){
        answerRepository.deleteById(answer_id);
    }
}
