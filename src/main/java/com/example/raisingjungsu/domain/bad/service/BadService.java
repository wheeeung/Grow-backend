package com.example.raisingjungsu.domain.bad.service;

import com.example.raisingjungsu.domain.answer.domain.Answer;
import com.example.raisingjungsu.domain.answer.exception.AnswerNotFoundException;
import com.example.raisingjungsu.domain.answer.repository.AnswerRepository;
import com.example.raisingjungsu.domain.bad.domain.Bad;
import com.example.raisingjungsu.domain.bad.exception.BadAlreadyExistException;
import com.example.raisingjungsu.domain.bad.exception.BadNotFoundException;
import com.example.raisingjungsu.domain.bad.repository.BadRepository;
import com.example.raisingjungsu.domain.user.domain.User;
import com.example.raisingjungsu.domain.user.exception.UserNotFoundException;
import com.example.raisingjungsu.domain.user.repository.UserRepository;
import com.example.raisingjungsu.global.util.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BadService {
    private final UserRepository userRepository;
    private final AnswerRepository answerRepository;
    private final BadRepository badRepository;

    @Transactional
    public void insertBad(int answer_id){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Answer answer = answerRepository.findById(answer_id).orElseThrow(AnswerNotFoundException::new);

        if(isNotAlreadyBad(answer, user)){
            Bad bad = Bad.builder()
                    .user(user)
                    .answer(answer)
                    .build();
            badRepository.save(bad);
            answer.setBadCount(answer.getBadCount() + 1);
            answerRepository.save(answer);
        }
        else {
            throw new BadAlreadyExistException();
        }
    }

    public void deleteBad(int answer_id){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Answer answer = answerRepository.findById(answer_id).orElseThrow(AnswerNotFoundException::new);
        Bad bad = badRepository.findByUserAndAnswer(user, answer).orElseThrow(BadNotFoundException::new);

        badRepository.delete(bad);

        answer.setBadCount(answer.getBadCount() - 1);
        answerRepository.save(answer);
    }

    private boolean isNotAlreadyBad(Answer answer, User user){
        return badRepository.findByUserAndAnswer(user, answer).isEmpty();
    }
}
