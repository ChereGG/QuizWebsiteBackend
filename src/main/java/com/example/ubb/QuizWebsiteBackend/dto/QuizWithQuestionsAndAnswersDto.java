package com.example.ubb.QuizWebsiteBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QuizWithQuestionsAndAnswersDto extends QuizDto{

    @JsonProperty(value = "questions")
    private List<QuestionDto> questions;


    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }
}
