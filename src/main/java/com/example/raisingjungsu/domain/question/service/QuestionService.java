package com.example.raisingjungsu.domain.question.service;

import com.example.raisingjungsu.domain.question.api.dto.request.QuestionRequest;
import com.example.raisingjungsu.domain.question.api.dto.response.QuestionResponse;
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

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Transactional
    public void save(QuestionRequest request){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        user.editCoin(user.getCoin() + 10);
        userRepository.save(user);
        Question question = Question.builder()
                .title(request.getTitle())
                .question(request.getQuestion())
                .category(request.getCategory())
                .user(user)
                .build();

        questionRepository.save(question);
    }

    @Transactional
    public QuestionResponse getQuestion(int question_Id){
        Question question = questionRepository.findById(question_Id).orElseThrow(QuestionNotFoundException::new);
        return QuestionResponse.builder()
                .id(question.getId())
                .title(question.getTitle())
                .question(question.getQuestion())
                .category(question.getCategory())
                .user(question.getUser())
                .answerList(question.getAnswerList())
                .build();
    }

    @Transactional
    public void delete(int question_Id){
        questionRepository.deleteById(question_Id);
    }

    @Transactional
    public List<QuestionResponse> search(String keyword){
        List<Question> questions = questionRepository.findByTitleContaining(keyword);
        return questions.stream().map(q -> new QuestionResponse(
                q.getId(),
                q.getTitle(),
                q.getQuestion(),
                q.getCategory(),
                q.getUser(),
                q.getAnswerList()
        )).collect(Collectors.toList());
    }

    @Transactional
    public List<QuestionResponse> questionList(){
        List<Question> questions = questionRepository.findAll();
        return questions.stream().map(q -> new QuestionResponse(
                q.getId(),
                q.getTitle(),
                q.getQuestion(),
                q.getCategory(),
                q.getUser(),
                q.getAnswerList()
        )).collect(Collectors.toList());
    }
}
