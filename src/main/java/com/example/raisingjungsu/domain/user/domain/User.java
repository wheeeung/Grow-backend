package com.example.raisingjungsu.domain.user.domain;

import com.example.raisingjungsu.domain.answer.domain.Answer;
import com.example.raisingjungsu.domain.question.domain.Question;
import com.example.raisingjungsu.domain.skin.domain.Skin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String password;

    private String nickname;

    private int coin;

    @Column(length = 999999999)
    private String image;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Question> questionList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Skin> skinList;

    public void editProfile(String nickname, String image){
        this.nickname = nickname;
        this.image = image;
    }

    public void editCoin(int coin){
        this.coin = coin;
    }
}
