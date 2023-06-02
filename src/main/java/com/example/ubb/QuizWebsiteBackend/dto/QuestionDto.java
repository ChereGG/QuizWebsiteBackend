package com.example.ubb.QuizWebsiteBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QuestionDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "quizId")
    private Long quizId;

    @JsonProperty(value = "statement")
    private String statement;

    @JsonProperty(value = "answers")
    private List<AnswerDto> answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }
}
