package com.example.ubb.QuizWebsiteBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserQuizSolutionDto {

    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "userId")
    private Long userId;

    @JsonProperty(value = "quizId")
    private Long quizId;

    @JsonProperty(value = "score")
    private Integer score;

    @JsonProperty(value = "total")
    private Integer total;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
