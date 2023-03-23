package com.example.raisingjungsu.domain.good.service;

import com.example.raisingjungsu.domain.answer.domain.Answer;
import com.example.raisingjungsu.domain.answer.exception.AnswerNotFoundException;
import com.example.raisingjungsu.domain.answer.repository.AnswerRepository;
import com.example.raisingjungsu.domain.good.domain.Good;
import com.example.raisingjungsu.domain.good.exception.GoodAlreadyExistException;
import com.example.raisingjungsu.domain.good.exception.GoodNotFoundException;
import com.example.raisingjungsu.domain.good.repository.GoodRepository;
import com.example.raisingjungsu.domain.user.domain.User;
import com.example.raisingjungsu.domain.user.exception.UserNotFoundException;
import com.example.raisingjungsu.domain.user.repository.UserRepository;
import com.example.raisingjungsu.global.util.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoodService {
    private final UserRepository userRepository;
    private final AnswerRepository answerRepository;
    private final GoodRepository goodRepository;

    @Transactional
    public void insertGood(int answer_id){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Answer answer = answerRepository.findById(answer_id).orElseThrow(AnswerNotFoundException::new);

        if(isNotAlreadyGood(answer, user)){
            Good good = Good.builder()
                    .user(user)
                    .answer(answer)
                    .build();
            goodRepository.save(good);
            answer.setGoodCount(answer.getGoodCount() + 1);
            answerRepository.save(answer);
        }
        else {
            throw new GoodAlreadyExistException();
        }
    }

    public void deleteGood(int answer_id){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Answer answer = answerRepository.findById(answer_id).orElseThrow(AnswerNotFoundException::new);
        Good good = goodRepository.findByUserAndAnswer(user, answer).orElseThrow(GoodNotFoundException::new);

        goodRepository.delete(good);

        answer.setGoodCount(answer.getGoodCount() - 1);
        answerRepository.save(answer);
    }

    private boolean isNotAlreadyGood(Answer answer, User user){
        return goodRepository.findByUserAndAnswer(user, answer).isEmpty();
    }
}
